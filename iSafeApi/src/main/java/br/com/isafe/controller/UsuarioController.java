package br.com.isafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import br.com.isafe.repository.UsuarioRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController
{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/** 
	 * Busca todas os usuarios persistidos na base de dados<br>
	 * Ver mais em {@link #buscarTodosUsuarios()}.
	 * @return Lista de Usuarios
	 */
  @GetMapping
  List<Usuario> buscarTodos()
  {
  	return usuarioRepository.findAll();
  }
  
  /** 
	 * Busca sensores por usuario<br>
	 * Ver mais em {@link #buscarTodosUsuarios()}.
	 * @return Lista de Usuarios
	 */
  @GetMapping("/sensores")
  List<Sensor> buscarPorSensor()
  {
  	return usuarioRepository.findBysensores();
  }
  
  
  /** 
	 * Busca todas os usuarios persistidos na base de dados pelo nome<br>
	 * Ver mais em {@link #buscarUsuariosPorNome()}.
	 * @return Lista de Usuarios
	 */
  @GetMapping("/nomeUsuario/{nomeUsuario}")
  List<Usuario> buscarUsuarioPeloNome(@PathVariable(value = "nomeUsuario") String nomeUsuario)
  {
  	return usuarioRepository.findByUsuarioContaining(nomeUsuario);
  }
  
	/** 
	 * Retorna um usuario de acordo com o id.<br>
	 * Ver mais em {@link UsuarioService#buscarPorId(String)}.
	 * @param id id do usuario na base
	 * @return Classe Usuario
	 */
  @GetMapping("/id/{id}")
	public Usuario buscaUsuarioId(@PathVariable(value = "id") String id)
	{
  	return usuarioRepository.findById(id);
	}
  
  /** 
	 * Verifica Dados de acesso ao usuario no aplicativo<br>
	 * Ver mais em {@link #buscarPorId(String)}.
	 * @return Classe usuario
	 * @param usuario nome de acesso do usuario
	 * @param senha senha de acesso do usuario
	 */
  @PostMapping("/login")
	public Usuario realizaLogin(@RequestBody Usuario u)
	{
  	return usuarioRepository.findByUsuarioAndSenha(u.getUsuario(), u.getSenha());
	}
  
  /** 
	 * Persiste um usuario na base de dados.
	 * Caso exista um usuario com o mesmo id, ele será atualizado com os novos dados<br>
	 * Ver mais em {@link #salvar(Usuario)}
	 * @param u Classe usuario
	 */
	@PostMapping
	public void salvarUsuario(@RequestBody Usuario u)
	{
		Usuario user = usuarioRepository.findById(u.getId());
		if(user!=null) /*se existir um usuario ele atualiza no banco*/
			u.setId(user.getId());
		
		usuarioRepository.save(u);
	}
	
	/** 
	 * Remove um usuario na base de dados.<br>
	 * Ver mais em {@link #apagar(Usuario)}
	 * @param id ID do usuario
	 */
	@DeleteMapping("/apagar/{id}")
	public void apagarUsuario(@PathVariable(value = "id") String id)
	{
		usuarioRepository.delete(id);
	}
	/** 
	 * retorna quatidade de usuarios cadastrados<br>
	 * Ver mais em {@link #contagemMaquinas()}.
	 */
	@GetMapping("/count")
	public long contagemUsuario()
	{
		return usuarioRepository.count();
	}
}
