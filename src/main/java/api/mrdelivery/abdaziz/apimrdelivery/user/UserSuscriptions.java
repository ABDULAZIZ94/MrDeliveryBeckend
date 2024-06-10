package api.mrdelivery.abdaziz.apimrdelivery.user;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class UserSuscriptions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscription_id;

    private Long user_id;

    private String subscription_type;

    private String subscription_status;

    private LocalDateTime start_date;

    private LocalDateTime end_date;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;
}
