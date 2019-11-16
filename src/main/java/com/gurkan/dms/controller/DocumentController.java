package com.gurkan.dms.controller;

import com.github.dozermapper.core.Mapper;
import com.gurkan.dms.bean.Document;
import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.dto.DocumentDto;
import com.gurkan.dms.exception.ValidatorException;
import com.gurkan.dms.service.DocumentService;
import com.gurkan.dms.service.DocumentTemplateService;
import com.gurkan.dms.service.MetadataService;
import com.gurkan.dms.validator.DocumentValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/document")
@Api(value = "document")
public class DocumentController {

    @Autowired
    DocumentTemplateService documentTemplateService;

    @Autowired
    DocumentService documentService;

    @Autowired
    MetadataService metadataService;

    @Autowired
    DocumentValidator validator;

    @Autowired
    Mapper dozerMapper;


    @PostMapping("/add")
    @ApiOperation(value = "Add Document", notes = "Adding a document")
    public ResponseEntity add(@RequestBody DocumentDto documentDto) throws ValidatorException {
        validator.validate(documentDto);
        DocumentTemplate documentTemplate = documentTemplateService.findByDocumentTypeType(documentDto.getDocumentType());
        Document document = dozerMapper.map(documentTemplate, Document.class);
        document.setName(UUID.randomUUID().toString());
        document.setCreateDate(new Date());
        document.setCreateTime(new Date());
        document.setContent(documentDto.getContent());
        document.setMimeType(documentDto.getMimeType());
        document.setAuthorName(documentDto.getAuthorName());

        for (Metadata metadata : documentDto.getMetadatas()) {
            document.getMetadatas().stream()
                    .filter(e -> e.getName().equals(metadata.getName()))
                    .findFirst()
                    .ifPresent(e -> {
                        e.setId(metadataService.findByName(metadata.getName()).getId());
                        e.setValue(metadata.getValue());
                    });
        }
        document = documentService.add(document);
        return ResponseEntity.ok(document);
    }

    @GetMapping("/list")
    @ApiOperation(value = "List Document", notes = "List all documents")
    public ResponseEntity list() {
        return ResponseEntity.ok(documentService.list());
    }

    @GetMapping("/get/{name}/{value}")
    @ApiOperation(value = "Find Document", notes = "Find document using metadata name and value")
    public ResponseEntity get(@PathVariable("name") String name, @PathVariable("value") String value) {
        return ResponseEntity.ok(documentService.findByMetadatasNameAndMetadatasValue(name, value));
    }

    @GetMapping("/list/{documentType}")
    @ApiOperation(value = "List Document", notes = "List document using document type")
    public ResponseEntity list(@PathVariable("documentType") String documentType) {
        return ResponseEntity.ok(documentService.findByDocumentTypeType(documentType));
    }
}
