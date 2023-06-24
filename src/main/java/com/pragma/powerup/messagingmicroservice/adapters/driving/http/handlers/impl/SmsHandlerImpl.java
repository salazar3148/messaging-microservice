package com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.ISmsHandler;
import com.pragma.powerup.messagingmicroservice.domain.api.ISmsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsHandlerImpl implements ISmsHandler {

    private final ISmsServicePort smsServicePort;
    @Override
    public String getCodeAndSendSmsVerification(String phoneNumber) {
        return smsServicePort.getCodeAndSendSmsVerification(phoneNumber);
    }
}
