package com.gurkan.dms.validator;

import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.dto.DocumentDto;
import com.gurkan.dms.exception.ValidatorException;
import com.gurkan.dms.interfaces.IValidator;
import com.gurkan.dms.service.DocumentTemplateService;
import com.gurkan.dms.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentValidator implements IValidator<DocumentDto> {

    @Autowired
    MetadataService metadataService;

    @Autowired
    DocumentTemplateService documentTemplateService;

    @Override
    public void validate(DocumentDto documentDto) throws ValidatorException {
        validateDocumentTemplate(documentDto);
        validateMetadata(documentDto);
        validateDocumentTemplateMetatada(documentDto);
    }

    private void validateDocumentTemplate(DocumentDto documentDto) throws ValidatorException {
        DocumentTemplate documentTemplate = documentTemplateService.findByDocumentTypeType(documentDto.getDocumentType());
        if (documentTemplate == null) {
            throw new ValidatorException(documentDto.getDocumentType() + " Tipi döküman şablonu bulunamdı. " +
                    "Öncelikle döküman şablonu tanımlayınız.");
        }
    }

    private void validateMetadata(DocumentDto documentDto) throws ValidatorException {
        Metadata metadataDb;
        for (Metadata metadata : documentDto.getMetadatas()) {
            metadataDb = metadataService.findByName(metadata.getName());
            if (metadataDb == null) {
                throw new ValidatorException(metadata.getName() + " İsimli metadata sistemde bulunmamaktadır. " +
                        "Öncelikle metadata tanımı yapınız");
            }
        }
    }

    private void validateDocumentTemplateMetatada(DocumentDto documentDto) throws ValidatorException {
        DocumentTemplate documentTemplate = documentTemplateService.findByDocumentTypeType(documentDto.getDocumentType());
        if (documentDto.getMetadatas().size() != documentTemplate.getMetadatas().size()) {
            throw new ValidatorException(documentDto.getDocumentType() + " Tipi döküman şablonundaki metadatalar ile " +
                    "gönderilen metadatalar birbirinden farklıdır. ");
        }
    }
}
