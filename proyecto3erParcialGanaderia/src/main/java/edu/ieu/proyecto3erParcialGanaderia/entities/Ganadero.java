package edu.ieu.proyecto3erParcialGanaderia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ganado")
public class Ganadero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String tipo_de_animal;
	
	@Column
	private String tipo_de_produccion_de_alimentos;
	
	@Column
	private String estado_de_salud;
	
	@Column
	private Double costo;
	
	@Column
	private String tiempo_de_produccion;
	
	public Ganadero() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo_de_animal() {
		return tipo_de_animal;
	}

	public void setTipo_de_animal(String tipo_de_animal) {
		this.tipo_de_animal = tipo_de_animal;
	}

	public String getTipo_de_produccion_de_alimentos() {
		return tipo_de_produccion_de_alimentos;
	}

	public void setTipo_de_produccion_de_alimentos(String tipo_de_produccion_de_alimentos) {
		this.tipo_de_produccion_de_alimentos = tipo_de_produccion_de_alimentos;
	}

	public String getEstado_de_salud() {
		return estado_de_salud;
	}

	public void setEstado_de_salud(String estado_de_salud) {
		this.estado_de_salud = estado_de_salud;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getTiempo_de_produccion() {
		return tiempo_de_produccion;
	}

	public void setTiempo_de_produccion(String tiempo_de_produccion) {
		this.tiempo_de_produccion = tiempo_de_produccion;
	}
	
	
}