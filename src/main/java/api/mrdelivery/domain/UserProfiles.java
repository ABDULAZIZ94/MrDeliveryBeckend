package api.mrdelivery.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    public User user;

    // private String username;

    private String firstname;

    private String lastname;

    private String email;

    // private String password_hash;

    private String status;

    private String country;

    private String biography;

    private String socialmedialinks;

    @OneToMany(mappedBy = "userProfiles")
    @JsonManagedReference
    private List<UserInterest> interest;

    @OneToMany(mappedBy = "userProfiles")
    @JsonManagedReference
    private List<UserSkills> userSkills;

    @OneToMany(mappedBy = "userProfiles")
    @JsonManagedReference
    private List<UserEducation> education;

    @OneToMany(mappedBy = "userProfiles")
    @JsonManagedReference
    private List<UserWorkExperience> workexperience;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;
}
