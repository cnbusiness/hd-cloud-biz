package com.hd.cloud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: MobizBaseBo
 * @Description: 商家信息Bo
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 上午9:35:40
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobizBaseBo {

	// id
	private long merchantId;

	// 用户id
	private long userId;

	// 商家内码
	private String internalCode;

	// 商家名称
	private String merchantName;

	//国家码
	private String countryCode;
}
