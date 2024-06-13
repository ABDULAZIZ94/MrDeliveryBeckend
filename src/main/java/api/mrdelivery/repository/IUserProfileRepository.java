package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserProfiles;
public interface IUserProfileRepository extends JpaRepository<UserProfiles, Integer>{
    
}
