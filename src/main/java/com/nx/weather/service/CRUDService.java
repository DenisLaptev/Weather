package com.nx.weather.service;

import java.io.IOException;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

//Service works with domain objects (persistent objects are encapsulated inside service)

//D - domain(ui) type
//K - id type
public interface CRUDService<D, K> {

    void create(D obj);

    D findById(K id);

    List<D> findAll() throws IOException, InterruptedException;

    D update(D obj);

    void delete(D obj);
}
