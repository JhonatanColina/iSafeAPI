package br.com.isafe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Document
public class Usuario implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String usuario;
	private String senha;
	private boolean admin;
	
	@DBRef(lazy = true)
	private List<Sensor> sensores = new ArrayList<>();
	
	public Usuario() {}
	
	public List<Sensor> getSensores()
	{
		return sensores;
	}

	public void setSensores(List<Sensor> sensores)
	{
		this.sensores = sensores;
	}

	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getUsuario()
	{
		return usuario;
	}
	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}
	public String getSenha()
	{
		return senha;
	}
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	public boolean isAdmin()
	{
		return admin;
	}
	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}
}
