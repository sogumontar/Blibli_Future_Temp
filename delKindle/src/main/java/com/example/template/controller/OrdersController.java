package com.example.template.controller;

import com.example.template.model.Orders;
import com.example.template.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    OrdersService ordersService;

    @CrossOrigin
    @PostMapping("/saveOrder")
    public Orders saveOrder(@RequestBody Orders orders){
        return ordersService.saveOrder(orders);
    }

    @CrossOrigin
    @GetMapping("/findLast")
    public Orders findLast(){
        return ordersService.findLast();
    }

    @CrossOrigin
    @GetMapping("/findOrder/{sku}/{status}")
    public List findOrder(@PathVariable String sku, @PathVariable Integer status){
        return ordersService.findAllBySkuAndStatus(sku,status);
    }
    public static String encrypt(String text)
    {
        int s=4;
        String result= new String();
        char ch;
        for(int i = 0; i < text.length(); ++i){
            ch = text.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch + s);

                if(ch > 'z'){
                    ch = (char)(ch - 'z' + 'a' - 1);
                }

                result += ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + s);

                if(ch > 'Z'){
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }

                result += ch;
            }
            else {
                result += ch;
            }
        }
        return result;
    }
    @CrossOrigin
    @PostMapping("/sendMail/{email}/{VA}")
    public String  sendEmail(@PathVariable String email, @PathVariable String VA){

        String VirtualAccount=encrypt(VA);
//        sendEmail();
//            sendEmailWithAttachment();
        final String username = "hendrasimz93@gmail.com";
        final String password = "simangunsong77";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pardelkindle@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Transaksi Del Kindle ");
            message.setText("Terimakasih telah melakukan transaksi \n Kode Transaksi anda adalah :  " + VirtualAccount);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Success";
    }
//    void testt(String test){
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("hendrasimz92@gmail.com");
//
//        msg.setSubject("Selamat Datang di Del Kindle ");
//        msg.setText("Terimakasih telah melakukan transaksi \n Kode Transaksi anda adalah : "+test);
//
//        javaMailSender.send(msg);
//    }

//    public String sendEmail(String emails) {
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("hendrasimz92@gmail.com");
//
//        msg.setSubject("Selamat Datang di Del Kindle ");
//        msg.setText("Terimakasih telah melakukan transaksi \n Kode Transaksi anda adalah : "+emails);
//
//        javaMailSender.send(msg);
//
//    }
    @CrossOrigin
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        ordersService.deleteById(id);
        return "Success";
    }

    @CrossOrigin
    @PostMapping("checkVA/{VA}/{text}")
    public Integer check(@PathVariable String VA,@PathVariable String text){
        Integer res=0;
        int s=4;
        char ch;
        String result= new String();

        for(int i = 0; i < text.length(); ++i){
            ch = text.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch - s);

                if(ch < 'a'){
                    ch = (char)(ch + 'z' - 'a' + 1);
                }

                result += ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch - s);

                if(ch < 'A'){
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }

                result += ch;
            }
            else {
                result += ch;
            }
        }
        if(result.equals(VA)){
            res=1;
        }
        return res;
    }

    //findVirtualAccount
    @CrossOrigin
    @GetMapping("/findVA/{id}")
    public Orders findVA(@PathVariable int id){
        return ordersService.findVirtualAccount(id);
    }


}
