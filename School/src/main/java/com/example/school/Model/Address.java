package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "Empty area")
    private String area;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "empty street")
    private String street;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "empty building number")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
