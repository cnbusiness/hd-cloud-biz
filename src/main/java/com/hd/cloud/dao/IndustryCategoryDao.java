package com.hd.cloud.dao;

import java.util.List;

import com.hd.cloud.bo.IndustryCategoryBo;

/**
 * 
 * @ClassName: IndustryCategoryDao
 * @Description: 行业类型
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:37:48
 *
 */
public interface IndustryCategoryDao {
	/**
	 * 
	 * @Title: getCategoryByPrId ind
	 * @Description: 查询行业类型
	 * @return Company
	 */
	List<IndustryCategoryBo> getCategoryByPrId(int pid, String countryCode);

	/**
	 * 
	 * @Title: getAllCategory
	 * @param:
	 * @Description: 根据国家码获取所有分类
	 * @return List<IndustryCategoryBo>
	 */
	List<IndustryCategoryBo> getAllCategory(String countryCode);

	/**
	 * 
	 * @Title: getRecommendCategoryByCity
	 * @param:
	 * @Description: 根据国家码和城市ID获取推荐分类
	 * @return List<IndustryCategoryBo>
	 */
	List<IndustryCategoryBo> getRecommendCategoryByCity(String countryCode, long cityId);

	/**
	 * 
	 * @Title: getRecommendCategoryByCity
	 * @param:
	 * @Description: 根据国家码获取所有一级分类
	 * @return List<IndustryCategoryBo>
	 */
	List<IndustryCategoryBo> getOneLevelCategory(String countryCode);

	/**
	 * 根据ID获取父类ID
	 * 
	 * @param id
	 * @return
	 */
	IndustryCategoryBo getParentId(int id);

}
