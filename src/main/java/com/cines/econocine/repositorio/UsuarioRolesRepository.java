package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.UsuarioRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolesRepository extends JpaRepository<UsuarioRoles, Integer>, JpaSpecificationExecutor<UsuarioRoles> {

}