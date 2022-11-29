package repository;

import dto.StudentDto;
import entity.StudentEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface StudentRepository extends CrudRepository<StudentEntity, UUID>{

    Optional<StudentEntity> findById(UUID uuid);
}