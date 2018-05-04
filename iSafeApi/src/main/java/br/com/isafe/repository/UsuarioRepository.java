package br.com.isafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.isafe.model.Sensor;
import br.com.isafe.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>
{
	Usuario findById(String id);
	Usuario findByUsuarioAndSenha(String usuario, String senha);
	List<Usuario> findByUsuarioContaining(String usuario);
	long count();
	List<Usuario> findBySensores(String codSensor);
}
