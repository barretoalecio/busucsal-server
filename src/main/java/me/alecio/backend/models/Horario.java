package me.alecio.backend.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import me.alecio.backend.models.enums.DiaDaSemanaEnum;

@Entity
@Table(name = "TB_HORARIOS")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private DiaDaSemanaEnum diaDaSemana;
	private String horaInicio;
	@OneToOne(cascade = { CascadeType.ALL })
	private Roteiro roteiro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiaDaSemanaEnum getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemanaEnum diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}