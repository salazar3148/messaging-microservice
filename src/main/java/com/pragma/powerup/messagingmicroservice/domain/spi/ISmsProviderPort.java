package com.pragma.powerup.messagingmicroservice.domain.spi;

public interface ISmsProviderPort {
    void sendSms(String phoneNumer, String message);
}
