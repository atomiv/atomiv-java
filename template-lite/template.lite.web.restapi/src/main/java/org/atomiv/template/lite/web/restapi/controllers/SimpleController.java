package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.exceptions.CustomerNotFoundException;
import org.atomiv.template.lite.web.restapi.exceptions.ResourceNotFoundException;
import org.atomiv.template.lite.web.restapi.models.Simple;
import org.atomiv.template.lite.web.restapi.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/simples")
public class SimpleController {

    @Autowired
    private SimpleService simpleService;


    @GetMapping(path = "")
    public ResponseEntity<List<Simple>> getAllSimples() {
        var simples = simpleService.getAllSimples();
        return new ResponseEntity<List<Simple>>(simples, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Simple> getSimpleById(@PathVariable("id") Long id) {
        try {
            var simple = simpleService.getSimpleById(id);
            return new ResponseEntity<Simple>(simple, HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Simple Not Found");
        }
    }


    @PostMapping(path = "")
    public ResponseEntity<Simple> createSimple(@Valid @RequestBody Simple simple) {
        var newSimple = simpleService.createSimple(simple);
        return new ResponseEntity<Simple>(newSimple, HttpStatus.OK);
    }


    @PutMapping("{id}")
    // public ResponseEntity<Simple> updateSimple(@PathVariable Integer simpleId, @RequestBody Simple newSimple) {
    public ResponseEntity<Simple> updateSimple(@PathVariable(value = "id") Long id, @Valid @RequestBody Simple simple) {
        var updatedSimple = simpleService.updateSimple(simple);
        return new ResponseEntity<Simple>(updatedSimple, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSimple(@PathVariable Long id) {
        simpleService.deleteSimpleById(id);

        // TODO Java Rest API return No Content
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("")
    public void deleteAllSimples() {
        simpleService.deleteAllSimples();
    }
}









