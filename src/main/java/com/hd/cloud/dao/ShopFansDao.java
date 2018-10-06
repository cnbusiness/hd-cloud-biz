package com.hd.cloud.dao;

import java.util.List;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.bo.ShopFans;

/**
 * 
 * @ClassName: ShopFansDao
 * @Description: 店铺粉丝
 * @author yao.jie@moxiangroup.com
 * @Company moxian
 * @date 2015年5月29日 下午16:11
 *
 */
public interface ShopFansDao {

	/**
	 * 
	 * @Title: addShopFans
	 * @param: ShopFans
	 *             shopFans
	 * @Description: 新增粉丝
	 * @return
	 */
	void addShopFans(ShopFans shopFans);

	/**
	 * 
	 * @Title: unFollowShop
	 * @param:
	 * @Description: 取消关注店铺
	 * @return
	 */
	void unFollowShop(long userId, long shopId);

	/**
	 * 
	 * @Title: updateShopFans
	 * @param:
	 * @Description: 编辑粉丝
	 * @return
	 */
	void updateShopFans(ShopFans shopFans);

	/**
	 * 
	 * @Title: getShopFans
	 * @param: long
	 *             userId,int shopId
	 * @Description: 获取粉丝信息
	 * @return ShopFans
	 */
	ShopFans getShopFans(long userId, long shopId);
	
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
