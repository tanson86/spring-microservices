package com.example.microservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	/***
	 * Java way of doing the same configuration in the yml file
	 *
	 @Bean
	 public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
	 {
	 return routeLocatorBuilder.routes()
	 .route(p ->p
	 .path("/emp/**")
	 .filters(f -> f.circuitBreaker(c->c.setName("employeeServiceCircuitBreaker").setFallbackUri("/employeeServiceFallBack")))
	 .uri("http://localhost:8082"))
	 .route(p ->p
	 .path("/dept/**")
	 .filters(f -> f.circuitBreaker(c->c.setName("departmentServiceCircuitBreaker").setFallbackUri("/departmentServiceFallBack")))
	 .uri("http://localhost:8081"))
	 .build();
	 }

	 @Bean
	 public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer()
	 {
	 return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
	 .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
	 .timeLimiterConfig(TimeLimiterConfig.custom()
	 .timeoutDuration(Duration.ofSeconds(2)).build()).build());
	 }
	 */
}
