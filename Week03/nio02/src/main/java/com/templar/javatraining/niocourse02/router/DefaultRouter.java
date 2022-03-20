package com.templar.javatraining.niocourse02.router;

import io.github.kimmking.gateway.router.HttpEndpointRouter;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.List;

public class DefaultRouter implements HttpEndpointRouter {
    @Override
    public String route(FullHttpRequest request, List<String> endpoints) {
        String sysIdInHeader = request.headers().get("sysId");
        System.out.println("router sysId: " + sysIdInHeader);
        Integer sysId = Integer.valueOf(sysIdInHeader);
        if (sysId < 0 || sysId > endpoints.size()) {
            throw new RuntimeException("请求头参数sysId异常");
        }
        return endpoints.get(sysId);
    }
}
