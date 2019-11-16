package com.gurkan.dms.controller;

import com.gurkan.dms.bean.DocumentType;
import com.gurkan.dms.service.DocumentTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/document-type")
@Api(value = "document-type")
public class DocumentTypeController {

    @Autowired
    DocumentTypeService documentTypeService;

    @PostMapping("/add")
    @ApiOperation(value = "Add Document Type", notes = "Adding a document type")
    public ResponseEntity add(@RequestParam String type) {
        DocumentType documentType = new DocumentType();
        documentType.setType(type);
        documentType = documentTypeService.add(documentType);
        return ResponseEntity.ok(documentType);
    }

    @GetMapping("/list")
    @ApiOperation(value = "List Document Type", notes = "List all document types")
    public ResponseEntity list() {
        return ResponseEntity.ok(documentTypeService.list());
    }
}
