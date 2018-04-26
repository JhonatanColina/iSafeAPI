package br.com.isafe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario
{
	@Id
	private String id;
	private String usuario;
	private String senha;
	private boolean admin;
	
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
