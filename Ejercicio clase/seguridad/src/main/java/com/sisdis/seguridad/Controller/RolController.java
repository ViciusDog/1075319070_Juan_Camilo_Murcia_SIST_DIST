package com.sisdis.seguridad.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sisdis.seguridad.Entity.Persona;
import com.sisdis.seguridad.IService.IPersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/seguridad/Persona")
public class RolController {

	@Autowired
	private IPersonaService service;

	@GetMapping()
	public List<Persona> all() {
		return service.all();
	}

	@GetMapping("{id}")
	public Optional<Persona> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Persona save(@RequestBody Persona Rol) {
		return service.save(Rol);
	}

	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@RequestBody Persona Rol, @PathVariable Long id) {
		service.update(Rol, id);
	}

	@PutMapping("deleteLogical/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteLogical(@PathVariable Long id) {
		service.deleteLogical(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletePhysical(@PathVariable Long id) {
		service.deletePhysical(id);
	}
}
