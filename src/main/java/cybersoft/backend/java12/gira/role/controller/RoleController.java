package cybersoft.backend.java12.gira.role.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java12.gira.common.ResponseHandler;
import cybersoft.backend.java12.gira.dto.AddProgramDto;
import cybersoft.backend.java12.gira.dto.CreateRoleDto;
import cybersoft.backend.java12.gira.dto.RoleDto;
import cybersoft.backend.java12.gira.role.entity.Role;
import cybersoft.backend.java12.gira.role.service.itf.RoleService;

@RestController
@RequestMapping("api/role")
public class RoleController {
	private RoleService service;
	
	public RoleController(RoleService roleService) {
		service = roleService;
	}
	
	@GetMapping
	public Object findAllRole() {
		List<RoleDto> roles = service.findAll();
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	@PostMapping
	public Object saveRole(@Valid @RequestBody CreateRoleDto dto, BindingResult errors) {
			if(errors.hasErrors())
				return ResponseHandler.getResponse(errors, HttpStatus.OK);
			
			Role addedRole = service.addNewRole(dto);
		return ResponseHandler.getResponse(addedRole, HttpStatus.CREATED);
	}
	
	@PostMapping("/add-program")
	public Object addProgram(@Valid @RequestBody AddProgramDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Role updatedRole = service.addProgram(dto);
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}
	
	@PutMapping("/remove-program")
	public Object removeProgram(@Valid @RequestBody AddProgramDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		Role updatedRole = service.removeProgram(dto);
		return ResponseHandler.getResponse(updatedRole,HttpStatus.OK);
	}
	
	
}
