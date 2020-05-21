package nauka.coming.service;

import nauka.coming.dao.WorkerRepository;
import nauka.coming.domain.WorkerEntity;
import nauka.coming.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public List<WorkerEntity> getAllWorkers() {
        List<WorkerEntity> result = (List<WorkerEntity>) workerRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<WorkerEntity>();
        }
    }

    public WorkerEntity getWorkerById(Long id) throws RecordNotFoundException
    {
        Optional<WorkerEntity> employee = workerRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("Нет работников по данному ID");
        }
    }
    public WorkerEntity createOrUpdateWorker(WorkerEntity entity)
    {
        if(entity.getId()  == null)
        {
            entity = workerRepository.save(entity);

            return entity;
        }
        else
        {
            Optional<WorkerEntity> employee = workerRepository.findById(entity.getId());

            if(employee.isPresent())
            {
                WorkerEntity newEntity = employee.get();
                newEntity.setFirstname(entity.getFirstname());
                newEntity.setLastname(entity.getLastname());
                newEntity.setBirthday(entity.getBirthday());
                newEntity.setAge(entity.getAge());
                newEntity.setPosition(entity.getPosition());
                newEntity.setUdalenkaornot(entity.isUdalenkaornot());
                newEntity.setAdress(entity.getAdress());

                newEntity = workerRepository.save(newEntity);

                return newEntity;
            } else {
                entity = workerRepository.save(entity);

                return entity;
            }
        }
    }
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<WorkerEntity> employee = workerRepository.findById(id);

        if(employee.isPresent())
        {
            workerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Нет работников по данному ID");
        }
    }


}
