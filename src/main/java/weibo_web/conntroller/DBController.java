package weibo_web.conntroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import weibo_web.manager.WeiboDBManager;

/**
 * 注解声明，该类为Controller类 并自动加载所需要的其它类
 */
@Controller
public class DBController {
	@Autowired
	private WeiboDBManager weiboDBManager;

	@RequestMapping("/hotwords")
	String getHotWords(ModelMap modelMap) {
		List<Map<String, Object>> list = weiboDBManager.getHotWordsList();
		modelMap.put("result", list);
		return "weibo_hotwords";
	}
}
