package com.example.school.Service;

import com.example.school.ApiResponse.ApiException;
import com.example.school.Model.Address;
import com.example.school.Model.Teacher;
import com.example.school.Repository.AddressRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher =teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new ApiException("Teacher not found");
        }
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());

        teacherRepository.save(oldTeacher);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.getTeacherById(id);
        if(teacher==null) {
            throw new ApiException("Teacher not found");
        }
        Address address = addressRepository.findAddressById(id);

        teacher.setAddress(null);
        if(address != null){
        addressRepository.delete(teacher.getAddress());}
        teacherRepository.delete(teacher);
    }


    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        return teacher;
    }

}
