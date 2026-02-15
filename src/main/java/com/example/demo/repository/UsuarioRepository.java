package com.example.demo.repository;
//Importando la entidad
import com.example.demo.model.Usuario;
//Importamos la interfaz JpaRepository que nos proporciona metodos CRUD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indicamos que esta interfaz es un repositorio de Spring Data JPA
//Definimos la interfaz UsuarioRepository que extiende JpaRepository, indicando el tipo de entidad (Usuario) y el tipo de su clave primaria (Long)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}
