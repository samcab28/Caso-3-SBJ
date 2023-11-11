package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Cultivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivoRepository extends MongoRepository<Cultivo,String>{
}
