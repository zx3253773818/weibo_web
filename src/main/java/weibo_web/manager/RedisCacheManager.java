package weibo_web.manager;

import weibo_web.utils.RedisUtil;

public class RedisCacheManager {
	public static RedisUtil redisUtil = null;
	static {
		redisUtil = new RedisUtil("localhost", 6379);
	}

	public static void cache(String key, String value) {
		redisUtil.set(key, value);
	}

	public static String getFromCache(String key) {
		return redisUtil.getString(key);
	}
}
