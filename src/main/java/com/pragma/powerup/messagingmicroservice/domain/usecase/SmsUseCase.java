package com.pragma.powerup.messagingmicroservice.domain.usecase;
import com.pragma.powerup.messagingmicroservice.domain.api.ISmsServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.ISmsProviderPort;
import static com.pragma.powerup.messagingmicroservice.config.Constants.RANDOM;

public class SmsUseCase implements ISmsServicePort {

    private final ISmsProviderPort smsProviderPort;

    public SmsUseCase(ISmsProviderPort smsProviderPort) {
        this.smsProviderPort = smsProviderPort;
    }

    @Override
    public String getCodeAndSendSmsVerification(String phoneNumber) {
        int number = RANDOM.nextInt(1000000);
        String paddedNumber = String.format("%06d", number);
        String message = "Verification code is: " + paddedNumber + " , do not share it with anyone";
        smsProviderPort.sendSms(phoneNumber, message);
        return paddedNumber;
    }
}
