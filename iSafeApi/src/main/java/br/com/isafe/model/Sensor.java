package br.com.isafe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sensor {
	
	@Id
	private String codSensor;
	private String macAddress;
	private String localSensor;

	public String getCodSensor()
	{
		return codSensor;
	}

	public void setCodSensor(String codSensor)
	{
		this.codSensor = codSensor;
	}

	public String getLocalSensor()
	{
		return localSensor;
	}

	public void setLocalSensor(String localSensor)
	{
		this.localSensor = localSensor;
	}

	public String getMacAddress()
	{
		return macAddress;
	}

	public void setMacAddress(String macAddress)
	{
		this.macAddress = macAddress;
	}
}
