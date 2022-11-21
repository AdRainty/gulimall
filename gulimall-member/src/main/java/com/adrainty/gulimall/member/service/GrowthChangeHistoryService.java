package com.adrainty.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.adrainty.common.utils.PageUtils;
import com.adrainty.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-19 23:58:03
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

