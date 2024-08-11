package com.kubernetes.seminar.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncService {


    @Async
    public void exitAsync(){
        log.info("[ASYNC] exit spring application!!!");
        System.exit(1);
    }


    public void infiniteLoop() {
        List<String> list = new ArrayList<>();
        final int MAX_COUNT = 1000000;
        final String LOREM_IPSUM = "testtesttesttesttesttesttesttesttesttesttesttesttes"
            + "ttesttesttesttesttesttesttesttesttesttesttesttesttestt"
            + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttestt"
            + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
            + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
            + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest";


        while(true){
            list.add(LOREM_IPSUM);
        }
    }

}
