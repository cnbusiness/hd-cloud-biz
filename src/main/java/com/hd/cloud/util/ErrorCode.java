package com.hd.cloud.util;

/**
 * 
 * @ClassName: ErrorCode
 * @Description: 错误码
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2017年11月20日 下午5:27:10
 *
 */
public class ErrorCode {

	//  店铺不存在
	public final static String SHOP_DOES_NOT_EXIST = "hd0020001";

	// 您已关注该店铺
	public final static String YOU_HAD_ATTENTION_THIS_SHOP = "hd0020002";

	// 您还没有关注该店铺
	public final static String YOU_HAS_NOT_ATTENTION_THIS_SHOP = "hd0020003";

	// 请输入电话号码
	public final static String PHONE_EMPTY = "hd0020004";

	// userId不能为空
	public final static String USERID_IS_EMPTY = "hd0020005";

	// token不能为空
	public final static String TOKEN_IS_EMPTY = "hd0020006";

	// token验证失败
	public final static String TOKEN_FAIL = "hd0020007";
}
