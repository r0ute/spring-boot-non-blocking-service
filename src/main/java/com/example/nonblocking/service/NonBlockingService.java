package com.example.nonblocking.service;

import com.example.nonblocking.model.Response;
import com.example.nonblocking.timer.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Timer;

@org.springframework.stereotype.Service
public class NonBlockingService implements Service<DeferredResult<Response>> {

    private Timer timer = new Timer();

    @Value("${service.delay}")
    private int delay;

    @Override
    public DeferredResult<Response> execute() {
        DeferredResult<Response> result = new DeferredResult<>();
        timer.schedule(new Task(result), delay);

        return result;
    }
}
