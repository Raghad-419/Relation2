package com.example.school.Controller;

import com.example.school.ApiResponse.ApiResponse;
import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Address;
import com.example.school.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));

    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updatedAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }


}
