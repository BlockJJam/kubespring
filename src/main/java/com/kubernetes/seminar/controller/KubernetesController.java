package com.kubernetes.seminar.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KubernetesController {
    static final int MAX_COUNT = 1000000;
    @GetMapping("/api/stop/before/kill")
    public ResponseEntity<Void> stopBeforeKill() {
        log.info("[STOP-BEFORE] kill spring application!!!");
        System.exit(1);
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
        System.exit(1);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/stop/after/ok")
    public ResponseEntity<Void> stopAfterOkResponse() {
        log.info("[STOP-AFTER] response ok!!!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/before/loop")
    public ResponseEntity<Void> nonScaleOutAfterKill() throws InterruptedException {
        List<String> list = new ArrayList<>();
        for(int i=0; i< MAX_COUNT; i++) {
            log.info("[SCALE-BEFORE] loop i: {}", i);
            list.add("testtesttesttesttesttesttesttesttesttesttesttesttes"
                + "ttesttesttesttesttesttesttesttesttesttesttesttesttestt"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttestt"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
            Thread.sleep(500);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/before/ok")
    public ResponseEntity<Void> scaleBeforeOkResponse() {
        log.info("[SCALE-BEFORE] response ok!!!");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/after/loop")
    public ResponseEntity<Void> scaleOutAfterKill() throws InterruptedException {
        List<String> list = new ArrayList<>();
        for(int i=0; i< MAX_COUNT; i++) {
            log.info("[SCALE-AFTER] loop i: {}", i);
            list.add("testtesttesttesttesttesttesttesttesttesttesttesttes"
                + "ttesttesttesttesttesttesttesttesttesttesttesttesttestt"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttestt"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"
                + "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
            Thread.sleep(500);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scale/after/ok")
    public ResponseEntity<Void> scaleAfterOkResponse() {
        log.info("[SCALE-AFTER] response ok!!!");
        return ResponseEntity.ok().build();
    }
}
