package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserNotification;

public interface IUserNotificationRepository extends JpaRepository<UserNotification, Integer>{

}
