package com.kajie88.bootexplore.configuration;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.kajie88.bootexplore.interceptor.ProcessInterceptor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RestControllerAdvice
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {
    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new ProcessInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // 1.需要先定义一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastJson的配置信息,比如，是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 空值特别处理
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,  //结果是否格式化,默认为false
                SerializerFeature.WriteMapNullValue,//null值也会返回字段
                SerializerFeature.WriteNullListAsEmpty, //将Collection类型字段的字段空值输出为[]
                SerializerFeature.WriteNullStringAsEmpty,//将字符串类型字段的空值输出为空字符串 ""
                SerializerFeature.WriteNullNumberAsZero,//将数值类型字段的空值输出为0
                SerializerFeature.WriteNullBooleanAsFalse,//将Boolean类型字段的空值输出为false
                SerializerFeature.WriteDateUseDateFormat,//全局修改日期格式 yyyy-MM-dd
                SerializerFeature.WriteNonStringValueAsString
        );
        //日期格式化
//    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        // 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        // 3.在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4.将convert添加到converters当中
        converters.add(fastConverter);
    }
}

