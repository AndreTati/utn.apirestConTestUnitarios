package com.utn.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@NoRepositoryBean
public interface BaseRepository <Base, ID extends Serializable> extends JpaRepository<Base, ID> {
}
