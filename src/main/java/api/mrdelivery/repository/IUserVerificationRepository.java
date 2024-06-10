package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserVerification;

public interface IUserVerificationRepository extends JpaRepository<UserVerification, Integer>{

}
