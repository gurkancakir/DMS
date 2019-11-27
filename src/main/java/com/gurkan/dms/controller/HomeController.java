package com.gurkan.dms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {

    @GetMapping("/")
    public RedirectView home() {
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("/actuator/health")
    public ResponseEntity health() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/actuator/info")
    public ResponseEntity info() {
        return ResponseEntity.ok(true);
    }
}
