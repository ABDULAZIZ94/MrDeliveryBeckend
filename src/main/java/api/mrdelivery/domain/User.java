package api.mrdelivery.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import api.mrdelivery.util.constants.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(unique=true)
    private String email;
    private String password;
    private boolean enabled;
    private boolean accountexpired;
    private boolean accountlocked;
    private boolean credentialexpired;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Token> tokens;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserActivity> userActivities;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserAddress> userAddresses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserContacts> userContacts;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserLoginAttempts> userLoginAttempts;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserNotification> userNotifications;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserPermission> userPermissions;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserPreferences> userPreferences;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserProfiles> userProfiles;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserRating> userRatings;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserSetting> userSettings;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserSuscriptions> userSuscriptions;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserVerification> userVerifications;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountexpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialexpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
