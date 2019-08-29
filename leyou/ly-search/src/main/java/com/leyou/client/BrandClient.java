package com.leyou.client;

import com.leyou.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wfl
 * @description
 */
@FeignClient(value = "item-service")
public interface BrandClient extends BrandApi {
}
