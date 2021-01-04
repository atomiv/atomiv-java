package org.atomiv.template.lite.web.restapi.services;

import org.atomiv.template.lite.web.restapi.models.Simple;

import java.util.List;

public interface SimpleService {

    // GET
    List<Simple> getAllSimples();

    // GET id
    Simple getSimpleById(long id);

    // POST
    Simple createSimple(Simple simple);

    // UPDATE
    Simple updateSimple(Simple simple);

    // DELETE
    void deleteSimpleById(long id);

    void deleteAllSimples();

}
