package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Address;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.AddressRepository;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if(optionalAddress.isPresent())
            return optionalAddress.get();
        else
            throw new CustomerNotFoundException("Customer Not Found");
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        address.setCity(address.getCity());
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(long id) {
        addressRepository.deleteById(id);
    }

}
