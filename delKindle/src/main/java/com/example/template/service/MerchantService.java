package com.example.template.service;

import com.example.template.model.LastProduct;
import com.example.template.model.Product;
import com.example.template.model.SeqProduct;
import com.example.template.payload.CatalogEntryRequest;
import com.example.template.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    MerchantService merchantService;

    @Autowired
    LastProductService lastProductService;

    @Autowired
    SeqProductService seqProductService;

    public Product save(Product product){
        return merchantRepository.save(product);
    }

    public List findBySkuMerchant(String sku_merchant){
        return merchantRepository.findBySku_merchant(sku_merchant);
    }

    public Integer countByIdMerchant(String sku_merchant){
        return merchantRepository.countById_merchant(sku_merchant);
    }

//    public void deleteById(Integer Id){
//        merchantRepository.deleteById(Id);
//    }

//    public Product findFirstById(Integer id){
//        return merchantRepository.findFirstById(id);
//    }

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
    public void addProduct(CatalogEntryRequest catalogEntryRequest){
        int last = lastProductService.findLast().getLast_book();
        int two = last+1;
        String pict = "pict"+two+".jpg";
        File file = new File("C:/product/"+pict);
        try(FileOutputStream fos = new FileOutputStream(file)){
            byte[] decoder = Base64.getDecoder().decode(catalogEntryRequest.getPict_product());
            fos.write(decoder);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addBook(CatalogEntryRequest catalogEntryRequest){
        int last = lastProductService.findLast().getLast_book();
        int two = last+1;
        String pdf = "book"+two+".pdf";
        File file = new File("C:/product/book/"+pdf);
        try(FileOutputStream fos = new FileOutputStream(file)){
            byte[] decoder = Base64.getDecoder().decode(catalogEntryRequest.getBook_file());
            fos.write(decoder);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String saveProduct(CatalogEntryRequest catalogEntryRequest){

            String sku_merchant = catalogEntryRequest.getSku_merchant();
            String sku_product = "";
            if(seqProductService.existByKey(sku_merchant)){
                SeqProduct seqProduct = seqProductService.findFirstByKey(catalogEntryRequest.getSku_merchant());
                int toInt = Integer.parseInt(seqProduct.getLast_seq());
                int two = toInt+1;
                String tempat = "000"+two;
                seqProduct.setLast_seq(tempat);
                seqProductService.save(seqProduct);
                sku_product = sku_merchant+"-"+tempat;
                System.out.println(sku_product);
            }else{
                seqProductService.add(catalogEntryRequest.getSku_merchant(),"0001");
                LastProduct lastProduct = lastProductService.findLast();
                int last_book = lastProduct.getLast_book();
                lastProductService.save(last_book+1);
                sku_product = sku_merchant+"-0001";
            }

            int last = lastProductService.findLast().getLast_book();
            int two = last+1;
            lastProductService.save(last+1);
            String pdf = "book"+two+".pdf";
            String pict = "pict"+two+".jpg";

            Product product = new Product(
              sku_product,
              catalogEntryRequest.getTitle(),
              catalogEntryRequest.getDescription(),
              catalogEntryRequest.getCategories(),
              catalogEntryRequest.getPublication_year(),
              catalogEntryRequest.getPrice(),
              catalogEntryRequest.getAuthor(),
              catalogEntryRequest.getPublisher(),
              catalogEntryRequest.getIsbn(),
              catalogEntryRequest.getSku_merchant()
            );
            product.setPict_product(pict);
            product.setBook_file(pdf);
         merchantService.save(product);

         return "sukses";
    }

    public void deleteBySkuProduct(String skuProduct){
        merchantRepository.deleteBySku_product(skuProduct);
    }

}
