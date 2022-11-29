package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString // convert to string so that the value does not come in hashcode
@Entity
@Table(name="Company")

public class StudentEntity {
    @Id
    private UUID id; // uuid data type
    @Column(name = "full_name")
    private String fullName;
    @Column
    private Integer age;
    @Column
    private String address;
    @Column
    private Float salary;
}

