package nauka.coming.dao;

import nauka.coming.domain.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity, Long> {

    WorkerEntity findByFirstName(String firstname);

    Iterable<WorkerEntity> findAll();


}
