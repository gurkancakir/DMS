package com.gurkan.dms.controller;

import com.gurkan.dms.bean.DocumentType;
import com.gurkan.dms.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("document-type")
public class DocumentTypeController {

    @Autowired
    DocumentTypeService documentTypeService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestParam String type) {
        DocumentType documentType = new DocumentType();
        documentType.setType(type);
        documentType = documentTypeService.add(documentType);
        return ResponseEntity.ok(documentType);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(documentTypeService.list());
    }
}
