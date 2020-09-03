package org.atomiv.template.lite.web.restapi.models;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("org.atomiv.template.lite.web.resapi")).build()
				.apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Swagger Api by Java atomiv.template", "APi reference by Java atomiv.template", "1.0.0",
				"Public API",
				new springfox.documentation.service.Contact("Atomiv Template", "https://github.com/atomiv/atomiv-java",
						"https://github.com/atomiv"),
				"API License", "https://github.com/atomiv/atomiv-java", Collections.emptyList());

	}

}
