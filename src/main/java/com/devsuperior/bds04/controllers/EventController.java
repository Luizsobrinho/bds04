package com.devsuperior.bds04.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventController {

	@Autowired
	private EventService service;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> update(@PathVariable Long id, @Valid @RequestBody EventDTO eventDTO){
		
		EventDTO evenDto = service.update(id, eventDTO);
		
		return ResponseEntity.ok().body(evenDto);
	}
}
