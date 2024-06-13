package api.mrdelivery.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.mrdelivery.domain.User;
import api.mrdelivery.domain.UserProfiles;
import api.mrdelivery.dto.ChangePasswordRequest;
import api.mrdelivery.dto.UserDTO;
import api.mrdelivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

    @PatchMapping
    public ResponseEntity<?> chagePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    // @PatchMapping
    // public ResponseEntity<?> chagePassword2(
    //         @RequestBody ChangePasswordRequest request,
    //         Principal forgetPwdUser) {
    //     service.changePassword(request, forgetPwdUser);
    //     return ResponseEntity.ok().build();
    // }

    @GetMapping("/details")
    public ResponseEntity<UserDTO> getUsersDetails(@RequestParam Integer user_id) {
        UserDTO details = service.getUserDetails(user_id);
        return ResponseEntity.ok(details);
    }

    @GetMapping("/details2")
    public ResponseEntity<User> getUsersDetails2(@RequestParam Integer user_id) {
        User details = service.getUserDetails2(user_id);
        return ResponseEntity.ok(details);
    }

    @PostMapping("/basicinfo")
    public ResponseEntity<UserProfiles> updateBasicInfo(@RequestBody BasicInfoRequest BasicInfo){
        UserProfiles userProfile = modelMapper.map(BasicInfo ,UserProfiles.class);
        var response = service.saveUserProfiles(userProfile);
        return ResponseEntity.ok(response);
    }
    
}
