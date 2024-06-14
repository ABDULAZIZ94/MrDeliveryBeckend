package api.mrdelivery.dto;

import java.util.List;

import api.mrdelivery.domain.UserActivity;
import api.mrdelivery.domain.UserAddress;
import api.mrdelivery.domain.UserContacts;
import api.mrdelivery.domain.UserLoginAttempts;
import api.mrdelivery.domain.UserNotification;
import api.mrdelivery.domain.UserPermission;
import api.mrdelivery.domain.UserPreferences;
import api.mrdelivery.domain.UserProfiles;
import api.mrdelivery.domain.UserRating;
import api.mrdelivery.domain.UserSetting;
import api.mrdelivery.domain.UserSuscriptions;
import api.mrdelivery.domain.UserVerification;
import api.mrdelivery.util.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;

    private List<UserActivity> userActivities;
    private List<UserAddress> userAddresses;
    private List<UserContacts> userContacts;
    private List<UserLoginAttempts> userLoginAttempts;
    private List<UserNotification> userNotifications;
    private List<UserPermission> userPermissions;
    private List<UserPreferences> userPreferences;
    private List<UserProfiles> userProfiles;
    private List<UserRating> userRatings;
    private List<UserSetting> userSettings;
    private List<UserSuscriptions> userSuscriptions;
    private List<UserVerification> userVerifications;
}
