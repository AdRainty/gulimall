package com.adrainty.gulimall.order.dao;

import com.adrainty.gulimall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-20 00:11:12
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
