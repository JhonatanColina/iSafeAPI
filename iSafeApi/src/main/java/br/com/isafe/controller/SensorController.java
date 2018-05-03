package br.com.isafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isafe.model.Sensor;
import br.com.isafe.model.Usuario;
import br.com.isafe.repository.SensorRepository;



@RestController
@CrossOrigin
@RequestMapping(value = "/sensor")
public class SensorController {

	@Autowired
	private SensorRepository sensorRepository;
	
	@PostMapping
	public void salvar(@RequestBody Sensor s) 
	{
		sensorRepository.save(s);
	}
	
	@GetMapping
	public List<Sensor> retornar()
	{
		List<Sensor> lista = sensorRepository.findAll();
		return lista;
	}

	@GetMapping(value = "/id/{id}", produces = "application/json; charset=UTF-8")
	public Sensor buscaSensorId(@PathVariable(value = "id") String id)
	{
		return sensorRepository.findByCodSensor(id);
	}
}
