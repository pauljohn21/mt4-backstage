package com.kajie88.bootexplore.controller;

import com.alibaba.fastjson.JSONObject;
import com.kajie88.base.dto.req.BaseReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("paySec")
public class PaySecController {
    public static String generateHash(String plainText, String key) {
        String hashValue = BCrypt.hashpw(plainText, key);
        hashValue = hashValue.replace(key, "");
        return (hashValue);
    }

    public static boolean verifyHash(String plainText, String key, String generatedHash) {
        String hashValue = key + generatedHash;
        boolean isHashverified = BCrypt.checkpw(plainText, hashValue);
        return isHashverified;
    }

    @RequestMapping("getPaySecToken")
    public Map<String, Object> getPaySecToken(@RequestBody BaseReqDTO<Map<String, String>> reqDTO) {
        String bankCode = reqDTO.getParam().get("bankCode");
        String cartId = getCartid()+reqDTO.getParam().get("cartId");
        String orderAmount = reqDTO.getParam().get("orderAmount")+".00";


        String merchantCode = "cbe07be7-8a08-4924-839f-3e3c809ab04f";
        String sampleKey = "$2a$12$HyahAhbjgZhimfRb6NMP/e";
        String currency = "CNY";
        String version = "3.0";
        String channelCode = "BANK_TRANSFER";
        String notifyURL = "https://requestb.in/1b8wtzr1";
        String returnUrl = "https://requestb.in/1dojljy1";

        String sampleString = cartId + ";" + orderAmount + ";" + currency + ";" + merchantCode + ";" + version;
        System.out.println(sampleString);
        try {
            String hash256 = hash256(sampleString);
            String generatedHash = generateHash(hash256, sampleKey);

            Map<String, Object> param = new HashMap<>();
            Map<String, Object> header = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            param.put("header", header);
            param.put("body", body);

            header.put("version", version);
            header.put("merchantCode", merchantCode);
            header.put("signature", generatedHash);

            body.put("channelCode", channelCode);
            body.put("bankCode", bankCode);
            body.put("notifyURL", notifyURL);
            body.put("returnURL", returnUrl);
            body.put("orderAmount", orderAmount);
            body.put("cartId", cartId);
            body.put("orderTime", getCartid());
            body.put("currency", currency);
            System.out.println("请求参数--------------》");
            System.out.println(JSONObject.toJSONString(param));
            String result = doPost("https://payment.allpay.site/api/transfer/v1/payIn/requestToken", JSONObject.toJSONString(param));
            JSONObject jsonObject = JSONObject.parseObject(result);
            if(jsonObject.getJSONObject("header").getString("status").equals("SUCCESS")){
                String token = jsonObject.getJSONObject("body").getString("token");
                System.out.println("请求返回token--------------》");
                System.out.println(JSONObject.toJSONString(jsonObject));
                return new BaseRespDTO().success("token",token).result();
            }else {
                String errorMessage = jsonObject.getJSONObject("header").getString("statusMessage");
                return new BaseRespDTO().error(errorMessage).result();
            }
//            System.out.println(result);
//            System.out.println("Generated Hash is : " + generatedHash);
            // Verify the generated hash with generated String
//            boolean isVerified = verifyHash(hash256, sampleKey, generatedHash);
//            System.out.println("Is hash verified : " + isVerified);
//            System.out.println("\n\n\n\n");
//
//            //JSON format to be sent for payin request token:
//            System.out.println("JSON format to be sent for payin request token");
//            System.out.println("{\"header\" : {");
//            System.out.println("\"version\" : \""+version+"\""+"," );
//            System.out.println("\"merchantCode\" : \""+merchantCode+"\""+"," );
//            System.out.println("\"signature\" : \""+generatedHash+"\"" );
//            System.out.println("},");
//            System.out.println("\"body\" : {");
//            System.out.println("\"channelCode\" : \""+channelCode+"\""+"," );
//            if (bankCode!="")
//                System.out.println("\"bankCode\" : \""+bankCode+"\""+"," );
//            System.out.println("\"notifyURL\" : \""+notifyURL+"\""+"," );
//            System.out.println("\"returnURL\" : \""+returnUrl+"\""+"," );
//            System.out.println("\"orderAmount\" : \""+orderAmount+"\""+"," );
//            System.out.println("\"orderTime\" : \""+cartId+"\""+"," );
//            System.out.println("\"cartId\" : \""+cartId+"\""+"," );
//            System.out.println("\"currency\" : \""+currency+"\"" );
//            System.out.println("}}" );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Generate Hash for Sample String.

        return null;
    }

    public static void main(String[] str) {
        String merchantCode = "cbe07be7-8a08-4924-839f-3e3c809ab04f";
        String sampleKey = "$2a$12$HyahAhbjgZhimfRb6NMP/e";
        String cartId = getCartid();
        String orderAmount = "10.00";
        String currency = "CNY";
        String version = "3.0";
        String channelCode = "BANK_TRANSFER";
        String bankCode = "";
        String notifyURL = "https://requestb.in/1b8wtzr1";
        String returnUrl = "https://requestb.in/1dojljy1";

		/*
		 * How to hash signature for payment request.
		Signature Format:
		cartId;orderAmount;currency;merchantCode;version

		Example:
		Merchant-Transaction-ID-12345;10.00;CNY;d5c35d0b-061a-468d-8e99-a932f2d2f288;3.0

		Hash the string using sha-256, and get the hex value:

		Sha-256(Merchant-Transaction-ID-12345;10.00;CNY;d5c35d0b-061a-468d-8e99-a932f2d2f288;3.0)

		Result is:
		996e31c65264e924049d844096350844a4ad78b89fdd329004286048822b89c3

		Sample Merchant Key:  $2a$12$0AM.m32pqqGmAn8mVsF6Je

		Generate the Hash using the hash value and the Merchant key:

		Bcrypt function will hash using 2 parameters: the hash value and merchant key.

		Bcrypt( (996e31c65264e924049d844096350844a4ad78b89fdd329004286048822b89c3)  ($2a$12$0AM.m32pqqGmAn8mVsF6Je) )

		Generated Hash: aB766/zwrPVUy1a5tKb2NwFBZ4Sgceu
		 */

        String sampleString = cartId + ";" + orderAmount + ";" + currency + ";" + merchantCode + ";" + version;
        System.out.println(sampleString);
        try {
            String hash256 = hash256(sampleString);
            String generatedHash = generateHash(hash256, sampleKey);
            System.out.println("Generated Hash is : " + generatedHash);
            // Verify the generated hash with generated String
            boolean isVerified = verifyHash(hash256, sampleKey, generatedHash);
            System.out.println("Is hash verified : " + isVerified);
            System.out.println("\n\n\n\n");

            //JSON format to be sent for payin request token:
            System.out.println("JSON format to be sent for payin request token");
            System.out.println("{\"header\" : {");
            System.out.println("\"version\" : \"" + version + "\"" + ",");
            System.out.println("\"merchantCode\" : \"" + merchantCode + "\"" + ",");
            System.out.println("\"signature\" : \"" + generatedHash + "\"");
            System.out.println("},");
            System.out.println("\"body\" : {");
            System.out.println("\"channelCode\" : \"" + channelCode + "\"" + ",");
            if (bankCode != "")
                System.out.println("\"bankCode\" : \"" + bankCode + "\"" + ",");
            System.out.println("\"notifyURL\" : \"" + notifyURL + "\"" + ",");
            System.out.println("\"returnURL\" : \"" + returnUrl + "\"" + ",");
            System.out.println("\"orderAmount\" : \"" + orderAmount + "\"" + ",");
            System.out.println("\"orderTime\" : \"" + cartId + "\"" + ",");
            System.out.println("\"cartId\" : \"" + cartId + "\"" + ",");
            System.out.println("\"currency\" : \"" + currency + "\"");
            System.out.println("}}");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Generate Hash for Sample String.


    }

    static String hash256(String sampleStr) throws NoSuchAlgorithmException {
        String sha256hex = DigestUtils.sha256Hex(sampleStr);
        System.out.println("sha256Hex : " + sha256hex);
        return sha256hex;
    }

    static String getCartid() {
        long cartid = System.currentTimeMillis();
        String cartidstring = Long.toString(cartid);
        return cartidstring;
    }

    /**
     * post请求（用于请求json格式的参数）
     *
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            } else {
//                logger.error("请求返回:"+state+"("+url+")");
                System.out.println("请求返回:" + state + "(" + url + ")");
            }
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
