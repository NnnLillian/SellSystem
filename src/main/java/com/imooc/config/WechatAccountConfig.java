package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author: Lillian
 * create: 2019-08-09 16:33
 * description: 微信账号相关配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    //    商户号
    private String mchId;
    //    商户密钥
    private String mchKey;
    //    商户证书路径
    private String keyPath;
//    微信支付异步通知地址
    private String notifyUrl;
}
