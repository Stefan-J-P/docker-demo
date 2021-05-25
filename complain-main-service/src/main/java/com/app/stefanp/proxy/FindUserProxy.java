package com.app.stefanp.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "complain-users-service")
public interface FindUserProxy
{




}
