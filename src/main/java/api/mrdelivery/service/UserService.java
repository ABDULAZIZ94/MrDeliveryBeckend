package api.mrdelivery.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.mrdelivery.domain.User;
import api.mrdelivery.domain.UserAddress;
import api.mrdelivery.domain.UserProfiles;
import api.mrdelivery.dto.ChangePasswordRequest;
import api.mrdelivery.dto.UserAddressDTO;
import api.mrdelivery.dto.UserDTO;
import api.mrdelivery.repository.IUserAddressesRepository;
import api.mrdelivery.repository.IUserProfileRepository;
import api.mrdelivery.repository.IUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final IUserRepository repository;
    private final ModelMapper modelMapper;
    private final IUserProfileRepository iUserProfileRepository;
    private final JwtService jwtService;
    private final IUserAddressesRepository iUserAddressesRepository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = (User) (((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal());

        // check if password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }

    public UserDTO getUserDetails(Integer user_id) {
        User user = repository.findById(user_id).orElseThrow(() -> new IllegalStateException("User not found"));
        return modelMapper.map(user, UserDTO.class);

    }

    public User getUserDetails2(Integer user_id) {
        User user = repository.findById(user_id).orElseThrow(() -> new IllegalStateException("User not found"));
        return user;

    }

    public UserProfiles saveUserProfiles(UserProfiles userProfiles, HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return userProfiles;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        var user = repository.findByEmail(userEmail).get();
        userProfiles.setUser(user);
        return iUserProfileRepository.save(userProfiles);
    }

    public UserProfiles retrieveUserProfiles(Integer user_id) {
        return iUserProfileRepository.findByUser_id(user_id);
    }

    public UserAddress saveUserAddress(HttpServletRequest request, UserAddressDTO userAddressDto) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return modelMapper.map(userAddressDto, UserAddress.class);
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        UserAddress userAddress = modelMapper.map(userAddressDto, UserAddress.class);
        var user = repository.findByEmail(userEmail).get();
        userAddress.setUser(user);
        if(userAddressDto.is_primary()){
            singleprimaryaddress(user);
        }
        return iUserAddressesRepository.save(userAddress);
    }

    public void singleprimaryaddress(User user){
        Optional<List<UserAddress>> addresses = iUserAddressesRepository.findAllByUser(user);
        if (addresses.isPresent() && addresses.get().size() > 1) {
            addresses.get().forEach(address -> address.set_primary(false));
        }
    }
}

