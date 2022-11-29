package mapper;

import dto.StudentDto;
import entity.StudentEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Builder(toBuilder = true)
public class MapperClass {
    //changing dto type to Entity
    public static StudentEntity toEntity(StudentDto studentDto){
        return StudentEntity.builder()
                .id(Optional.ofNullable(studentDto.id()).orElse(UUID.randomUUID()))
                .fullName(studentDto.fullName())
                .age(studentDto.age())
                .address(studentDto.address())
                .salary(studentDto.salary())
                .build();
    }

    // changing studententity entity type to dto
    public static StudentDto toDto(StudentEntity studententity){
        return StudentDto.builder()
                .id(studententity.getId())
                .fullName(studententity.getFullName())
                .age(studententity.getAge())
                .address(studententity.getAddress())
                .salary(studententity.getSalary())
                .build();
    }
    public static List<StudentDto> toDtoList(List<StudentEntity> studentEntities){
        return studentEntities.stream().map(data-> toDto(data)).collect(Collectors.toList());
    }
}
