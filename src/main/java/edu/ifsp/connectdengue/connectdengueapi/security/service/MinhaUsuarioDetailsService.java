package edu.ifsp.connectdengue.connectdengueapi.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.ifsp.connectdengue.connectdengueapi.model.Usuario;
import edu.ifsp.connectdengue.connectdengueapi.repository.UsuarioRepository;

public class MinhaUsuarioDetailsService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userLogin = usuarioRepository.findByUsername(username);
        if(userLogin == null)
            throw new UsernameNotFoundException(username);
        return new MinhaUsuarioDetails(userLogin);
    }
    
}