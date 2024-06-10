package api.mrdelivery.domain;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class UserContacts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //bind dengan column name
    public User user; // reference pakai class

    private String contact_type;

    private String contact_value;

    private boolean is_primary;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;
}