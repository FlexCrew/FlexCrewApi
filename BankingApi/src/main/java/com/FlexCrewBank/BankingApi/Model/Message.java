package com.FlexCrewBank.BankingApi.Model;

import java.util.ArrayList;
import java.util.Optional;

public class Message {

    private Integer code;
    private String message;
    private ArrayList<?> data;
//    private Iterable data1;
//    private Optional data2;

    public Message() {
    }

    public Message(Integer code, String message, ArrayList data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Message(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
//
//    public Message(Integer code, String message, Iterable data1) {
//        this.code = code;
//        this.message = message;
//        this.data1 = data1;
//    }
//
//    public Message(Integer code, String message, Optional data2) {
//        this.code = code;
//        this.message = message;
//        this.data2 = data2;
//    }

//    public Iterable getData1() {
//        return data1;
//    }
//
//    public void setData1(Iterable data1) {
//        this.data1 = data1;
//    }
//
//    public Optional getData2() {
//        return data2;
//    }
//
//    public void setData2(Optional data2) {
//        this.data2 = data2;
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
}
