package com.example.template.payload;

public class JwtAuthenticationResponse {
    private String accesToken;
    private String tokenType="bearer";
    public JwtAuthenticationResponse(String accesToken) {
        this.accesToken = accesToken;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }
}
