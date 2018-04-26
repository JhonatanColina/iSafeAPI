package br.com.isafe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movimento
{
	@Id
	private String data;
	private String macAddress;

	public String getMacAddress()
	{
		return macAddress;
	}

	public void setMacAddress(String macAddress)
	{
		this.macAddress = macAddress;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
