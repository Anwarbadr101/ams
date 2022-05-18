package com.ams.model.constant;

/**
 * @author: Anwar.Badr
 */
public enum ErrorMessages {

    PARATICIPANT_MAX_NUMBER("you should appointment");


    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
