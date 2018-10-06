package com.hd.cloud.util;

public class RedisKeyUtil {

	public static final String SHOP = "SHOP:";
	public static final String FOLLOWERS = ":FOLLOWERS";
	public static final String GROUP = ":GROUP";
	public static final String FANSCNT = ":FANSCNT";

	public static final String shopFansKey(long shopId) { // value is ZSET
		return SHOP + shopId + FOLLOWERS;
	}

	public static final String shopGroupKey(long shopId) {// value is LIST
		return SHOP + shopId + GROUP;
	}

	public static final String groupFansKey(long shopId, long groupId) { // value is ZSET
		return SHOP + shopId + ":" + groupId;
	}

	public static final String shopFansCount(long shopId) {// value is value
		return SHOP + shopId + FANSCNT;
	}

}
