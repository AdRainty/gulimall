package com.adrainty.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.adrainty.common.utils.PageUtils;
import com.adrainty.gulimall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * εεεΊε­
 *
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-20 00:15:36
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

