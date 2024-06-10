package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserRoles;

public interface IUserRolesRepository extends JpaRepository<UserRoles, Integer>{

}
