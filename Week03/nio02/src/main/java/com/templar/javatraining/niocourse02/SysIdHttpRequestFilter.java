package com.templar.javatraining.niocourse02;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class SysIdHttpRequestFilter implements HttpRequestFilter {

    private static final Integer ILLEGAL_SYS_ID = -1;

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("sysId", getSysIdFromUri(fullRequest.uri()));
    }

    private Integer getSysIdFromUri(String uri) {

        if (null == uri || "".equals(uri)) {
            return ILLEGAL_SYS_ID;
        }
        System.out.println("uri: " + uri);

        try {
            uri = uri.substring(1);
            String sysId = uri.substring(0, uri.indexOf("/"));
            System.out.println("sysId: " + sysId);
            return Integer.parseInt(sysId);
        } catch (Exception e) {
            System.out.println("非法路径");
            return ILLEGAL_SYS_ID;
        }

    }
}
