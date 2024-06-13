package api.mrdelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.mrdelivery.domain.Token;
import api.mrdelivery.util.constants.TokenType;

public interface ITokenRepository extends JpaRepository<Token, Integer>{
    
    @Query(value = """
                select t from Token t inner join User u\s
                on t.user.id = u.id\s
                where u.id = :id 
                    and (t.expired = false or t.revoked =false)
                    and t.tokenType = :tokenType\s
                """)
    java.util.List<Token> findAllValidTokenByUser(Integer id, @Param("tokenType") TokenType tokenType);

    Optional<Token> findByToken(String token);
}
