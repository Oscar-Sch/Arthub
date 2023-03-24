package com.mindhub.merchshop.repositories;

import com.mindhub.merchshop.models.Usuario;

public interface UsuarioRepository {

    Usuario findByEmail (String email);
}
