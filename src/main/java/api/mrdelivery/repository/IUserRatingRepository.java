package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserRating;

public interface IUserRatingRepository extends JpaRepository<UserRating, Integer>{

}
