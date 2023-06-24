package com.pragma.powerup.messagingmicroservice.adapters.driven.adapter;

import com.pragma.powerup.messagingmicroservice.domain.spi.ISmsProviderPort;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TwilioSmsAdapter implements ISmsProviderPort {

    private final TwilioRestClient twilioRestClient;

    private final PhoneNumber twilioPhoneNumber;
    @Override
    public void sendSms(String phoneNumber, String message) {
        Message.creator(
                new PhoneNumber(phoneNumber),
                twilioPhoneNumber,
                message)
                .create(twilioRestClient);
    }
}
