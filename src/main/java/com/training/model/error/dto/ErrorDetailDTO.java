package com.training.model.error.dto;

import java.util.ArrayList;

public class ErrorDetailDTO {
    ArrayList< Object > codes ;
    ArrayList < Object > arguments;
    private String defaultMessage;
    private String objectName;
    private String field;
    private String rejectedValue = null;
    private boolean bindingFailure;
    private String code;


    // Getter Methods

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public boolean getBindingFailure() {
        return bindingFailure;
    }

    public String getCode() {
        return code;
    }

    // Setter Methods

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public void setBindingFailure(boolean bindingFailure) {
        this.bindingFailure = bindingFailure;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Object> getCodes() {
        return codes;
    }

    public void setCodes(ArrayList<Object> codes) {
        this.codes = codes;
    }

    public ArrayList<Object> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<Object> arguments) {
        this.arguments = arguments;
    }

    public boolean isBindingFailure() {
        return bindingFailure;
    }
}
