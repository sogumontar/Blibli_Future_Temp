package com.example.template.service;

import com.example.template.exception.AppException;
import com.example.template.model.*;
import com.example.template.payload.ApiResponse;
import com.example.template.payload.JwtAuthenticationResponse;
import com.example.template.payload.LoginRequest;
import com.example.template.payload.SignUpRequest;
import com.example.template.repository.RoleRepository;
import com.example.template.repository.UserRepository;
import com.example.template.repository.UserRoleRepository;
import com.example.template.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@Service
public class AuthService {
    public static String skuLogin;
    private static String temp;
    public static Integer status;
    public static String  name;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    SeqUserService seqUserService;

    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(loginRequest.getUsername());
        System.out.println(user.toString());
        UserRole userRole = userRoleRepository.findBySku_user(user.getSku());
        System.out.println(userRole.getRole_id());
        if(userRole.getRole_id() == 1){
            temp = "ROLE_USER";
        }else if(userRole.getRole_id() == 2){
            temp = "ROLE_ADMIN";
        }else if(userRole.getRole_id() == 3){
            temp = "ROLE_MERCHANT";
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        System.out.println(jwt);
        skuLogin=user.getSku();
        status = user.getStatus();
        name = user.getName();
        System.out.println(user.getSku());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,temp,skuLogin,status,name));
    }


    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        String cc = "";
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        //SeqUser
        String temp1 = signUpRequest.getName().substring(0, 4).toUpperCase();
        if(seqUserService.existByKey(temp1)){
            String nol = "000";
            SeqUser seqUser = seqUserService.findFirstByKey(temp1);
            Integer toInt = Integer.parseInt(seqUser.getLast_seq());
            String tempat = nol.concat(String.valueOf(toInt+1));
            seqUser.setLast_seq(tempat);
            seqUserService.save(seqUser);

            cc = temp1+"-"+tempat;
        }else{
            seqUserService.add(temp1,"0001");
            cc =temp1+"-0001";
        }


        // Creating user's account
        User user1 = new User(cc,signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(),signUpRequest.getAlamat(),signUpRequest.getTanggal_lahir(),signUpRequest.getTelepon(),signUpRequest.getStatus());

        user1.setPassword(passwordEncoder.encode(user1.getPassword()));

        if(signUpRequest.getRole().equals("ROLE_USER")) {
            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new AppException("User Role not set."));
            user1.setRoles(Collections.singleton(userRole));
        }else if(signUpRequest.getRole().equals("ROLE_ADMIN")){
            Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new AppException("User Role not set."));
            user1.setRoles(Collections.singleton(userRole));
        }else if(signUpRequest.getRole().equals("ROLE_MERCHANT")){
            Role userRole = roleRepository.findByName(RoleName.ROLE_MERCHANT)
                    .orElseThrow(() -> new AppException("User Role not set."));
            user1.setRoles(Collections.singleton(userRole));
        }

        User result = userRepository.save(user1);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    public void register1(@RequestBody SignUpRequest signUpRequest){
        System.out.println(signUpRequest.getName());
    }
}
