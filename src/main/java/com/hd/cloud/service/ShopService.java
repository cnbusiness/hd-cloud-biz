package com.hd.cloud.service;


import com.hd.cloud.bo.ShopBo;
/**
 * 
  * @ClassName: ShopService
  * @Description: 店铺管理
  * @author ShengHao shenghaohao@hadoop-tech.com
  * @Company hadoop-tech 
  * @date 2018年4月17日 上午9:25:48
  *
 */
public interface ShopService {

	/**
	 * 
	* @Title: getShopByShopId 
	* @param: 
	* @Description: 查询店铺详情
	* @return ShopBo
	 */
	public ShopBo getShopByShopId(long shopId);
}
