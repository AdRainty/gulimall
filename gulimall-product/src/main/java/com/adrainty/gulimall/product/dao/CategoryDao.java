package com.adrainty.gulimall.product.dao;

import com.adrainty.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-19 23:00:23
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
