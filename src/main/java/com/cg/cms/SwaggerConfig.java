package com.cg.cms;

import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("customer-api").apiInfo(apiInfo()).select().paths(postPaths()).build();
		
	}
	
	
	private Predicate<String> postPaths(){
		return or(regex("/customers/.*"), regex("/customer/.*"));
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Customer Api").description("Praveen Api refrence for developers")
				.termsOfServiceUrl("http://r99praveen.com").license("praveen license").licenseUrl("r889481@gmail.com").version("1.0").build();
		
	}

}
