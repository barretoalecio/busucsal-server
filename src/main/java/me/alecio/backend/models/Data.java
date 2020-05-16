package me.alecio.backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DATAS")
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	final private String _DATA;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Data() {
		_DATA = dateTimeFormatter.format(LocalDateTime.now());
	}

	public String getData() {
		return this._DATA;
	}
}