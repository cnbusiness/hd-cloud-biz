package com.hd.cloud.rest;

import javax.inject.Inject;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.service.ShopFansService;
import com.hd.cloud.service.ShopService;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.controller.RestBase;

/**
 * 
 * @ClassName: ShopResource
 * @Description: 店铺
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午10:33:11
 *
 */
@RefreshScope
@RestController
@RequestMapping("shop")
public class ShopResource extends RestBase {

	@Inject
	private ShopService shopService;

	@Inject
	private ShopFansService shopFansService;

	/**
	 * 
	 * @Title: getShopDetail
	 * @param:
	 * @Description: 获取店铺详情
	 * @return BoUtil
	 */
	@ResponseBody
	@RequestMapping(value = "/{shopId}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public BoUtil getShopDetail(@PathVariable("shopId") long shopId) {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		ShopBo shop = shopService.getShopByShopId(shopId);
		if (shop != null) {
			int isFollow = shopFansService.checkShopFans(shopId, getLoginUserID());
			shop.setIsFollow(isFollow);
		}
		bo.setData(shop);
		return bo;
	}
}
