package ArgProgramaBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ArgProgramaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgProgramaBackApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedOrigins("http://localhost:4200", "https://argprograma-front-laubert.web.app")
					.allowCredentials(true)
					.allowedHeaders("*")
					.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
