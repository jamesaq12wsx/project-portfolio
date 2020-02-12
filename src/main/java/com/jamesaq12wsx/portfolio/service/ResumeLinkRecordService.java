package com.jamesaq12wsx.portfolio.service;

import com.jamesaq12wsx.portfolio.model.ResumeLinkRecord;
import com.jamesaq12wsx.portfolio.repository.ResumeLinkRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeLinkRecordService {

    @Autowired
    private ResumeLinkRecordRepository resumeLinkRecordRepository;

    @Autowired
    public ResumeLinkRecordService(ResumeLinkRecordRepository resumeLinkRecordRepository) {
        this.resumeLinkRecordRepository = resumeLinkRecordRepository;
    }

    public ResumeLinkRecord addRecord(String linkParam){
        if (linkParam == null || linkParam.isEmpty()){
            linkParam = "Other";
        }

        return resumeLinkRecordRepository.save(new ResumeLinkRecord(linkParam));
    }
}
