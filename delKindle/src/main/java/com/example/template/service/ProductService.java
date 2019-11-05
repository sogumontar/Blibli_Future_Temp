package com.example.template.service;

<<<<<<< HEAD
import com.example.template.model.Product;
import com.example.template.repository.ProductRepo;
=======

import com.example.template.model.Product;
import com.example.template.repository.ProductRepository;
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
@Service
public class ProductService {

    @Autowired
<<<<<<< HEAD
    private ProductRepo productRepo;

    public List findAll(){
        return productRepo.findAll();
    }

=======
    ProductRepository productRepository;

    public List findAll(){
        return productRepository.findAll();
    }

    public Product findFirstById(Long id){
        return productRepository.findFirstById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }



>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
}
