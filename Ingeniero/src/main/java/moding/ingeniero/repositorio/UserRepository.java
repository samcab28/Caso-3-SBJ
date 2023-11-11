package moding.ingeniero.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import moding.ingeniero.modelo.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);

}
