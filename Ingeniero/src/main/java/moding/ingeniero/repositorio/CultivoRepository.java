package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Cultivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CultivoRepository extends MongoRepository<Cultivo,String>{
    Optional<Cultivo> findByNombre(String nombre);
}
