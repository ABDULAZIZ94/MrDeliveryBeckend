package api.mrdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.mrdelivery.domain.UserSetting;

public interface IUserSettingRepository extends JpaRepository<UserSetting, Integer>{

}
