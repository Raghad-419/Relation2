package com.example.school.Service;

import com.example.school.ApiResponse.ApiException;
import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Address;
import com.example.school.Model.Teacher;
import com.example.school.Repository.AddressRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }


    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiException("Teacher not found");
        }
        Address address =new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }


    public void updatedAddress(AddressDTO addressDTO){
        Address oldAddress = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(oldAddress==null){
            throw new ApiException("Address not found");
        }

        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(oldAddress);
    }


}
