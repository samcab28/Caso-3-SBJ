package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Zona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZonaRepository extends MongoRepository<Zona,String> {
}
