package com.example.nonblocking.service;

import com.example.nonblocking.model.Response;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service
public class BlockingService implements Service<Response> {

    @Value("${service.delay}")
    private int delay;

    @Override
    public Response execute() {
        try {
            Thread.sleep(delay);
        } finally {
            return new Response("Blocking");
        }
    }
}
