package cn.segema.cloud.common.utils;

import java.util.UUID;

public class IdGeneratorUtil {
	
	private static SnowflakeIdWorker snowflakeIdWorker;

	public static synchronized String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}

	public static synchronized long generateSnowFlakeId() {
		return snowflakeIdWorker.nextId();
	}
	
	
}
