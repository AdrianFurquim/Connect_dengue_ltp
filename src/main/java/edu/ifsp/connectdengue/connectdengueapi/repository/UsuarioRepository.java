
package edu.ifsp.connectdengue.connectdengueapi.repository;
import org.springframework.data.repository.CrudRepository;

import edu.ifsp.connectdengue.connectdengueapi.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    Usuario findByUsername(String username);

}