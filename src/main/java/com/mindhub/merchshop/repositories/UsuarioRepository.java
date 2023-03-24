package com.mindhub.merchshop.repositories;

import com.mindhub.merchshop.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByEmail(String email);
}
