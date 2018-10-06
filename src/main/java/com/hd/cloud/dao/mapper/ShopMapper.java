package com.hd.cloud.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.ShopBo;

@Mapper
public interface ShopMapper {

	/**
	 * @Title: getShopByShopId
	 * @Description: 查询店铺详情
	 * @Table 2.2.3biz_mobiz_shop_bd (魔商店铺表)
	 */
	@Select("SELECT * FROM biz_mobiz_shop_bd WHERE biz_mobiz_shop_bd_seq=#{shopId} AND active_flag='y' ")
	@Results(value = {
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "merchantId", column = "biz_mobiz_base_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "companyId", column = "biz_mobiz_company_bd_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopCode", column = "mobiz_shop_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "shopName", column = "mobiz_shop_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "address", column = "mobiz_shop_address", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "cityId", column = "pub_city_dict_sd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopPhone", column = "mobiz_shop_phone", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "saleBegintime", column = "mobiz_shop_sale_btime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "saleEndtime", column = "mobiz_shop_sale_etime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "fulltimeType", column = "mobiz_shop_fulltime_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "holidayType", column = "mobiz_shop_holiday_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "logo", column = "mobiz_shop_logo_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "personalityUrl", column = "mobiz_shop_personality_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "backgroundUrl", column = "mobiz_shop_background_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "introduce", column = "mobiz_shop_introduce", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "latitude", column = "mobiz_shop_latitude", javaType = Double.class, jdbcType = JdbcType.DOUBLE),
			@Result(property = "longitude", column = "mobiz_shop_longitude", javaType = Double.class, jdbcType = JdbcType.DOUBLE),
			@Result(property = "services", column = "mobiz_shop_services", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "qrcode", column = "mobiz_shop_qrcode_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "tradeId", column = "biz_trade_dict_bd_seq", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "recommend", column = "mobiz_base_recommend_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "recommendDate", column = "mobiz_base_recommend_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "authType", column = "mobiz_shop_auth_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "authDate", column = "mobiz_shop_auth_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "shopStatus", column = "mobiz_shop_status_itype", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "level", column = "mobiz_shop_star_level", javaType = Double.class, jdbcType = JdbcType.DOUBLE),
			@Result(property = "perConsume", column = "mobiz_shop_per_consume", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	ShopBo getShopByShopId(@Param("shopId") long shopId);
}
