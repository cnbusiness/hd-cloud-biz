package com.hd.cloud.service;

import java.util.List;

import com.hd.cloud.bo.IndustryCategoryBo;

/**
 * 
 * @ClassName: IndustryCategoryService
 * @Description: 行业分类服务层
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:42:47
 *
 */
public interface IndustryCategoryService {
	/**
	 * 
	 * @Title: getCategoryByPrId
	 * @param: IndustryCategory
	 *             ind
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
	 * @Title: getCategorys
	 * @param:
	 * @Description: 根据国家码获取所有一级分类
	 * @return List<IndustryCategoryBo>
	 */
	List<IndustryCategoryBo> getOneLevelCategorys(String countryCode);

	/**
	 * 根据Id获取类别名称
	 * 
	 * @param id
	 * @return
	 */
	String getFullName(int id);
}
