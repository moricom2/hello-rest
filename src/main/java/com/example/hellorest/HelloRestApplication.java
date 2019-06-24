package com.example.hellorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableResourceServer // Resource Server 인증 활성화
//@EnableAuthorizationServer // OAuth 인증서버 활성화, Token 발급 및 인증 로직 활성화
							// /oauth/token, /oauth/authorize URI 생성 및 활성화
@SpringBootApplication
@EnableSwagger2
//public class HelloRestApplication extends ResourceServerConfigurerAdapter {
//public class HelloRestApplication {	
public class HelloRestApplication extends SpringBootServletInitializer {	

	@Bean
	public Docket studentAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.example.hellorest"))
			.paths(PathSelectors.regex("/(posts|members).*"))
			.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloRestApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HelloRestApplication.class);
	}
	
	/**
	 * 인증정보(AccessToken)를 DB에 저장(영속화)
	 * @param dataSource
	 * @return
	 */
//	@Bean
//	public TokenStore jdbcTokenStore(DataSource dataSource) {
//		return new JdbcTokenStore(dataSource);
//	}
	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/members/**").permitAll()
//				.antMatchers("/posts/**").authenticated()
//				.antMatchers("/console").permitAll()
//				.antMatchers("/oauth/**").permitAll();
//	}
	
}
