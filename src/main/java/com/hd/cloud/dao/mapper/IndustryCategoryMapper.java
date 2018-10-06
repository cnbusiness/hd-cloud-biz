package com.hd.cloud.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.hd.cloud.bo.IndustryCategoryBo;

/**
 * 
 * @ClassName: IndustryCategoryMapper
 * @Description: 行业分类
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:39:20
 *
 */
@Mapper
public interface IndustryCategoryMapper {

	/**
	 * @Title: getCategoryByPrId
	 * @Description:根据父类ID获取下级列表
	 * @Table biz_trade_dict_bd 行业分类字典表
	 */
	@Select("SELECT biz_trade_dict_bd_seq,trade_dict_parent_seq,trade_dict_level,trade_dict_internal_code,trade_dict_order,"
			+ " (CASE WHEN (SELECT COUNT(1) FROM biz_trade_dict_bd b WHERE b.trade_dict_parent_seq=a.biz_trade_dict_bd_seq AND b.city_dict_country_code=a.city_dict_country_code and b.active_flag='y')>0  THEN 1 ELSE 0 END)  trade_dict_leaf_itype,"
			+ "trade_dict_pic_url"
			+ " FROM  biz_trade_dict_bd a  WHERE a.trade_dict_parent_seq = #{pid} AND a.city_dict_country_code =#{countryCode} AND a.active_flag='y' ORDER BY a.trade_dict_order ASC ")
	@Results(value = {
			@Result(property = "id", column = "biz_trade_dict_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "pid", column = "trade_dict_parent_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "trade_dict_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "picture", column = "trade_dict_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "sort", column = "trade_dict_order", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "hasChild", column = "trade_dict_leaf_itype", javaType = int.class, jdbcType = JdbcType.INTEGER) })
	List<IndustryCategoryBo> getCategoryByPrId(@Param("pid") int pid, @Param("countryCode") String countryCode);

	/**
	 * @Title: getAllCategory
	 * @Description:获取全部分类
	 * @Table biz_trade_dict_bd 行业分类字典表
	 */
	@Select("SELECT biz_trade_dict_bd_seq,trade_dict_parent_seq,trade_dict_level,trade_dict_internal_code,trade_dict_order,"
			+ "(CASE WHEN (SELECT COUNT(1) FROM biz_trade_dict_bd b WHERE b.trade_dict_parent_seq=a.biz_trade_dict_bd_seq AND b.city_dict_country_code=a.city_dict_country_code and b.active_flag='y')>0  THEN 1 ELSE 0 END)  trade_dict_leaf_itype,"
			+ "trade_dict_pic_url"
			+ " FROM  biz_trade_dict_bd a  WHERE a.city_dict_country_code =#{countryCode} AND a.active_flag='y' ORDER BY a.trade_dict_order ASC ")
	@Results(value = {
			@Result(property = "id", column = "biz_trade_dict_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "pid", column = "trade_dict_parent_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "trade_dict_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "picture", column = "trade_dict_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "sort", column = "trade_dict_order", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "hasChild", column = "trade_dict_leaf_itype", javaType = int.class, jdbcType = JdbcType.INTEGER) })
	List<IndustryCategoryBo> getAllCategory(@Param("countryCode") String countryCode);

	/**
	 * @Title: getOneLevelCategory
	 * @Description:获取全部一级分类
	 * @Table biz_trade_dict_bd 行业分类字典表
	 */
	@Select("SELECT biz_trade_dict_bd_seq,trade_dict_parent_seq,trade_dict_level,trade_dict_internal_code,trade_dict_order,"
			+ "(CASE WHEN (SELECT COUNT(1) FROM biz_trade_dict_bd b WHERE b.trade_dict_parent_seq=a.biz_trade_dict_bd_seq AND b.city_dict_country_code=a.city_dict_country_code and b.active_flag='y')>0  THEN 1 ELSE 0 END)  trade_dict_leaf_itype,"
			+ "trade_dict_pic_url"
			+ " FROM  biz_trade_dict_bd a  WHERE city_dict_country_code =#{countryCode} and trade_dict_level =1 AND active_flag='y' ORDER BY trade_dict_order ASC ")
	@Results(value = {
			@Result(property = "id", column = "biz_trade_dict_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "pid", column = "trade_dict_parent_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "trade_dict_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "picture", column = "trade_dict_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "sort", column = "trade_dict_order", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "hasChild", column = "trade_dict_leaf_itype", javaType = int.class, jdbcType = JdbcType.INTEGER) })
	List<IndustryCategoryBo> getOneLevelCategory(@Param("countryCode") String countryCode);

	/**
	 * @Title: getRecommendCategoryByCity
	 * @Description:获取推荐分类
	 * @Table biz_trade_dict_bd 行业分类字典表,biz_city_trade_br 城市推荐分类表
	 */
	@Select("SELECT d.biz_trade_dict_bd_seq,d.trade_dict_parent_seq,d.trade_dict_level,d.trade_dict_internal_code,d.trade_dict_order,"
			+ " (CASE WHEN (SELECT COUNT(1) FROM biz_trade_dict_bd b WHERE b.trade_dict_parent_seq=d.biz_trade_dict_bd_seq AND b.city_dict_country_code=d.city_dict_country_code and b.active_flag='y')>0  THEN 1 ELSE 0 END)  trade_dict_leaf_itype,"
			+ " d.trade_dict_order,d.trade_dict_pic_url"
			+ " FROM  biz_trade_dict_bd d,biz_city_trade_br c  WHERE  c.biz_trade_dict_bd_seq =d.biz_trade_dict_bd_seq AND"
			+ " d.city_dict_country_code =#{countryCode} and c.pub_city_dict_sd_seq= #{cityId} AND d.active_flag='y' ORDER BY d.trade_dict_order ASC ")
	@Results(value = {
			@Result(property = "id", column = "biz_trade_dict_bd_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "pid", column = "trade_dict_parent_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "trade_dict_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "picture", column = "trade_dict_pic_url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "sort", column = "trade_dict_order", javaType = int.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "hasChild", column = "trade_dict_leaf_itype", javaType = int.class, jdbcType = JdbcType.INTEGER) })
	List<IndustryCategoryBo> getRecommendCategoryByCity(@Param("countryCode") String countryCode,
			@Param("cityId") long cityId);

	/**
	 * @Title: getParentId
	 * @Description:获取上级分类信息
	 * @Table biz_trade_dict_bd 行业分类字典表
	 */
	@Select("SELECT trade_dict_parent_seq,trade_dict_internal_code FROM biz_trade_dict_bd WHERE biz_trade_dict_bd_seq =#{id} AND active_flag='y'")
	@Results(value = {
			@Result(property = "pid", column = "trade_dict_parent_seq", javaType = long.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "trade_dict_internal_code", javaType = String.class, jdbcType = JdbcType.VARCHAR), })
	IndustryCategoryBo getParentId(@Param("id") long id);

}
