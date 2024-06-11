package api.mrdelivery.dto;

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

    // private List<UserActivity> userActivities;
    // private List<UserAddresses> userAddresses;
    // private List<UserContacts> userContacts;
    // private List<UserLoginAttempts> userLoginAttempts;
    // private List<UserNotification> userNotifications;
    // private List<UserPermission> userPermissions;
    // private List<UserPreferences> userPreferences;
    // private List<UserProfiles> userProfiles;
    // private List<UserRating> userRatings;
    // private List<UserSetting> userSettings;
    // private List<UserSuscriptions> userSuscriptions;
    // private List<UserVerification> userVerifications;
}
