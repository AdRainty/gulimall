package com.adrainty.gulimall.order.dao;

import com.adrainty.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-20 00:11:11
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
