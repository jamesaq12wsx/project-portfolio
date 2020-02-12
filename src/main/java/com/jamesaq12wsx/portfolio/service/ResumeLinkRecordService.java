package com.jamesaq12wsx.portfolio.service;

import com.jamesaq12wsx.portfolio.model.ResumeLinkRecord;
import com.jamesaq12wsx.portfolio.repository.ResumeLinkRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
public class ResumeLinkRecordService {

    @Autowired
    private ResumeLinkRecordRepository resumeLinkRecordRepository;

    @Autowired
    public ResumeLinkRecordService(ResumeLinkRecordRepository resumeLinkRecordRepository) {
        this.resumeLinkRecordRepository = resumeLinkRecordRepository;
    }

    public CompletableFuture<Boolean> addRecord(final String linkParam){
        CompletableFuture completableFuture = new CompletableFuture<Boolean>();

        Executors.newCachedThreadPool().submit(() -> {
            try{
                resumeLinkRecordRepository.save(new ResumeLinkRecord(linkParam == null || linkParam.isEmpty() ? "Other" : linkParam));

                completableFuture.complete(true);

            }catch (Exception e){
                completableFuture.complete(false);
            }
        });

        return completableFuture;
    }
}
