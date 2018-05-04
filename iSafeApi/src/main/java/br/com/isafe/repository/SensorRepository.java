package br.com.isafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.isafe.model.Sensor;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, String>
{
	Sensor findByCodSensor(String codSensor);
	List<Sensor> findByLocalSensorContaining(String localSensor);
}
