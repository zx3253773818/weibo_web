package weibo_web.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 注解声明,可以自动引入其它类、或被其它类引入
 */
@Component
public class WeiboDBManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getHotWordsList() {
		String sql = "select * from weibo_hot_words where week_seq='week1';";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	public JSONArray getHotWordsJsonArray() {
		// 得到List集合形式的数据
		List<Map<String, Object>> list = this.getHotWordsList();
		// 将list转化成json array
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = null;
		for (Map<String, Object> map : list) {
			jsonObj = new JSONObject();
			Object word = map.get("word");
			Object freq = map.get("freq");

			jsonObj.put("name", word.toString());
			jsonObj.put("value", freq.toString());
			jsonArray.add(jsonObj);
		}
		return jsonArray;
	}

}
