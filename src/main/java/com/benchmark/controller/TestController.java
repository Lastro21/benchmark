package com.benchmark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {

    @RequestMapping(value = "/hello")
    public long rrt() {

        final long startTime = System.currentTimeMillis();

        final ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10_000_000; i++) {
            arrayList.add(i);
        }

        final long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

}
