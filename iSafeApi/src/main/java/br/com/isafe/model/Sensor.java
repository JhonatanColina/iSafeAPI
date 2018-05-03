package br.com.isafe.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Sensor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String codSensor;
	private String macAddress;
	private String localSensor;
	
	@JsonCreator
	public Sensor(@JsonProperty("codSensor") String codSensor,@JsonProperty("macAddress") String macAddress,@JsonProperty("localSensor") String localSensor)
	{
		super();
		this.codSensor = codSensor;
		this.macAddress = macAddress;
		this.localSensor = localSensor;
	}
	
	public Sensor() {}

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
