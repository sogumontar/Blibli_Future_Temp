package com.example.template.service;

import com.example.template.model.Product;
import com.example.template.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    public Product save(Product product){
        return merchantRepository.save(product);
    }

    public List findByIdMerchant(Integer id_merchant){
        return merchantRepository.findById_merchant(id_merchant);
    }

    public Integer countByIdMerchant(Integer id_merchant){
        return merchantRepository.countById_merchant(id_merchant);
    }
    public void deleteById(Integer Id){
        merchantRepository.deleteById(Id);
    }
<<<<<<< HEAD

    public Product findFirstById(Integer id){
        return merchantRepository.findFirstById(id);
    }
=======
>>>>>>> a937c92850d1d5f0a4608592c095adf3aa824e37
}
