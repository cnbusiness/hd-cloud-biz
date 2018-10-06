package com.hd.cloud.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hd.cloud.bo.IndustryCategoryBo;
import com.hd.cloud.service.IndustryCategoryService;

/**
 * 
 * @ClassName: IndustryCategoryServiceImpl
 * @Description: 行业分类服务层实现
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:43:28
 *
 */
@Service
public class IndustryCategoryServiceImpl implements IndustryCategoryService {

	@Inject
	private com.hd.cloud.dao.IndustryCategoryDao industryCategoryDao;

	@Override
	public List<IndustryCategoryBo> getCategoryByPrId(int pid, String countryCode) {
		return industryCategoryDao.getCategoryByPrId(pid, countryCode);
	}

	@Override
	public List<IndustryCategoryBo> getAllCategory(String countryCode) {
		return industryCategoryDao.getAllCategory(countryCode);
	}

	@Override
	public List<IndustryCategoryBo> getRecommendCategoryByCity(String countryCode, long cityId) {
		return industryCategoryDao.getRecommendCategoryByCity(countryCode, cityId);
	}

	@Override
	public List<IndustryCategoryBo> getOneLevelCategorys(String countryCode) {
		return industryCategoryDao.getOneLevelCategory(countryCode);
	}

	/**
	 * 获取分类全路径
	 */
	@Override
	public String getFullName(int id) {
		String name = "";
		int parent = 0;
		// 获取上级分类
		IndustryCategoryBo bo = industryCategoryDao.getParentId(id);
		if (bo != null) {
			name = bo.getName();
			parent = bo.getPid();
			// 循环获取上级分类直到一级分类
			while (parent != 0) {
				bo = industryCategoryDao.getParentId(parent);
				if (bo != null) {
					name = bo.getName() + "/" + name;
					parent = bo.getPid();
				}
			}

		}
		return name;

	}

}
