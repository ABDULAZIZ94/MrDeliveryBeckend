package api.mrdelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserProfiles;
public interface IUserProfileRepository extends JpaRepository<UserProfiles, Integer>{
    UserProfiles findByUser_id(Integer user_id);
}
