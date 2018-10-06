package com.hd.cloud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: CompanyBo
 * @Description: 公司信息bo
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 上午9:42:47
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBo {

	// 公司id
	private long companyId;

	// 商家id
	private long merchantId;

	// 公司内码
	private String companyCode;

	// 公司名称
	private String companyName;

	// 城市id
	private long cityId;

	// 城市代码串
	private String cityIds;

	// 营业执照号
	private String businessLicense;

	// 审核状态 1、待审核2、审核中、3、审核通过、4审核退回
	private int status;

	// 资质认证最后审核人
	private long checkUserId;

	// 最后审核时间
	private String checkDate;

	// 提交时间
	private String commitDate;

	// 身份证
	private String idCard;

	// 身份证正面
	private String idCardBackUrl;

	// 身份证反面
	private String idCardFrontUrl;

	// 执照照片
	private String licensePicUrl;

	// 法人姓名
	private String corporater;

	// 法人手机号
	private String corporaterPhone;

	// 地址
	private String address;

	// 公司规模类型:1公司2个体户3个人
	private int type;

	// 公司联系人
	private String contacter;

	// 公司联系人电话
	private String contactPhone;

	// 公司联系人邮件
	private String contactEmail;

	// 备注
	private String remark;

}
