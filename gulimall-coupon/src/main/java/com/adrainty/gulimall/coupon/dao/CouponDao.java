package com.adrainty.gulimall.coupon.dao;

import com.adrainty.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-19 23:50:08
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
