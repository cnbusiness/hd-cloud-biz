package com.hd.cloud.dao;

/**
 * 
 * @ClassName: ShopCache
 * @Description: 店铺缓存管理
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午10:03:18
 *
 */
public interface ShopCache {
	/**
	 * 
	* @Title: addShopFans 
	* @param: 
	* @Description: 添加店铺粉丝
	* @return void
	 */
	void addShopFans(Long shopId, Long groupId);

	/**
	 * 
	* @Title: removeShopFans 
	* @param: 
	* @Description: 删除店铺粉丝
	* @return void
	 */
	void removeShopFans(Long shopId, Long groupId);

	/**
	 * 
	* @Title: ShopFansCount 
	* @param: 
	* @Description: 统计店铺粉丝数量
	* @return int
	 */
	int ShopFansCount(Long shopId, int delta);
}
