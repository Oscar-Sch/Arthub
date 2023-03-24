package com.mindhub.merchshop.repositories;

import com.mindhub.merchshop.models.Ilustracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IlustracionRepository extends JpaRepository<Ilustracion, Long> {
}
