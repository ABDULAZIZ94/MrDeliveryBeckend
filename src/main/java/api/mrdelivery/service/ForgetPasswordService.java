package api.mrdelivery.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.mrdelivery.domain.Token;
import api.mrdelivery.domain.User;
import api.mrdelivery.repository.ITokenRepository;
import api.mrdelivery.repository.IUserRepository;
import api.mrdelivery.util.constants.EmailTemplateName;
import api.mrdelivery.util.constants.TokenType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ForgetPasswordService {
    @Value("${application.mailing.frontend.reset-password-url}")
    private String resetPasswordUrl;

    private final IUserRepository repository;
    private final ITokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final EmailService emailService;

    public void resetpassword(String newpwd, String username) throws Exception {
        var user = repository.findByEmail(username);
        if (user.isEmpty()) {
            throw new Exception("User not found");
        }
        var udatedUser = user.get();
        udatedUser.setPassword(passwordEncoder.encode(newpwd));
        repository.save(udatedUser);
    }

    public void processResetPasswordToken(String token, String newpwd) throws Exception {
        Token savedToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid Token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendResetPasswordEmail(savedToken.getUser().getUsername());
            throw new RuntimeException(
                    "Activation token has expired. A new token has been send to the same email address");
        }
        resetpassword(newpwd, savedToken.getUser().getUsername());
    }

    public String generateResetPasswordToken(String username) {
        return jwtService.generateResetPwdToken(username);
    }

    public void sendResetPasswordEmail(String username) throws MessagingException {
        User user = repository.findByEmail(username).get();
        String generatedToken = generateResetPasswordToken(username);
        var token = Token.builder()
        .token(generatedToken)
        .tokenType(TokenType.RESETPWD)
        .createdAt(LocalDateTime.now())
        .expiresAt(LocalDateTime.now().plusMinutes(60))
        .user(user)
        .build();

        tokenRepository.save(token);
        
        emailService.sendEmail(
                username,
                username,
                EmailTemplateName.RESET_PASSWORD,
                resetPasswordUrl,
                generatedToken,
                "Reset Password");
    }
}
