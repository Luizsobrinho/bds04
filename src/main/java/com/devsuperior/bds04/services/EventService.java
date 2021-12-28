package com.devsuperior.bds04.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.exceptions.ResourceNotFoundException;


@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	public EventDTO update (Long id, EventDTO eventDTO) {
		
		try {
			Event event = repository.getOne(id);
			event.setCity(new City(eventDTO.getCityId(), null));
			event.setDate(eventDTO.getDate());
			event.setName(eventDTO.getName());
			event.setUrl(eventDTO.getUrl());
			event = repository.save(event);
			return new EventDTO(event);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
		
	}
}
