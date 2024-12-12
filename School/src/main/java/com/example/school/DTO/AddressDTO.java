package com.example.school.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "Empty area")
    private String area;
    @NotEmpty(message = "empty street")
    private String street;
    @NotNull(message = "empty building number")
    private Integer buildingNumber;


}
