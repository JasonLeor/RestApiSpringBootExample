package com.jordanec.restbootexample.model;
// Generated 04-ene-2016 19:14:02 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.jordanec.restbootexample.util.EquipoSerializer;

/**
 * Equipo generated by hbm2java
 */
@Entity
@Table(name = "Equipo", catalog = "FutbolDB_V2")
@JsonIgnoreProperties({"patrocinadores", "estadios", "jugadores", "pais"})
@JsonSerialize(using=EquipoSerializer.class)
public class Equipo implements java.io.Serializable {

	private Integer idEquipo;
	private Pais pais;
	private String nombre;
	private int campeonatos;
	private Set<Patrocinador> patrocinadores = new HashSet<Patrocinador>(0);
	private Set<Estadio> estadios = new HashSet<Estadio>(0);
	private Set<Jugador> jugadores = new HashSet<Jugador>(0);

	public Equipo() {
	}

	public Equipo(Pais pais, String nombre, int campeonatos) {
		this.pais = pais;
		this.nombre = nombre;
		this.campeonatos = campeonatos;
	}

	public Equipo(Pais pais, String nombre, int campeonatos, Set<Patrocinador> patrocinadores, Set<Estadio> estadios,
			Set<Jugador> jugadores) {
		this.pais = pais;
		this.nombre = nombre;
		this.campeonatos = campeonatos;
		this.patrocinadores = patrocinadores;
		this.estadios = estadios;
		this.jugadores = jugadores;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEquipo", unique = true, nullable = false)
	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPais", nullable = false)
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "campeonatos", nullable = false)
	public int getCampeonatos() {
		return this.campeonatos;
	}

	public void setCampeonatos(int campeonatos) {
		this.campeonatos = campeonatos;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Equipo_Patrocinador", catalog = "FutbolDB_V2", joinColumns = {
			@JoinColumn(name = "idEquipo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idPatrocinador", nullable = false, updatable = false) })
	public Set<Patrocinador> getPatrocinadores() {
		return this.patrocinadores;
	}

	public void setPatrocinadores(Set<Patrocinador> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Equipo_Estadio", catalog = "FutbolDB_V2", joinColumns = {
			@JoinColumn(name = "idEquipo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idEstadio", nullable = false, updatable = false) })
	public Set<Estadio> getEstadios() {
		return this.estadios;
	}

	public void setEstadios(Set<Estadio> estadios) {
		this.estadios = estadios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<Jugador> getJugadores() {
		return this.jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getNombre(), getCampeonatos(), getEstadios(), getJugadores(),
				getPais(), getPatrocinadores());
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof Equipo) {
			Equipo other = (Equipo)object;
			return Objects.equal(getNombre(), other.getNombre())
				&& Objects.equal(getCampeonatos(), other.getCampeonatos())
				&& Objects.equal(getEstadios(), other.getEstadios())
				&& Objects.equal(getJugadores(), other.getJugadores())
				&& Objects.equal(getPais(), other.getPais())
				&& Objects.equal(getPatrocinadores(), other.getPatrocinadores());
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return " {\"idEquipo\":" + idEquipo + ",\"pais\":\"" + pais + "\",\"nombre\":\"" + nombre
				+ "\",\"campeonatos\":" + campeonatos + "}";
	}
	
	
}
