package api.mrdelivery.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSuscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscription_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // bind dengan column name
    @JsonBackReference
    public User user; // reference pakai class

    private String subscription_type;

    private String subscription_status;

    private LocalDateTime start_date;

    private LocalDateTime end_date;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;
}
