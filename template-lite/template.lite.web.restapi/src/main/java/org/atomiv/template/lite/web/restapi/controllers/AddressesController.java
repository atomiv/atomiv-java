package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Address;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressesController {

    @Autowired
    AddressService addressService;


    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<Address>> getAllAddresses()
    {
        List<Address> list = addressService.getAllAddresses();
        return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id)
    {
        try {
            return new ResponseEntity<Address>(addressService.getAddressById(id), HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer Not Found");
        }
    }


    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address)
    {
        return new ResponseEntity<Address>(addressService.createAddress(address), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") Long id, @Valid @RequestBody Address address)
    {
        return new ResponseEntity<Address>(addressService.updateAddress(address), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }
}
