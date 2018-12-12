package weibo_web.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	private Jedis jedis;

	public RedisUtil(String host, int port) {
		jedis = new Jedis(host, port);
		jedis.auth("tianliangedu");
	}

	public void set(String key, String value) {
		jedis.set(key, value);
	}

	public String getString(String key) {
		return jedis.get(key);
	}
}
