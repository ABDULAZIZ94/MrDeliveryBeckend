package api.mrdelivery.service;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.mrdelivery.domain.User;
import api.mrdelivery.dto.ChangePasswordRequest;
import api.mrdelivery.dto.UserDTO;
import api.mrdelivery.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final IUserRepository repository;
    private final ModelMapper modelMapper;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser){
        var user = (User) (((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal());
        
        // check if password is correct
        if(!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong password");
        }

        // check if the two new passwords are the same
        if(!request.getNewPassword().equals(request.getConfirmationPassword())){
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }

    public UserDTO getUserDetails(Integer user_id){
        User user = repository.findById(user_id).orElseThrow(() -> new IllegalStateException("User not found"));
        return modelMapper.map(user, UserDTO.class);

    }

}
