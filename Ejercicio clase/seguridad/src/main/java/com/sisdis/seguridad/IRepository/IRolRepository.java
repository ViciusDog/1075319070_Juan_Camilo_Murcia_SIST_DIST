package com.sisdis.seguridad.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisdis.seguridad.Entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{

}
