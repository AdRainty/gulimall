package com.adrainty.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.adrainty.common.utils.PageUtils;
import com.adrainty.gulimall.coupon.entity.SeckillSkuRelationEntity;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-19 23:50:08
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

