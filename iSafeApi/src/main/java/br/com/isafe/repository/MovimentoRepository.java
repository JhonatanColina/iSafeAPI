package br.com.isafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.isafe.model.Movimento;
import br.com.isafe.model.Sensor;

@Repository
public interface MovimentoRepository extends MongoRepository<Movimento, String>{

	List<Movimento> findByMacAddress(String macAddress);
}
