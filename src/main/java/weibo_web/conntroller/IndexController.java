package weibo_web.conntroller;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解声明，该类为Controller类 并自动加载所需要的其它类
 */
@Controller
public class IndexController {
	/**
	 * 当访问http://localhost:8080/时候，进入到该方法中 并将返回的内容作为字符串直接返回给浏览嚣
	 * 
	 * @return
	 */
	@RequestMapping("/")
	String index() {
		return "index";
	}

	// 主方法，像一般的Java类一般去右击run as application时候，执行该方法
	public static void main(String[] args) throws Exception {
		SpringApplication.run(IndexController.class, args);
	}

}
