package com.hd.cloud.bo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 
 * @ClassName: IndustryCategoryBo
 * @Description: 行业分类bo
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2018年4月16日 下午3:35:54
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndustryCategoryBo {

	private int id;

	private int pid;// 父ID

	private String name;// 名称

	private String picture = "";// 图片url

	private int sort;// 排序

	private int hasChild;// 是否有子类

	private int recommendFlag;// 推荐标志

	private List<IndustryCategoryBo> childCategory;// 子类集合
}
