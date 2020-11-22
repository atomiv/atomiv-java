package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.models.Address;
import org.atomiv.template.lite.web.restapi.models.Customer;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(long id);

    Address createAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddressById(long id);
}
