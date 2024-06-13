package api.mrdelivery.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.mrdelivery.dto.AuthenticationRequest;
import api.mrdelivery.dto.AuthenticationResponse;
import api.mrdelivery.dto.RegisterRequest;
import api.mrdelivery.service.AuthenticationService;
import api.mrdelivery.service.ForgetPasswordService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final ForgetPasswordService forgetpwdservice;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    // @GetMapping("/validation-email")
    // public void validation(
    // @RequestParam String username) throws MessagingException {
    // service.sendValidationEmail(username);
    // }

    // @GetMapping("/activate-account")
    // public void confirm(
    //         @RequestParam String token) throws MessagingException {
    //     service.activateAccount(token);
    // }

    // @GetMapping("/forget-password")
    // public void resetpwd(
    //         @RequestParam String username) throws MessagingException {
    //     forgetpwdservice.sendResetPasswordEmail(username);
    // }

    // @GetMapping("/new-password")
    // public void newpwd(
    //         @RequestParam String token,
    //         @RequestParam String newpwd) throws MessagingException {
    //     try {
    //         forgetpwdservice.processResetPasswordToken(token, newpwd);
    //     } catch (Exception e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }
}
