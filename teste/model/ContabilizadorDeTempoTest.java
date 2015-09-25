package model;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import model.ContabilizadorDeTempo;

import org.junit.Test;

public class ContabilizadorDeTempoTest {

	@Test
	public void contabilizaTempo() throws InterruptedException {
		ContabilizadorDeTempo contabilizadorDeTempo = new ContabilizadorDeTempo();
		contabilizadorDeTempo.iniciar();
		long millis = 100;
		Thread.sleep(millis);
		contabilizadorDeTempo.terminar();
		assertEquals(millis, contabilizadorDeTempo.getMilesegundos(), 10);
	}

	@Test
	public void contabilizaAPartirDaDataHoraInformada() {
		Instant instant = Instant.now(); 
		LocalDateTime dataHoraInicio = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		dataHoraInicio = dataHoraInicio.plusHours(-2);
		dataHoraInicio = dataHoraInicio.plusMinutes(-4);
		dataHoraInicio = dataHoraInicio.plusSeconds(-37);
		dataHoraInicio = dataHoraInicio.plusNanos(-343);
		
		ContabilizadorDeTempo contabilizadorDeTempo = new ContabilizadorDeTempo(dataHoraInicio);
		LocalDateTime dataHoraTermino = LocalDateTime.now(ZoneId.systemDefault());
		contabilizadorDeTempo.terminar();
//		Duration duracao = Duration.
//		long millis = ;
//		assertEquals(millis, contabilizadorDeTempo.getMilesegundos(), 10);
	}

}
