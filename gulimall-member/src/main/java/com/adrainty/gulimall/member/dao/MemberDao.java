package com.adrainty.gulimall.member.dao;

import com.adrainty.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author adrainty
 * @email lemon_173@126.com
 * @date 2022-11-19 23:58:03
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
