package com.kajie88.bootexplore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kajie88.base.dto.req.BaseReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.po.Notice;
import com.kajie88.base.utils.FileTransformUtil;
import com.kajie88.bootexplore.learntest.LearnTest;
import com.kajie88.system.domain.NoticeDomain;
import com.kajie88.system.service.NoticeService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kajie
 * Date: 2018/5/18 0018
 * Time: 9:49
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private LearnTest lt;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("showParam")
    public Object testInter(){
        return "222";
    }

    @RequestMapping("writeImg")
    public Object writeImg() throws IOException {
        byte[] bytes = FileTransformUtil.getBytes("D:/test.jpg");
        NoticeDomain queryDomain = new NoticeDomain();
        queryDomain.setTitle("测试");
        queryDomain.setPicturePath(bytes);
        noticeService.insertDomain(queryDomain);
        return "";
    }

    @RequestMapping("testParam")
    public Map<String,Object> testParam(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        String id = reqDTO.getParam().get("id");
        Map<String,Object> result = new HashMap<>();
        result.put("request","传入的ID是："+id);
        return new BaseRespDTO().success("info",result).result();
    }


    @RequestMapping("showImg")
    public Object showImg() throws IOException {
        NoticeDomain noticeDomain = new NoticeDomain();
        noticeDomain.setId(1);
        NoticeDomain domainByQuery = noticeService.getDomainByQuery(noticeDomain);
        return domainByQuery;
    }

    @RequestMapping("pingMt4Remote")
    public Object pingMt4Remote() throws IOException {
        Map<String,Object> param = new HashMap<>();
        param.put("api_key","vNa1mgS3w6b2rfQgngNj9L2Vuj0Gofh0");
        param.put("action","initTransaction");
        param.put("Amount","100");
        param.put("currency","CNY");
        param.put("client_ip","106.48.12.51");
        String sss = JSONObject.toJSONString(param);
        return TestController.doPost("https://www.funtopay.com/hefu/deposit/?" +
                "api_key=vNa1mgS3w6b2rfQgngNj9L2Vuj0Gofh0" +
                        "&action=initTransaction" +
                        "Amount=100" +
                        "currency=CNY" +
                        "client_ip=47.96.174.137"
                ,JSON.parseObject(sss));
    }

    /**
     * post请求
     * @param url
     * @param json
     * @return
     */
    public static JSONObject doPost(String url, JSONObject json){

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
//            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
