package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserActivity;

public interface IUserActivityRepository extends JpaRepository<UserActivity,Integer>{

}
