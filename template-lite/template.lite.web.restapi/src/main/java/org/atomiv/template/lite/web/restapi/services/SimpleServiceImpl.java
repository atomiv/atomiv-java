package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Address;
import org.atomiv.template.lite.web.restapi.models.Order;
import org.atomiv.template.lite.web.restapi.models.Simple;
import org.atomiv.template.lite.web.restapi.models.HomeAddress;
import org.atomiv.template.lite.web.restapi.repositories.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleServiceImpl implements SimpleService {



    @Autowired
    private SimpleRepository simpleRepository;



    @Override
    public List<Simple> getAllSimples() {
        return (List<Simple>) simpleRepository.findAll();
    }


    @Override
    public Simple getSimpleById(long id) {
        Optional<Simple> optionalSimple = simpleRepository.findById(id);

        if(optionalSimple.isPresent())
            return optionalSimple.get();
        else
            throw new ResourceNotFoundException(new CustomerNotFoundException("Simple Not Found"));
    }





    @Override
    public Simple createSimple(Simple simple) {

//        for (Order order : simple.getOrders()) {
//            order.setSimple(simple);
//        }

        return simpleRepository.save(simple);

    }


    @Override
    public Simple updateSimple(Simple simple) {

        Optional<Simple> existingSimple =
                simpleRepository.findById(simple.getId());
        if(existingSimple.isEmpty()) {
            throw new RuntimeException("Cannot find the simple with id " + simple.getId());
        }
        existingSimple.get().setFirstName(simple.getFirstName());
        existingSimple.get().setLastName(simple.getLastName());
        return simpleRepository.save(existingSimple.get());
    }




    @Override
    public void deleteSimpleById(long id) {
        simpleRepository.deleteById(id);
    }



    @Override
    public void deleteAllSimples() {
        simpleRepository.deleteAll();
    }

}




