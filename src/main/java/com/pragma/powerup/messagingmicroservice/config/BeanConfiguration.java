package com.pragma.powerup.messagingmicroservice.config;

import com.pragma.powerup.messagingmicroservice.adapters.driven.adapter.TwilioSmsAdapter;
import com.pragma.powerup.messagingmicroservice.domain.api.ISmsServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.ISmsProviderPort;
import com.pragma.powerup.messagingmicroservice.domain.usecase.SmsUseCase;
import com.twilio.http.TwilioRestClient;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TwilioRestClient twilioRestClient;
    private final PhoneNumber phoneNumber;
    @Bean
    public ISmsProviderPort smsProviderPort(){
        return new TwilioSmsAdapter(twilioRestClient, phoneNumber);
    }
    @Bean
    public ISmsServicePort smsServicePort(){
        return new SmsUseCase(smsProviderPort());
    }
}
