package com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers;

public interface ISmsHandler {
    String getCodeAndSendSmsVerification(String phoneNumber);
}
