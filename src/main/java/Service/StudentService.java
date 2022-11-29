package Service;

import dto.StudentDto;
import entity.StudentEntity;

import java.util.Optional;
import java.util.UUID;

public interface StudentService{
    StudentDto insert(StudentDto studentDto);
    StudentDto update(StudentDto studentDto);

    StudentDto getAllStudents();

    StudentDto find(UUID uuid);
}
