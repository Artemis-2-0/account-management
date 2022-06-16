package com.brihaspathee.artemis.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:58 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.exception
 * To change this template use File | Settings | File and Code Template
 */
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
