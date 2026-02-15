package com.example.demo.controller;

import com.example.demo.model.Usuario;

//Importamos el servicio UsuarioService que contiene la logica de negocio
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Anotamos la clase como un controlados REST
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping //Metodo para obtener todos los empleados
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        //Llamamos al servicio para guardar el nuevo usuario y devolvemos la respuesta con el usuario guardado y el estado HTTP 201 (CREATED)
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
        public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
            
            Optional<Usuario> usuarioOptional = usuarioService.getUsuarioById(id);

            if (!usuarioOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Usuario usuario = usuarioOptional.get();

            // 🔥 Actualiza aquí los campos que tenga tu entidad Usuario
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setCorreo(usuarioDetails.getCorreo());
            // agrega los demás campos si existen

            Usuario updatedUsuario = usuarioService.saveUsuario(usuario);

            return ResponseEntity.ok(updatedUsuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
       usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}