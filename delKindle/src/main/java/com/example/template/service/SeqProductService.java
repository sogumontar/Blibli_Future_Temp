package com.example.template.service;

import com.example.template.model.SeqProduct;
import com.example.template.repository.SeqProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeqProductService {
    @Autowired
    SeqProductRepository seqProductRepository;

    public SeqProduct save(SeqProduct seqProduct){
        return seqProductRepository.save(seqProduct);
    }

    public boolean existByKey(String key){
        return seqProductRepository.existsByKey(key);
    }

    public SeqProduct findFirstByKey(String key){
        return seqProductRepository.findFirstByKey(key);
    }

    public SeqProduct add(String key,String las_seq){
        SeqProduct seqProduct = new SeqProduct();
        seqProduct.setKey(key);
        seqProduct.setLast_seq(las_seq);
        return seqProductRepository.save(seqProduct);
    }

}
