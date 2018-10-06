package com.hd.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowShopVo {
	
	private long shopId;// 店铺Id
	private int resourceType;// 1自主关注，2报名活动关注，3消费关注4 二维码关注5红包关注 
	private long userId;
}
