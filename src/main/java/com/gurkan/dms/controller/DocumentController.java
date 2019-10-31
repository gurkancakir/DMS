package com.gurkan.dms.controller;

import com.gurkan.dms.bean.Document;
import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.converter.DocumentTemplateConverter;
import com.gurkan.dms.dto.DocumentDto;
import com.gurkan.dms.exception.ValidatorException;
import com.gurkan.dms.service.DocumentService;
import com.gurkan.dms.service.DocumentTemplateService;
import com.gurkan.dms.validator.DocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("document")
public class DocumentController {

    @Autowired
    DocumentTemplateService documentTemplateService;

    @Autowired
    DocumentService documentService;

    @Autowired
    DocumentValidator validator;


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody DocumentDto documentDto) throws ValidatorException {
        validator.validate(documentDto);
        DocumentTemplate documentTemplate = documentTemplateService.findByDocumentTypeType(documentDto.getDocumentType());
        DocumentTemplateConverter converter = new DocumentTemplateConverter();
        Document document = converter.convert(documentTemplate);
        document.setContent(documentDto.getContent());
        document.setMimeType(documentDto.getMimeType());
        document.setAuthorName(documentDto.getAuthorName());

        for (Metadata metadata : documentDto.getMetadatas()) {
            document.getMetadatas().stream()
                    .filter(e -> e.getName().equals(metadata.getName()))
                    .findFirst()
                    .ifPresent(e -> e.setValue(metadata.getValue()));
        }
        document = documentService.add(document);
        return ResponseEntity.ok(document);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(documentService.list());
    }

    @GetMapping("/get/{name}/{value}")
    public ResponseEntity get(@PathVariable("name") String name, @PathVariable("value") String value) {
        return ResponseEntity.ok(documentService.findByMetadatasNameAndMetadatasValue(name, value));
    }
}
