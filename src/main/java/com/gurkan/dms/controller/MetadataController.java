package com.gurkan.dms.controller;

import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.service.MetadataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/metadata")
@Api(value = "metadata")
public class MetadataController {

    @Autowired
    MetadataService metadataService;

    @PostMapping("/add")
    @ApiOperation(value = "Add Metadata", notes = "Adding a metadata")
    public ResponseEntity add(@RequestParam String name) {
        Metadata metadata = new Metadata();
        metadata.setName(name);
        metadata = metadataService.add(metadata);
        return ResponseEntity.ok(metadata);
    }

    @GetMapping("/list")
    @ApiOperation(value = "List Metadata", notes = "List all metadatas")
    public ResponseEntity list() {
        return ResponseEntity.ok(metadataService.list());
    }
}
