package com.hd.cloud.dao.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.dao.ShopDao;
import com.hd.cloud.dao.mapper.ShopMapper;

@Repository
public class ShopDaoMyBatisImpl implements ShopDao{

	@Inject
	private ShopMapper shopMapper;
	
	@Override
	public ShopBo getShopByShopId(long shopId) {
		return shopMapper.getShopByShopId(shopId);
	}

}
