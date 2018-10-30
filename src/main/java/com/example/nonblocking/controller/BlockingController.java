package com.example.nonblocking.controller;

import com.example.nonblocking.model.Response;
import com.example.nonblocking.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blocking")
public class BlockingController {

    @Autowired
    private Service<Response> service;

    @GetMapping
    public Response process() throws Exception {
        return service.execute();
    }
}
