package Endpoint;

import Service.StudentService;
import dto.StudentDto;
import io.grpc.stub.StreamObserver;
import io.micronaut.http.annotation.Controller;
import jakarta.inject.Inject;
import studentcrud.*;

import java.util.UUID;

@Controller
public class StudentEndpoint extends StudentcrudServiceGrpc.StudentcrudServiceImplBase{

    @Inject
    StudentService studentService;

    @Override
    public void insert(InsertStudentRequest request, StreamObserver<SuccessMessage> responseObserver) {
        var data = StudentDto.builder()
                .fullName(request.getFullName())
                .age(request.getAge())
                .address(request.getAddress())
                .salary(request.getSalary())
                .build();
        studentService.insert(data);
        var response = SuccessMessage.newBuilder().setMessage("Success")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void fetch(GetStudentRequest request, StreamObserver<GetAllResponse> responseObserver) {
//        var studentDtoList = studentService.getAllStudents();
//        var response = GetAllResponse.newBuilder()
//                .addAllRequest(studentDtoList)
//                .build();
//        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateStudentRequest request, StreamObserver<GetStudentResponse> responseObserver) {
        var userId = studentService.find(UUID.fromString(request.getId()));

        var data = StudentDto.builder()
                .fullName(request.getFullName())
                .age(request.getAge())
                .address(request.getAddress())
                .salary(request.getSalary())
                .id(UUID.fromString(request.getId()))
                .build();
        var updated =studentService.update(data);
        var response = GetStudentResponse.newBuilder()
                .setAddress(updated.address())
                .setAge(updated.age())
                .setFullName(updated.fullName())
                .setSalary(updated.salary())
                .setId(userId.id().toString())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(DeleteStudentRequest request, StreamObserver<SuccessMessage> responseObserver) {
//        responseObserver.onNext();
//        responseObserver.onCompleted();
    }
}
