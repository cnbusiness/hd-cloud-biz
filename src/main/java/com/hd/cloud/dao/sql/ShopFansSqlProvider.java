package com.hd.cloud.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.hd.cloud.bo.ShopFans;

public class ShopFansSqlProvider {
	
	/**
	 * 
	* @Title: updateShopFans 
	* @param: 
	* @Description: 编辑
	* @return String
	 */
	public String updateShopFans(ShopFans shopFans) {
		return new SQL() {
			{
				UPDATE("biz_shop_fans_br");
				SET(" biz_mobiz_base_bd_seq = #{merchantId} ");
				SET(" biz_mobiz_company_bd_seq = #{companyId} ");
				SET(" biz_mobiz_shop_bd_seq = #{shopId} ");
				SET(" biz_shop_fansgroup_br_seqs = #{groupIds} ");
				SET(" shop_fans_status = #{fansStatus} ");
				SET(" last_view = #{lastViewTime} ");
				SET(" consume_flag = #{consumeFlag} ");
				SET(" last_consume = #{lastConsumeTime} ");
				SET(" consume_remark = #{remark} ");
				SET(" shop_fans_source_itype = #{resourceType} "); 
				SET(" update_by = #{updater} ");
				SET(" update_time=now() ");
				 
				if (shopFans.getCreater() > 0) {
					SET(" create_by = #{creater} ");
					SET(" create_time = now() ");
				}
				WHERE(" biz_mobiz_shop_bd_seq = #{shopId} and user_user_base_sb_seq = #{userId} and active_flag='y'");
			}
		}.toString();
	}
}
