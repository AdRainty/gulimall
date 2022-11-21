package com.adrainty.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.adrainty.common.utils.PageUtils;
import com.adrainty.gulimall.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-20 00:11:12
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

