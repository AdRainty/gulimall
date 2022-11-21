package com.adrainty.gulimall.member.feign;

import com.adrainty.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AdRainty
 * @version V1.0.0
 * @date 2022/11/20 14:04
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();

}
