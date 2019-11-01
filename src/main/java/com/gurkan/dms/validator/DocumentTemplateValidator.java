package com.gurkan.dms.validator;

import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.bean.DocumentType;
import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.dto.DocumentTemplateDto;
import com.gurkan.dms.exception.ValidatorException;
import com.gurkan.dms.interfaces.IValidator;
import com.gurkan.dms.service.DocumentTemplateService;
import com.gurkan.dms.service.DocumentTypeService;
import com.gurkan.dms.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentTemplateValidator implements IValidator<DocumentTemplateDto> {

    @Autowired
    DocumentTemplateService documentTemplateService;

    @Autowired
    DocumentTypeService documentTypeService;

    @Autowired
    MetadataService metadataService;

    @Override
    public void validate(DocumentTemplateDto documentTemplateDto) throws ValidatorException {
        validateDocumentTemplate(documentTemplateDto);
        validateDocumentType(documentTemplateDto);
        validateMetadata(documentTemplateDto);
    }

    private void validateDocumentTemplate(DocumentTemplateDto documentTemplateDto) throws ValidatorException {
        DocumentTemplate documentTemplate = documentTemplateService.findByDocumentTypeType(documentTemplateDto.getType());
        if (documentTemplate != null) {
            throw new ValidatorException(documentTemplateDto.getType() + " Tipinde döküman şablonu bulunmaktadır.");
        }
    }

    private void validateDocumentType(DocumentTemplateDto documentTemplateDto) throws ValidatorException {
        DocumentType documentType = documentTypeService.findByType(documentTemplateDto.getType());
        if (documentType == null) {
            throw new ValidatorException(documentTemplateDto.getType() + " Döküman tipi sistemde bulunmamaktadır." +
                    " Öncelikle döküman tipi tanımı yapınız");
        }
    }

    private void validateMetadata(DocumentTemplateDto documentTemplateDto) throws ValidatorException {
        Metadata metadataDb;
        for(Metadata metadata : documentTemplateDto.getMetadatas()) {
            metadataDb = metadataService.findByName(metadata.getName());
            if (metadataDb == null) {
                throw new ValidatorException(metadata.getName() + " İsimli metadata sistemde bulunmamaktadır. " +
                        "Öncelikle metadata tanımı yapınız");
            }
        }
    }
}
