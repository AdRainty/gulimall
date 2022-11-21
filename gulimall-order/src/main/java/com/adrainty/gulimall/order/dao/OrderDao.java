package com.adrainty.gulimall.order.dao;

import com.adrainty.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-20 00:11:11
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
