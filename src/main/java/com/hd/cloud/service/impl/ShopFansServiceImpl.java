package com.hd.cloud.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.dao.ShopCache;
import com.hd.cloud.dao.ShopDao;
import com.hd.cloud.dao.ShopFansDao;
import com.hd.cloud.service.ShopFansService;
import com.hd.cloud.util.ErrorCode;
import com.hd.cloud.vo.FollowShopVo;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.util.CommonConstantUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShopFansServiceImpl implements ShopFansService {

	@Inject
	private ShopFansDao shopFansDao;

	@Inject
	private ShopDao shopDao;
	
	@Inject
	private ShopCache shopCache;

	@Override
	public BoUtil followShop(FollowShopVo followShopVo) {
		BoUtil boUtil = BoUtil.getDefaultFalseBo();
		long userId = followShopVo.getUserId();
		log.info("FollowShopVo:{},loginUserId:{}", followShopVo, userId);
		long shopId = followShopVo.getShopId();
		int resourceType = followShopVo.getResourceType();
		ShopBo shop = shopDao.getShopByShopId(shopId);
		if (shop == null) {
			boUtil.setCode(ErrorCode.SHOP_DOES_NOT_EXIST);
			return boUtil;
		}
		Date currentDate = new Date();
		// 获取店铺粉丝信息
		ShopFans shopFans = shopFansDao.getShopFans(userId, shopId);
		if (null == shopFans) {// 未曾关注过该店铺
			ShopFans addShopFans = ShopFans.builder().merchantId(shop.getMerchantId()).companyId(shop.getCompanyId())
					.shopId(shopId).groupIds("").userId(userId).viewCount(0).fansStatus(1).lastViewTime(currentDate)
					.consumeFlag(0).lastConsumeTime(null).remark("").resourceType(resourceType).userStatus(2)
					.creater(userId).updater(userId).activeFlag(CommonConstantUtil.ACTIVE_FLAG_Y).build();
			shopFansDao.addShopFans(addShopFans);
		} else {
			if (shopFans.getFansStatus() == 1) {// 已经关注过改店铺
				boUtil.setCode(ErrorCode.YOU_HAD_ATTENTION_THIS_SHOP);
				return boUtil;
			} else {
				ShopFans updateShopFans = ShopFans.builder().merchantId(shop.getMerchantId())
						.companyId(shop.getCompanyId()).shopId(shopId).groupIds("").userId(userId).fansStatus(1)
						.lastViewTime(currentDate).consumeFlag(shopFans.getConsumeFlag())
						.lastConsumeTime(shopFans.getLastConsumeTime()).remark("").resourceType(resourceType)
						.updater(userId).creater(userId).activeFlag(CommonConstantUtil.ACTIVE_FLAG_Y).build();
				shopFansDao.updateShopFans(updateShopFans);
			}
		}

		// 店铺粉丝数量+1
		shopCache.ShopFansCount(shopId, 1);
		return BoUtil.getDefaultTrueBo();
	}

	@Override
	public BoUtil unFollowShop(long userId, long shopId) {
		BoUtil boUtil = BoUtil.getDefaultFalseBo();
		ShopBo shop = shopDao.getShopByShopId(shopId);
		if (shop == null) {
			boUtil.setCode(ErrorCode.SHOP_DOES_NOT_EXIST);
			return boUtil;
		}
		// 获取店铺粉丝信息
		ShopFans shopFans = shopFansDao.getShopFans(userId, shopId);
		if (null == shopFans || shopFans.getFansStatus() == 0) {// 不是该店铺粉丝
			boUtil.setCode(ErrorCode.YOU_HAS_NOT_ATTENTION_THIS_SHOP);
			return boUtil;
		} else {
			log.debug("********************取消关注该店铺开始*************************");
			shopFansDao.unFollowShop(userId, shopId);
			log.debug("********************取消关注该店铺结束*************************");
		}
		// 店铺粉丝总数-1
		shopCache.ShopFansCount(shopId, -1);
		return BoUtil.getDefaultTrueBo();
	}

	@Override
	public int checkShopFans(long shopId, long userId) {
		return shopFansDao.checkShopFans(shopId, userId);
	}

	@Override
	public List<ShopBo> getAllFollowShops(long userId) {
		return shopFansDao.getAllFollowShops(userId);
	}

}
