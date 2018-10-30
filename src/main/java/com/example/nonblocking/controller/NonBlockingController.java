package com.example.nonblocking.controller;

import com.example.nonblocking.model.Response;
import com.example.nonblocking.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/non-blocking")
public class NonBlockingController {

    @Autowired
    private Service<DeferredResult<Response>> service;

    @GetMapping
    public DeferredResult<Response> process() {
        return service.execute();
    }
}
