package cybersoft.backend.java12.gira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("cybersoft.backend.java12.gira"))
				.build()
				.apiInfo(apiInfo());
		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Demo Gira")
				.description("This is a project which has a educational purpose only")
				.contact(new Contact("Minh Hieu", "minhhieu.com", "hieu@gmail.com"))
				.license("MIT2")
				.build();
	}
}