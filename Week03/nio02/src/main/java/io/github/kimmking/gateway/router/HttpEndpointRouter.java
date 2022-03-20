package io.github.kimmking.gateway.router;

import io.netty.handler.codec.http.FullHttpRequest;

import java.util.List;

public interface HttpEndpointRouter {
    
    String route(FullHttpRequest request, List<String> endpoints);
    
    // Load Balance
    // Random
    // RoundRibbon
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}
