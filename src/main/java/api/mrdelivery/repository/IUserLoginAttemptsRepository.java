package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserLoginAttempts;

public interface IUserLoginAttemptsRepository extends JpaRepository<UserLoginAttempts, Integer>{

}
