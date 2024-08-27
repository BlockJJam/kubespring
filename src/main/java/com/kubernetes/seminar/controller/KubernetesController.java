package com.kubernetes.seminar.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

@Slf4j
@RequiredArgsConstructor
@RestController
public class KubernetesController {

    private final AsyncService asyncService;

    @GetMapping("/api/stop/before/kill")
    public ResponseEntity<Void> stopBeforeKill() {
        log.info("[STOP-BEFORE] kill spring application!!!");
        asyncService.exitAsync();


        return ResponseEntity.ok().headers(getHeaders()).build();
    }



    @GetMapping("/api/stop/before/ok")
    public ResponseEntity<Void> stopBeforeOkResponse() {
        log.info("[STOP-BEFORE] response ok!!!");
        return ResponseEntity.ok().headers(getHeaders()).build();
    }

    @GetMapping("/api/stop/after/kill")
    public ResponseEntity<Void> nonStopAfterKill() {
        log.info("[STOP-AFTER] kill spring application!!!");
        asyncService.exitAsync();
        return ResponseEntity.ok().headers(getHeaders()).build();
    }

    @GetMapping("/api/stop/after/ok")
    public ResponseEntity<Void> stopAfterOkResponse() {
        log.info("[STOP-AFTER] response ok!!!");
        return ResponseEntity.ok().headers(getHeaders()).build();
    }

    @GetMapping("/api/scale/before/loop")
    public ResponseEntity<Void> nonScaleOutAfterKill() throws InterruptedException {
//        asyncService.infiniteLoop();
        log.info("[SCALE-BEFORE] infinite loop!!!");

        while(true){
//            log.info("[SCALE-BEFORE] infinite loop!!!");
//            Thread.sleep(1000);
            Thread.sleep(1);
        }
//        return ResponseEntity.ok().headers(getHeaders()).build();
    }

    @GetMapping("/api/scale/before/ok")
    public ResponseEntity<Void> scaleBeforeOkResponse() {
        log.info("[SCALE-BEFORE] response ok!!!");
        return ResponseEntity.ok().headers(getHeaders()).build();
    }

    @GetMapping("/api/scale/after/loop")
    public ResponseEntity<Void> scaleOutAfterKill() throws InterruptedException {
//        asyncService.infiniteLoop();
        double a = 0.0001;
        for(int i=0; i < 1000000; i++ ) {
            a = a + Math.sqrt(a);
        }
        log.info("[SCALE-AFTER] infinite loop end!!!");
        return ResponseEntity.ok().headers(getHeaders()).build();
    }

    @GetMapping("/api/scale/after/ok")
    public ResponseEntity<Void> scaleAfterOkResponse() {
        log.info("[SCALE-AFTER] response ok!!!");
        return ResponseEntity.ok().headers(getHeaders()).build();
    }
    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-origin", "*");
        return headers;
    }
}
