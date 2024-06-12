package api.mrdelivery.domain;

import java.time.LocalDateTime;

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

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserActivity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activity_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //bind dengan column name
    public User user; // reference pakai class
    
    private String activity_type;
    
    private String activity_description;
    
    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;
    
}


