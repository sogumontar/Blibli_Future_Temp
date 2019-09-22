package com.medan.sitoluama.Del.Kindle.service;

import com.medan.sitoluama.Del.Kindle.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {
    @Autowired
    BukuRepository bukuRepository;

    public List findAll(){
        return bukuRepository.findAll();
    }
}
