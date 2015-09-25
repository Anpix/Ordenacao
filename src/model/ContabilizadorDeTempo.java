package model;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ContabilizadorDeTempo {
	
	private Instant inicio;
	private Instant termino;

	public ContabilizadorDeTempo(LocalDateTime dataHora) {
		this.inicio =  dataHora.atZone(ZoneId.systemDefault()).toInstant();
		this.termino = inicio;
	}
	
	public ContabilizadorDeTempo() {
		this.inicio = Instant.now();
		this.termino = inicio;
	}
	
	@Override
	public String toString() {
		return "HH:mm:ss.SSS";
	}

	public void terminar() {
		termino = Instant.now();
	}

	public void iniciar() {
		inicio = Instant.now();
	}

	public long getMilesegundos() {
		return Duration.between(inicio, termino).toMillis();
	}

}
