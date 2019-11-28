package com.example.template.service;
import com.example.template.model.SeqUser;
import com.example.template.repository.SeqUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeqUserService {
    @Autowired
    SeqUserRepository seqUserRepository;

    public boolean existByKey(String key){
        return seqUserRepository.existsByKey(key);
    }

    public SeqUser add(String key,String lastSeq){
        SeqUser seqUser1 = new SeqUser(key,lastSeq);
        return  seqUserRepository.save(seqUser1);
    }

    public SeqUser findFirstByKey(String key){
        return seqUserRepository.findFirstByKey(key);
    }

    public SeqUser save(SeqUser seqUser){
        return seqUserRepository.save(seqUser);
    }
}
