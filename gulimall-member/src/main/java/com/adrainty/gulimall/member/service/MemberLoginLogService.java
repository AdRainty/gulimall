package com.adrainty.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.adrainty.common.utils.PageUtils;
import com.adrainty.gulimall.member.entity.MemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-19 23:58:03
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

