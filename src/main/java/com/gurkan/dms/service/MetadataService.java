package com.gurkan.dms.service;

import com.gurkan.dms.bean.Metadata;
import com.gurkan.dms.repository.MetadataRepository;
import com.gurkan.dms.util.DMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataService {

    @Autowired
    MetadataRepository metadataRepository;

    public Metadata add(Metadata metadata) {
        metadata.setCreateDate(DMSUtil.dateNow());
        metadata.setCreateTime(DMSUtil.timeNow());
        metadata.setInsertUser(DMSUtil.sessionUser());
        return metadataRepository.save(metadata);
    }

    public List<Metadata> list() {
        return metadataRepository.findAll();
    }

    public Metadata findByName(String name) {
        return metadataRepository.findByName(name);
    }
}
