package api.mrdelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.mrdelivery.service.AuthenticationService;
import api.mrdelivery.service.ForgetPasswordService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/validate")
@RequiredArgsConstructor
public class ActivationController {

    private final AuthenticationService service;
    private final ForgetPasswordService forgetpwdservice;

    @GetMapping("/activate-account")
    public void confirm(
            @RequestParam String token) throws MessagingException {
        service.activateAccount(token);
    }

    @GetMapping("/forget-password")
    public void resetpwd(
            @RequestParam String username) throws MessagingException {
        forgetpwdservice.sendResetPasswordEmail(username);
    }

    @GetMapping("/new-password")
    public void newpwd(
            @RequestParam String token,
            @RequestParam String newpwd) throws MessagingException {
        try {
            forgetpwdservice.processResetPasswordToken(token, newpwd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
