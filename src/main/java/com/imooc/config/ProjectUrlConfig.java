package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author: Lillian
 * create: 2019-11-15 15:29
 * description: 项目中的Url管理
 */
@Data
@ConfigurationProperties(prefix = "projecturl")
@Component
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权Url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权Url(扫码登陆)
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */
    public String sell;

}
