package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserSuscriptions;

public interface IUserSuscriptionsRepository extends JpaRepository<UserSuscriptions, Integer>{

}
