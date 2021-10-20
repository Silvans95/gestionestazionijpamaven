package it.prova.gestionestazionijpamaven.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "citta")
public class Citta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "denominazione")
	private String denominazione;
	@Column(name = "numeroAbitanti")
	private Integer numeroAbitanti;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "citta")
	private Set<Stazione> stazioni = new HashSet<>();

	public Citta() {
		// TODO Auto-generated constructor stub
	}

	public Citta(String denominazione, Integer numeroAbitanti) {
		super();

		this.denominazione = denominazione;
		this.numeroAbitanti = numeroAbitanti;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public Integer getNumeroAbitanti() {
		return numeroAbitanti;
	}

	public void setNumeroAbitanti(Integer numeroAbitanti) {
		this.numeroAbitanti = numeroAbitanti;
	}

	public Set<Stazione> getStazioni() {
		return stazioni;
	}

	public void setStazioni(Set<Stazione> stazioni) {
		this.stazioni = stazioni;
	}

	@Override
	public String toString() {
		return "Citta [denominazione=" + denominazione + ", numeroAbitanti=" + numeroAbitanti + "]";
	}

}
