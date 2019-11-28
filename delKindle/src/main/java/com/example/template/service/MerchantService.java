package com.example.template.service;
import com.example.template.model.Product;
import com.example.template.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MerchantService {
//
//    @Autowired
//    MerchantRepository merchantRepository;
//
//    @Autowired
//    MerchantService merchantService;
//
//    public Product save(Product product){
//        return merchantRepository.save(product);
//    }
//
//    public List findByIdMerchant(Integer id_merchant){
//        return merchantRepository.findById_merchant(id_merchant);
//    }
//
//    public Integer countByIdMerchant(Integer id_merchant){
//        return merchantRepository.countById_merchant(id_merchant);
//    }
//    public void deleteById(Integer Id){
//        merchantRepository.deleteById(Id);
//    }
//
//    public Product findFirstById(Integer id){
//        return merchantRepository.findFirstById(id);
//    }
//
//    public String simpan(Product product1, MultipartFile file){
//        try{
//            Product product =  new Product(
//                    product1.getTitle(),
//                    product1.getDescription(),
//                    product1.getCategories(),
//                    product1.getPublication_year(),
//                    product1.getPrice(),
//                    product1.getAuthor(),
//                    product1.getPublisher(),
//                    product1.getIsbn(),
//                    file.getOriginalFilename(),
//                    product1.getId_merchant()
//            );
//
//            merchantService.save(product);
//            System.out.println(product1.getTitle());
//            System.out.println(product1.getDescription());
//            System.out.println(file.getOriginalFilename());
//
//            String folder = "C:/product/";
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(folder + file.getOriginalFilename());
//            Files.write(path,bytes);
//
//            return "sukses";
//        }catch (Exception e){
//            return e.getMessage();
//        }
//    }

}
