package com.templar.javatraining.niocourse02;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, HttpObject httpObject) throws Exception {
        if(httpObject instanceof HttpRequest){
            // 判断是否是 Http请求
            System.out.println(context.pipeline().hashCode());
            System.out.println(httpObject.hashCode());
            System.out.println(context.channel().remoteAddress());

            HttpRequest request = (HttpRequest) httpObject;
            URI uri = new URI(request.uri());
            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了 favicon.ico 。。");
                return ;
            }

            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,我是服务端...", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
            context.writeAndFlush(response);
        }
    }
}
