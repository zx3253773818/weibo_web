package weibo_web.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import weibo_web.manager.RedisCacheManager;
import weibo_web.manager.WeiboDBManager;

import com.alibaba.fastjson.JSONArray;

@Controller
public class WordCloudController {
	@Autowired
	private WeiboDBManager weiboDBManager;

	@RequestMapping("/wordcloud_original")
	String getHotWordsOriginal(ModelMap modelMap) {
		return "wordCloud";
	}

	@RequestMapping("/wordcloud")
	String getHotWords(ModelMap modelMap) {
		String result = RedisCacheManager.getFromCache("hotsword");
		if (result == null) {
			JSONArray jsonArray = weiboDBManager.getHotWordsJsonArray();
			result = jsonArray.toJSONString();
			RedisCacheManager.cache("hotsword", result);
		}
		modelMap.put("result", result);
		return "wordCloud2";
	}

	// 主方法，像一般的Java类一般去右击run as application时候，执行该方法
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WordCloudController.class, args);
	}

}
