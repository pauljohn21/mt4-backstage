package com.kajie88.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderUtil {
    //自动生成订单号
    public static String getOrderIdByUUId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String machineId = sdf.format(new Date());//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%011d", hashCodeV);
    }
    public static void main(String[] args) {
        String orderNum = getOrderIdByUUId();
        System.out.println(orderNum);
        System.out.println(orderNum.length());
    }
}
