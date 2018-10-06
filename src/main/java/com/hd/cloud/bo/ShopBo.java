package com.hd.cloud.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: ShopBo
 * @Description: 店铺
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 上午9:54:38
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopBo {

	// 店铺id
	private long shopId;

	// 商家id
	private long merchantId;

	// 公司id
	private long companyId;

	// 店铺内码
	private String shopCode;

	// 店铺名称
	private String shopName;

	// 店铺地址
	private String address;

	// 城市id
	private long cityId;

	// 城市代码串
	private String cityIds;

	// 店铺电话
	private String shopPhone;

	// 营业开始时间
	private String saleBegintime;

	// 营业结束时间
	private String saleEndtime;

	// 是否24小时营业：1是2否0未知
	private int fulltimeType;

	// 是否节假日营业:1是2否0未知
	private int holidayType;

	// 店铺logo
	private String logo;

	// 个性网址
	private String personalityUrl;

	// 店铺背景图片URL
	private String backgroundUrl;

	// 店铺介绍
	private String introduce;

	// 经度
	private double longitude;

	// 纬度
	private double latitude;

	// 店铺服务
	private String services;

	// 店铺二维码
	private String qrcode;

	// 行业分类id
	private int tradeId;

	// 公司资质认证是否通过, 1、待审核2、审核中、3、审核通过、4审核退回
	private int authType;

	// 资质认证时间.
	private String authDate;

	// 店铺状态1正常2屏蔽
	private int shopStatus;

	// 店铺星级
	private double level;

	// 人均消费
	private String perConsume;

	// 推荐
	private int recommend;

	// 推荐时间
	private String recommendDate;
	
	//粉丝数量
	private int fansCount;
	
	//是否关注 1关注，2取消关注
	private int isFollow;

}
