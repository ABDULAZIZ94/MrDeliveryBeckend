package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserPreferences;

public interface IUserPreferencesRepository extends JpaRepository<UserPreferences, Integer>{

}
