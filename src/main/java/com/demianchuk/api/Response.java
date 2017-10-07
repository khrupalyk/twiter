package com.demianchuk.api;

public class Response<T> {
    private T success;
    private String errorMsg;

    public Response(T success) {
        this.success = success;
    }

    public Response(String error) {
        this.errorMsg = error;
    }

    public Response (){}

    public Response<T> withUserNotAuthorized(){
        errorMsg = "User not authorized";
        return this;
    }

    public static <T> Response<T> notAuthorized() {
        return new Response<T>().withUserNotAuthorized();
    }

    public T getSuccess() {
        return success;
    }

    public void setSuccess(T success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
