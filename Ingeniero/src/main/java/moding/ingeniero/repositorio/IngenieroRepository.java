package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Ingeniero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IngenieroRepository extends MongoRepository<Ingeniero, String> {
    List<Ingeniero> findByCorreoAndPassword(String Correo, String Password);
}

