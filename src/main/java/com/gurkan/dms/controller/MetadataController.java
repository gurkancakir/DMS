package com.gurkan.dms.controller;

import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("metadata")
public class MetadataController {

    @Autowired
    MetadataService metadataService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestParam String name) {
        Metadata metadata = new Metadata();
        metadata.setName(name);
        metadata = metadataService.add(metadata);
        return ResponseEntity.ok(metadata);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(metadataService.list());
    }
}
