package dto;

import lombok.Builder;

import java.util.UUID;


@Builder
public record StudentDto(
        UUID id,
        String address,
        int age,
        String fullName,
        Float salary
){
}

