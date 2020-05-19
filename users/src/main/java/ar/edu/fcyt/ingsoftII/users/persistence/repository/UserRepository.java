package ar.edu.fcyt.ingsoftII.users.persistence.repository;

import ar.edu.fcyt.ingsoftII.users.persistence.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByName(String name);
}
