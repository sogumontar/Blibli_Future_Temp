package com.example.template.payload;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String role;
    private Long idLog;

    public JwtAuthenticationResponse(String accessToken , String role) {
        this.accessToken = accessToken;
        this.role = role;
    }

    public JwtAuthenticationResponse(String accessToken, String role, Long idLog) {
        this.accessToken = accessToken;
        this.role = role;
        this.idLog = idLog;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
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
