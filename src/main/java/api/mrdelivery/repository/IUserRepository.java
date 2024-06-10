package api.mrdelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.User;


public interface IUserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByIdOrderByIdAscEmailAscFirstnameAsc(Integer id);
}


