package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Ingeniero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngenieroRepository extends MongoRepository<Ingeniero, String> {
}
