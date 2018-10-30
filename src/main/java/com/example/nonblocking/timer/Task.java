package com.example.nonblocking.timer;

import com.example.nonblocking.model.Response;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.TimerTask;

public class Task extends TimerTask {

    private DeferredResult<Response> deferredResult;

    public Task(DeferredResult<Response> deferredResult) {
        this.deferredResult = deferredResult;
    }

    @Override
    public void run() {
        if (!deferredResult.isSetOrExpired()) {
            deferredResult.setResult(new Response("Non-blocking"));
        }
    }
}
