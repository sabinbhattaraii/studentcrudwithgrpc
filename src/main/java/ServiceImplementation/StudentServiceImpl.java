package ServiceImplementation;

import Service.StudentService;
import dto.StudentDto;
import entity.StudentEntity;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import mapper.MapperClass;
import repository.StudentRepository;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentRepository studentRepository;

    @Override
    public StudentDto insert(StudentDto studentDto) {
        StudentEntity studentEntity = MapperClass.toEntity(studentDto);
        return MapperClass.toDto(studentRepository.save(studentEntity));
    }

    @Override
    public StudentDto getAllStudents() {
//        var lisEntity = StudentRepository.findAll();
//        var dtoList = MapperClass.toEntity(lisEntity);
//        return dtoList;
        return null;
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        StudentEntity studentEntity = MapperClass.toEntity(studentDto);
        return MapperClass.toDto(studentRepository.update(studentEntity));
    }

    @Override
    public StudentDto find(UUID uuid) {
        return studentRepository.findById(uuid)
                .map(MapperClass::toDto)
                .orElseThrow(RuntimeException::new);
    }
}
