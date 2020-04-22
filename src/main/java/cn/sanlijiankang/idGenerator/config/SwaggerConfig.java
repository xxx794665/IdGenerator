package cn.sanlijiankang.idGenerator.config;

import cn.hutool.core.date.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxeNt
 * On 2020-04-22
 * Description:Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    String today = DateUtil.today();

    @Bean
    public Docket createRestApi() {
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
                .build().globalOperationParameters(parameters);
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//        		.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

    //Swagger API配置
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("通用全局id生成器").description("此文档仅供开发人员使用与参考").contact(new Contact("路欢", "https://github.com/xxx794665", "xxx794665@gmail.com")).version("Version" + today).build();
    }
}
