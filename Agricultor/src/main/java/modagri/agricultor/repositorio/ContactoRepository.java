package modagri.agricultor.repositorio;

import modagri.agricultor.modelo.Contacto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends MongoRepository<Contacto,String> {
}
