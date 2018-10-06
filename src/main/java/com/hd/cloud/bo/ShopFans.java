package com.hd.cloud.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: ShopFans
 * @Description: 店铺粉丝
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午9:06:00
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopFans {

	private int id;// 主键Id

	private long merchantId;// 魔商Id

	private long companyId;// 公司Id

	private long shopId;// 店铺Id

	private String groupIds;// 店铺分组Id串

	private long userId;// 用户Id

	private int viewCount;// 访问店铺次数

	private int fansStatus;// 状态：1关注，0取消关注

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastViewTime;// 最近访问时间

	private int consumeFlag;// 是否有消费，0为未有消费，1为有消

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastConsumeTime;// 最近消费时间

	private String remark;// 备注

	private int resourceType;// 关注来源,1自主关注，2二维码关注

	private int userStatus;// 用户状态 1正常 2待激活3冻结

	private long creater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	private long updater;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	private String activeFlag;
}
