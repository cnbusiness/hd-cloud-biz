package com.hd.cloud.dao.impl;

import javax.inject.Inject;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.hd.cloud.dao.ShopCache;
import com.hd.cloud.util.RedisKeyUtil;

@Repository
public class ShopCacheImpl implements ShopCache {

	@Inject
	private RedisTemplate<String, String> redisTemplate;

	private Long curretTime = System.currentTimeMillis();

	@Override
	public void addShopFans(Long shopId, Long groupId) {
		redisTemplate.opsForZSet().add(RedisKeyUtil.shopFansKey(shopId), groupId.toString(), curretTime);
	}

	@Override
	public void removeShopFans(Long shopId, Long groupId) {
		redisTemplate.opsForZSet().remove(RedisKeyUtil.shopFansKey(shopId),groupId.toString());
	}

	
	/**
	 * 店铺粉丝数量
	 * delta = -1 粉丝总数-1 ，delta = 0  获取粉丝总数，  delta = 1 粉丝总数+1
	 * @return 当前粉丝总数
	 */
	@Override
	public int ShopFansCount(Long shopId, int delta) {
		Long incrCount= redisTemplate.opsForValue().increment(RedisKeyUtil.shopFansCount(shopId), delta);
		return incrCount.intValue();
	}

}
