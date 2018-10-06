package com.hd.cloud.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hd.cloud.bo.IndustryCategoryBo;
import com.hd.cloud.service.IndustryCategoryService;
import com.hlb.cloud.bo.BoUtil;
import com.hlb.cloud.controller.RestBase;
import com.hlb.cloud.util.CommonErrorCode;

/**
 * 
 * @ClassName: IndustryCategoryResource
 * @Description: 行业类型
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:46:40
 *
 */
@RefreshScope
@RestController
@RequestMapping("industry")
public class IndustryCategoryResource extends RestBase {

	@Inject
	private IndustryCategoryService industryCategoryService;

	/**
	 * 
	 * @Title: getAllCategory
	 * @param:
	 * @Description: 获取全部分类
	 * @return BoUtil
	 */
	@ResponseBody
	@RequestMapping(value = "/allcategorys", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public BoUtil getAllCategory(@QueryParam("countryCode") String countryCode) {
		BoUtil bo = BoUtil.getDefaultFalseBo();
		List<IndustryCategoryBo> returnList = new ArrayList<IndustryCategoryBo>();
		if (StringUtils.isBlank(countryCode)) {
			countryCode = "cn";
		}
		returnList = industryCategoryService.getOneLevelCategorys(countryCode);
		if (returnList.size() > 0) {
			for (IndustryCategoryBo ca : returnList) {
				// 获取二级分类
				List<IndustryCategoryBo> childCategory = industryCategoryService.getCategoryByPrId(ca.getId(),
						countryCode);
				ca.setChildCategory(childCategory);
			}
		}
		bo.setData(returnList);
		return bo;
	}

	/**
	 * 
	 * @Title: getCategoryChildrenByPrId
	 * @param:
	 * @Description: 根据上级分类找子类集合
	 * @return BoUtil
	 */
	@ResponseBody
	@RequestMapping(value = "/categorys", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public BoUtil getCategoryChildrenByPrId(@QueryParam("pid") Integer pid,
			@QueryParam("countryCode") String countryCode) {
		BoUtil bo = BoUtil.getDefaultFalseBo();
		pid = pid == null ? 0 : pid;
		if (StringUtils.isBlank(countryCode)) {
			countryCode = "cn";
		}
		List<IndustryCategoryBo> reuturnInd = industryCategoryService.getCategoryByPrId(pid, countryCode);
		bo.setResult(true);
		bo.setCode(CommonErrorCode.SUCCESS);
		bo.setMsg("success");
		Map<String, List<IndustryCategoryBo>> reMap = new HashMap<String, List<IndustryCategoryBo>>();
		reMap.put("list", reuturnInd);
		bo.setData(reMap);
		return bo;
	}

}
