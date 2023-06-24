package com.pragma.powerup.messagingmicroservice.domain.api;

public interface ISmsServicePort {
    String getCodeAndSendSmsVerification(String phoneNumber);
}
