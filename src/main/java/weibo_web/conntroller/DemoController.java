package weibo_web.conntroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注解声明，该类为Controller类 并自动加载所需要的其它类
 */
@Controller
@EnableAutoConfiguration
public class DemoController {

	/**
	 * 当访问http://localhost:8080/时候，进入到该方法中 并将返回的内容作为字符串直接返回给浏览嚣
	 *
	 * @return
	 */
	@RequestMapping("/weibo")
	// @ResponseBody
	String index() {
		System.out.println("请求进入Controller");
		return "weibo";
	}

	@RequestMapping("/dynamic")
	String dynamic(ModelMap map) {
		map.put("nickname", "天亮教育");
		return "dynamic";
	}

	@RequestMapping("/dynamic_v2")
	String dynamic(ModelMap map, String nickname) {
		map.put("nickname", nickname);
		return "dynamic";
	}

	// 主方法，像一般的Java类一般去右击run as application时候，执行该方法
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoController.class, args);
	}

}
