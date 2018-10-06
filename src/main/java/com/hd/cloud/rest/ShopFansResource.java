package com.hd.cloud.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.service.ShopFansService;
import com.hd.cloud.vo.FollowShopVo;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.controller.RestBase;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: ShopFansResource
 * @Description: 店铺粉丝
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午10:10:22
 *
 */
@RefreshScope
@RestController
@RequestMapping("shopfans")
public class ShopFansResource extends RestBase {

	@Inject
	private ShopFansService shopFansService;

	/**
	 * 
	 * @Title: followShop
	 * @param:
	 * @Description: 关注商家
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "POST", value = "saveFavorites", notes = "saveFavorites")
	@ResponseBody
	@RequestMapping(value = "/follow", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BoUtil followShop(final @RequestBody FollowShopVo followShopVo) {
		followShopVo.setUserId(getLoginUserID());
		return shopFansService.followShop(followShopVo);
	}

	/**
	 * 
	 * @Title: unFollowShop
	 * @param:
	 * @Description: 取消关注
	 * @return BoUtil
	 */
	@ApiOperation(httpMethod = "PUT", value = "unFollowShop", notes = "unFollowShop")
	@ResponseBody
	@RequestMapping(value = "/unfollowshop", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BoUtil unFollowShop(final @RequestBody FollowShopVo followShopVo) {
		return shopFansService.unFollowShop(getLoginUserID(), followShopVo.getShopId());
	}

	/**
	 * 
	 * @Title: getAllFollowShops
	 * @param:
	 * @Description: 查询用户关注店铺列表
	 * @return BoUtil
	 */
	@ResponseBody
	@RequestMapping(value = "/follow/shops", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public BoUtil getAllFollowShops() {
		BoUtil bo = BoUtil.getDefaultTrueBo();
		List<ShopBo> shopList = shopFansService.getAllFollowShops(getLoginUserID());
		bo.setData(shopList);
		return bo;
	}
}
