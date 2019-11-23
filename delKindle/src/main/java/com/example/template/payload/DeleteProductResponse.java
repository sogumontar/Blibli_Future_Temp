package com.example.template.payload;

public class DeleteProductResponse {
    private String message = "success delete product";
    private Integer response = 200;


    public  DeleteProductResponse(){

    }

    public DeleteProductResponse(String message, Integer response) {
        this.message = message;
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }
}
