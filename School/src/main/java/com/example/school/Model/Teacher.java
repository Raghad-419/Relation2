package com.example.school.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(columnDefinition = "varchar(10) not null")
    @NotEmpty(message = "Empty name")
    public String name;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "empty age")
    @Min(value = 24,message = "Age should be more than 24")
    public Integer age;
    @Column(columnDefinition = "varchar(30) not null unique")
    @NotEmpty(message = "Empty email")
    public String email;
    @Column(columnDefinition = "DOUBLE not null")
    @NotNull(message = "empty salary")
    public Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

@OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
private Set<Course> courses;

}
