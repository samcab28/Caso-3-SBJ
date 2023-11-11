package moding.ingeniero.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import moding.ingeniero.models.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
