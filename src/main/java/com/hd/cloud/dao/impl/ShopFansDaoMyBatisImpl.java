package com.hd.cloud.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.dao.ShopFansDao;
import com.hd.cloud.dao.mapper.ShopFansMapper;

/**
 * 
 * @ClassName: ShopFansDaoMyBatisImpl
 * @Description: 店铺粉丝
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午9:14:43
 *
 */
@Repository
public class ShopFansDaoMyBatisImpl implements ShopFansDao {

	@Inject
	private ShopFansMapper shopFansMapper;

	@Override
	public void addShopFans(ShopFans shopFans) {
		shopFansMapper.addShopFans(shopFans);
	}

	@Override
	public void unFollowShop(long userId, long shopId) {
		shopFansMapper.unFollowShop(userId, shopId);
	}

	@Override
	public ShopFans getShopFans(long userId, long shopId) {
		return shopFansMapper.getShopFans(userId, shopId);
	}

	@Override
	public void updateShopFans(ShopFans shopFans) {
		shopFansMapper.updateShopFans(shopFans);
	}

	@Override
	public int checkShopFans(long shopId, long userId) {
		return shopFansMapper.checkShopFans(shopId, userId);
	}

	@Override
	public List<ShopBo> getAllFollowShops(long userId) {
		return shopFansMapper.getAllFollowShops(userId);
	}

}
