package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Innovacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnovacionRepository extends MongoRepository<Innovacion, String> {
}
