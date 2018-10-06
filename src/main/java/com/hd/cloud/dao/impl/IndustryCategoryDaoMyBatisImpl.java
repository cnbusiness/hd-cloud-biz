package com.hd.cloud.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hd.cloud.bo.IndustryCategoryBo;
import com.hd.cloud.dao.IndustryCategoryDao;
import com.hd.cloud.dao.mapper.IndustryCategoryMapper;

/**
 * 
 * @ClassName: IndustryCategoryDaoMyBatisImpl
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:41:57
 *
 */
@Repository
public class IndustryCategoryDaoMyBatisImpl implements IndustryCategoryDao {
	@Inject
	private IndustryCategoryMapper industryCategory;

	@Override
	public List<IndustryCategoryBo> getCategoryByPrId(int pid, String countryCode) {
		return industryCategory.getCategoryByPrId(pid, countryCode);
	}

	@Override
	public List<IndustryCategoryBo> getAllCategory(String countryCode) {
		return industryCategory.getAllCategory(countryCode);
	}

	@Override
	public List<IndustryCategoryBo> getRecommendCategoryByCity(String countryCode, long cityId) {
		return industryCategory.getRecommendCategoryByCity(countryCode, cityId);
	}

	@Override
	public List<IndustryCategoryBo> getOneLevelCategory(String countryCode) {
		return industryCategory.getOneLevelCategory(countryCode);
	}

	@Override
	public IndustryCategoryBo getParentId(int id) {
		return industryCategory.getParentId(id);
	}

}
