package api.mrdelivery.repository;

import api.mrdelivery.domain.UserAddress;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import api.mrdelivery.domain.User;


public interface IUserAddressesRepository extends JpaRepository<UserAddress, Integer>{
    
    Optional<List<UserAddress>> findAllByUser(User user);
}

