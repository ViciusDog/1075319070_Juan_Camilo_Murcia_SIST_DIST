package com.sisdis.seguridad.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisdis.seguridad.Entity.Persona;
import com.sisdis.seguridad.IRepository.IPersonaRepository;
import com.sisdis.seguridad.IService.IPersonaService;

@Service
public class RolService implements IPersonaService {

	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public List<Persona> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Persona save(Persona Rol) {
		
		Rol.setFechaCreacion(LocalDateTime.now());		
		return repository.save(Rol);
	}

	@Override
	public void update(Persona Rol, Long id) {
		// validar si existe.
		Optional<Persona> op = repository.findById(id);

		if (op.isEmpty()) {
			System.out.println("Dato no encontrado");
		} else {
			// Crear nuevo objeto que va a contener los datos que se van a actualizar
			Persona RolUpdate = op.get();
			RolUpdate.setTipoDocumento(Rol.getTipoDocumento());
			RolUpdate.setDocumento(Rol.getDocumento());
			RolUpdate.setNombre(Rol.getNombre());
			RolUpdate.setApellido(Rol.getApellido());
			RolUpdate.setCorreo(Rol.getCorreo());
			RolUpdate.setDireccion(Rol.getDireccion());
			RolUpdate.setEstado(Rol.getEstado());
			RolUpdate.setFechaModificacion(LocalDateTime.now());

			// Actualizar el objeto
			repository.save(RolUpdate);
		}

	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteLogical(Long id) {
		// validar si existe.
		Optional<Persona> op = repository.findById(id);

		if (op.isEmpty()) {
			System.out.println("Dato no encontrado");
		} else {
			// Crear nuevo objeto que va a contener los datos que se van a actualizar
			Persona RolUpdate = op.get();
			RolUpdate.setFechaEliminacion(LocalDateTime.now());

			// Actualizar el objeto
			repository.save(RolUpdate);
		}
	}
}
