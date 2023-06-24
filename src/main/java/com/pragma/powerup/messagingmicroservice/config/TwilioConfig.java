package com.pragma.powerup.messagingmicroservice.config;
import com.twilio.http.TwilioRestClient;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    @Bean
    public TwilioRestClient twilioRestClient() {
        return new TwilioRestClient.Builder(accountSid, authToken).build();
    }

    @Bean
    public PhoneNumber twilioPhoneNumber() {
        return new PhoneNumber(phoneNumber);
    }
}
