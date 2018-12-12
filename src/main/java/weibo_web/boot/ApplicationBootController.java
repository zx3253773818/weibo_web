package weibo_web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "weibo_web" })
public class ApplicationBootController {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootController.class, args);
	}

}
