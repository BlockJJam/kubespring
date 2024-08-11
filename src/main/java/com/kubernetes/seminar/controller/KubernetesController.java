package com.kubernetes.seminar.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class KubernetesController {

    private final AsyncService asyncService;
    @GetMapping("/api/stop/before/kill")
    public ResponseEntity<Void> stopBeforeKill() {
        log.info("[STOP-BEFORE] kill spring application!!!");
        asyncService.exitAsync();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/stop/before/ok")
    public ResponseEntity<Void> stopBeforeOkResponse() {
        log.info("[STOP-BEFORE] response ok!!!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/stop/after/kill")
    public ResponseEntity<Void> nonStopAfterKill() {
        log.info("[STOP-AFTER] kill spring application!!!");
        asyncService.exitAsync();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/stop/after/ok")
    public ResponseEntity<Void> stopAfterOkResponse() {
        log.info("[STOP-AFTER] response ok!!!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/before/loop")
    public ResponseEntity<Void> nonScaleOutAfterKill() throws InterruptedException {
//        asyncService.infiniteLoop();
        log.info("[SCALE-BEFORE] infinite loop!!!");

        while(true){
//            log.info("[SCALE-BEFORE] infinite loop!!!");
//            Thread.sleep(1000);
        }
//        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/before/ok")
    public ResponseEntity<Void> scaleBeforeOkResponse() {
        log.info("[SCALE-BEFORE] response ok!!!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/after/loop")
    public ResponseEntity<Void> scaleOutAfterKill() throws InterruptedException {
//        asyncService.infiniteLoop();
        while(true){
//            log.info("[SCALE-AFTER] infinite loop!!!");
//            Thread.sleep(1000);
        }
//        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/after/ok")
    public ResponseEntity<Void> scaleAfterOkResponse() {
        log.info("[SCALE-AFTER] response ok!!!");
        return ResponseEntity.ok().build();
    }
}
