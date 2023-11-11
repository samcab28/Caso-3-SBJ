package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Contacto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends MongoRepository<Contacto,String> {
}
