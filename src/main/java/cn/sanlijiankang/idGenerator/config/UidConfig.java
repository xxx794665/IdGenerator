package cn.sanlijiankang.idGenerator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xxeNt
 * On 2020-04-22
 * Description:引入vesta xml配置
 */
@Configuration
@ImportResource(locations = {"classpath:ext/vesta/vesta-rest-main.xml"})
public class UidConfig {
}
