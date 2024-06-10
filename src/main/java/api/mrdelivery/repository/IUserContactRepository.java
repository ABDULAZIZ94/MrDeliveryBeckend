package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserContacts;

public interface IUserContactRepository extends JpaRepository<UserContacts, Integer>{

}
