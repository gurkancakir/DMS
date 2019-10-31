package com.gurkan.dms.service;

import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataService {

    @Autowired
    MetadataRepository metadataRepository;

    public Metadata add(Metadata metadata) {
        return metadataRepository.save(metadata);
    }

    public List<Metadata> list() {
        return metadataRepository.findAll();
    }

    public Metadata findByName(String name) {
        return metadataRepository.findByName(name);
    }
}
