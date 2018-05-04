package br.com.isafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isafe.model.Movimento;
import br.com.isafe.repository.MovimentoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/movimento")
public class MovimentoController {

	@Autowired
	private MovimentoRepository movimentoRepository;
	
	@PostMapping("/enviaMovimento/{mac}")
	public void recebeMovimentacao(@PathVariable(value = "mac") String macAddress) 
	{
		Movimento m = new Movimento();
		LocalDateTime  hoje = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String hojeFormatado = hoje.format(formatter);
		m.setData(hojeFormatado);
		m.setMacAddress(macAddress);
		movimentoRepository.save(m);
	}
	
	/** 
	 * Retorna uma lista de movimentos do sensor.<br>
	 * @param macAddress macAddress do sensor
	 * @return Lista de movimentos
	 */
  @GetMapping("/historico/{macAddress}")
	public List<Movimento> HistoricoSensor(@PathVariable(value = "macAddress") String macAddress)
	{
  	return movimentoRepository.findByMacAddress(macAddress);
	}
	
	@GetMapping("/ultimaMovimentacao")
	public Movimento data()
	{
		Movimento resposta = null;

		List<Movimento> lista = movimentoRepository.findAll();
		long primeiro = 0;
		for(Movimento item : lista)
		{
			if(primeiro < Long.parseLong(item.getData()))
			{
				resposta = item;
			}
		}
		return resposta;
	}
}
