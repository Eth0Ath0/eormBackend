package gt.com.edu.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.com.edu.security.entity.Rol;

import gt.com.edu.security.service.IRolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin()
public class rolController {
	
	@Autowired
	public IRolService rolService;
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar")
	public List<Rol> listarRoles(){
		return rolService.findAll();
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESOR')")
	@GetMapping("/listar/page/{page}")
	public Page<Rol> listarRoles(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 4);
		return rolService.findAll(pageable);
	
		
	}



}
