package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.vo.FollowShopVo;
import com.hlb.cloud.bo.BoUtil;

/**
 * 
 * @ClassName: ShopFansService
 * @Description: 店铺粉丝
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午9:16:32
 *
 */
public interface ShopFansService {

	/**
	 * 
	 * @Title: FollowShop
	 * @param: ShopFans
	 *             shopFans
	 * @Description: 关注店铺
	 * @return
	 */
	public BoUtil followShop(FollowShopVo followShopVo);

	/**
	 * 
	 * @Title: UnFollowShop
	 * @param: long
	 *             userId,int shopId
	 * @Description: 取消关注店铺
	 * @return
	 */
	public BoUtil unFollowShop(long userId, long shopId);

	/**
	 * 检测是否为店铺粉丝
	 * 
	 * @param shopId
	 * @param userId
	 * @return
	 */
	int checkShopFans(long shopId, long userId);
	
	/**
	 * 
	 * @Title: getAllFollowShops
	 * @param: long userId
	 * @Description: 获取关注店铺
	 * @return List<ShopBo>
	 */
	List<ShopBo> getAllFollowShops(long userId);

}
