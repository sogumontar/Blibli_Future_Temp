package com.example.template.payload;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String role;
    private String skuLog;

    public JwtAuthenticationResponse(String accessToken , String role) {
        this.accessToken = accessToken;
        this.role = role;
    }

    public JwtAuthenticationResponse(String accessToken, String role, String skuLog) {
        this.accessToken = accessToken;
        this.role = role;
        this.skuLog = skuLog;
    }

    public String getSkuLog() {
        return skuLog;
    }

    public void setSkuLog(String skuLog) {
        this.skuLog = skuLog;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
