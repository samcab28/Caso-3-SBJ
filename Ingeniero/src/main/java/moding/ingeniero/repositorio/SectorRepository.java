package moding.ingeniero.repositorio;

import moding.ingeniero.modelo.Sector;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends MongoRepository<Sector,String> {
}
