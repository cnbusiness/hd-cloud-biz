package com.hd.cloud.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.ShopBo;
import com.hd.cloud.bo.ShopFans;
import com.hd.cloud.dao.sql.ShopFansSqlProvider;

/**
 * 
 * @ClassName: ShopFansMapper
 * @Description: 店铺粉丝
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月17日 上午9:09:29
 *
 */
@Mapper
public interface ShopFansMapper {

	/**
	 * @Title: addShopFans
	 * @Description: 新增店铺粉丝
	 * @Table biz_shop_fans_br 店铺粉丝实体表
	 */
	@Insert("INSERT into biz_shop_fans_br "
			+ " (biz_mobiz_base_bd_seq,biz_mobiz_company_bd_seq,biz_mobiz_shop_bd_seq,biz_shop_fansgroup_br_seqs,user_user_base_sb_seq,shop_fans_view_cnt,shop_fans_status, "
			+ " last_view,consume_flag,last_consume,consume_remark,shop_fans_source_itype,user_base_status_itype,create_by,create_time,update_by,update_time,active_flag) "
			+ " values(#{merchantId},#{companyId},#{shopId},#{groupIds},#{userId},#{viewCount},#{fansStatus}, "
			+ " #{lastViewTime},#{consumeFlag},#{lastConsumeTime},#{remark},#{resourceType},#{userStatus},#{creater},now(),#{updater},now(),#{activeFlag})")
	@SelectKey(keyProperty = "id", before = false, resultType = int.class, statement = {
			"SELECT LAST_INSERT_ID() AS id  " })
	void addShopFans(ShopFans shopFans);

	@Update("UPDATE biz_shop_fans_br SET biz_shop_fansgroup_br_seqs = null,update_by = #{userId},update_time=now(),shop_fans_status = 0 WHERE biz_mobiz_shop_bd_seq=#{shopId} AND user_user_base_sb_seq=#{userId} AND active_flag = 'y'")
	void unFollowShop(@Param("userId") long userId, @Param("shopId") long shopId);

	/**
	 * @Title: updateShopFans
	 * @Description: 编辑店铺粉丝
	 * @Table biz_shop_fans_br 店铺粉丝实体表
	 */
	@UpdateProvider(type = ShopFansSqlProvider.class, method = "updateShopFans")
	void updateShopFans(ShopFans shopFans);

	/**
	 * @Title: getShopFans
	 * @Description: 获取店铺粉丝详情
	 * @Table biz_shop_fans_br 店铺粉丝实体表
	 */
	@Select("select * from biz_shop_fans_br where user_user_base_sb_seq=#{userId} and biz_mobiz_shop_bd_seq=#{shopId} and active_flag='y'")
	@Results(value = {
			@Result(property = "id", column = "biz_shop_fans_br_seq", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "merchantId", column = "biz_mobiz_base_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "companyId", column = "biz_mobiz_company_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "groupIds", column = "biz_shop_fansgroup_br_seqs", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "userId", column = "user_user_base_sb_seq", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "viewCount", column = "shop_fans_view_cnt", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "fansStatus", column = "shop_fans_status", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "lastViewTime", column = "last_view", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "consumeFlag", column = "consume_flag", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "lastConsumeTime", column = "last_consume", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "remark", column = "consume_remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "resourceType", column = "shop_fans_source_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "userStatus", column = "user_base_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "creater", column = "create_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "updater", column = "update_by", javaType = long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "updateTime", column = "update_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "activeFlag", column = "active_flag", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	ShopFans getShopFans(@Param("userId") long userId, @Param("shopId") long shopId);

	/**
	 * 检测是否为店铺粉丝
	 * 
	 * @param shopId
	 * @param userId
	 * @return
	 */
	@Select("SELECT COUNT(1) FROM biz_shop_fans_br WHERE shop_fans_status = 1 and active_flag = 'y' AND biz_mobiz_shop_bd_seq = #{shopId} AND user_user_base_sb_seq = #{userId}")
	int checkShopFans(@Param("shopId") long shopId, @Param("userId") long userId);

	/**
	 * @Title: getAllFollowShops
	 * @Description: 获取我关注的店铺列表
	 * @Table biz_mobiz_shop_bd 魔商店铺表,biz_shop_fans_br 店铺粉丝实体表
	 */
	@Select("SELECT ms.biz_mobiz_shop_bd_seq,ms.biz_mobiz_base_bd_seq,ms.biz_mobiz_company_bd_seq,ms.mobiz_shop_logo_url,ms.mobiz_shop_name,ms.mobiz_shop_introduce,ms.mobiz_shop_auth_itype,ms.mobiz_shop_status_itype,ms.mobiz_shop_internal_code "
			+ " FROM biz_mobiz_shop_bd ms,biz_shop_fans_br sf WHERE ms.biz_mobiz_shop_bd_seq = sf.biz_mobiz_shop_bd_seq AND ms.active_flag = 'y' "
			+ " AND sf.user_user_base_sb_seq = #{userId} and sf.shop_fans_status=1 and sf.active_flag='y'")
	@Results(value = {
			@Result(property = "merchantId", column = "biz_mobiz_base_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "companyId", column = "biz_mobiz_company_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopId", column = "biz_mobiz_shop_bd_seq", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "shopName", column = "mobiz_shop_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "logo", column = "mobiz_shop_logo_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "introduce", column = "mobiz_shop_introduce", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "authType", column = "mobiz_shop_auth_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shopStatus", column = "mobiz_shop_status_itype", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "shopCode", column = "mobiz_shop_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	List<ShopBo> getAllFollowShops(@Param("userId") long userId);
}