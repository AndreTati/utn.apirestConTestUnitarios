package com.utn.apirest.Services;

import com.utn.apirest.Entities.Base;
import com.utn.apirest.Repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable> {

    public List<E> findALL() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public boolean delete(ID id) throws Exception;
}
