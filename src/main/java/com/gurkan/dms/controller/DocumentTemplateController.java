package com.gurkan.dms.controller;

import com.github.dozermapper.core.Mapper;
import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.bean.DocumentType;
import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.dto.DocumentTemplateDto;
import com.gurkan.dms.exception.ValidatorException;
import com.gurkan.dms.service.DocumentTemplateService;
import com.gurkan.dms.service.DocumentTypeService;
import com.gurkan.dms.service.MetadataService;
import com.gurkan.dms.validator.DocumentTemplateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("document-template")
public class DocumentTemplateController {

    @Autowired
    DocumentTemplateService documentTemplateService;

    @Autowired
    DocumentTypeService documentTypeService;

    @Autowired
    MetadataService metadataService;

    @Autowired
    DocumentTemplateValidator validator;

    @Autowired
    Mapper dozerMapper;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody DocumentTemplateDto documentTemplateDto) throws ValidatorException {
        validator.validate(documentTemplateDto);
        DocumentType documentType = documentTypeService.findByType(documentTemplateDto.getType());
        DocumentTemplate documentTemplate = dozerMapper.map(documentTemplateDto, DocumentTemplate.class);
        documentTemplate.setDocumentType(documentType);
        for (Metadata metadata : documentTemplateDto.getMetadatas()) {
            documentTemplate.getMetadatas().stream()
                    .filter(e -> e.getName().equals(metadata.getName()))
                    .findFirst()
                    .ifPresent(e -> e.setId(metadataService.findByName(metadata.getName()).getId()));
        }
        documentTemplate = documentTemplateService.add(documentTemplate);
        return ResponseEntity.ok(documentTemplate);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(documentTemplateService.list());
    }

}
