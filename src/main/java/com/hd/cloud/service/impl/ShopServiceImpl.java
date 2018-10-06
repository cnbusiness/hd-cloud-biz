package com.hd.cloud.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.dao.ShopCache;
import com.hd.cloud.dao.ShopDao;
import com.hd.cloud.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Inject
	private ShopDao shopDao;

	@Inject
	private ShopCache shopCache;

	@Override
	public ShopBo getShopByShopId(long shopId) {
		ShopBo shopBo = shopDao.getShopByShopId(shopId);
		if (shopBo != null) {
			int fansCount = shopCache.ShopFansCount(shopId, 0);
			shopBo.setFansCount(fansCount);
		}
		return shopBo;
	}

}
