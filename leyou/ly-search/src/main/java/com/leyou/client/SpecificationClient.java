package com.leyou.client;

import com.leyou.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wfl
 * @description
 */

@FeignClient(value = "item-service")
public interface SpecificationClient extends SpecificationApi {
}
