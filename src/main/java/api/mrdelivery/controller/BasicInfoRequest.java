package api.mrdelivery.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicInfoRequest {

    private String firstname;

    private String lastname;

    private String email;

    // private String password_hash;

    private String status;

    private String country;

    private String biography;

    private String socialmedialinks;
}
