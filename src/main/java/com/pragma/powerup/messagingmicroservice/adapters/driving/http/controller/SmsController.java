package com.pragma.powerup.messagingmicroservice.adapters.driving.http.controller;
import com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.ISmsHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    private final ISmsHandler smsHandler;
    @Operation(summary = "send and return one verification code",
            responses = {
                    @ApiResponse(responseCode = "200", description = "sms sent",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map")))
                    })
    @PostMapping("")
    public ResponseEntity<String> sendVerificationCode(@RequestBody String phoneNumber) {
        String code = smsHandler.getCodeAndSendSmsVerification(phoneNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(code);
    }
}
