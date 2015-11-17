package model;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class ContabilizadorDeTempo {

    private Instant inicio;
    private Instant termino;

    public ContabilizadorDeTempo(LocalDateTime dataHora) {
        this.inicio = dataHora.atZone(ZoneId.systemDefault()).toInstant();
        this.termino = inicio;
    }

    public ContabilizadorDeTempo() {
        this.inicio = Instant.now();
        this.termino = inicio;
    }

    @Override
    public String toString() {
        long ms = getMilesegundos();
        return convert(ms);
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

    private String convert(long miliSeconds) {
        int hrs = (int) TimeUnit.MILLISECONDS.toHours(miliSeconds) % 24;
        int min = (int) TimeUnit.MILLISECONDS.toMinutes(miliSeconds) % 60;
        int sec = (int) TimeUnit.MILLISECONDS.toSeconds(miliSeconds) % 60;
        int mili = (int) TimeUnit.MILLISECONDS.toMillis(miliSeconds) % 60;
        return String.format("%02d:%02d:%02d:%03d", hrs, min, sec, mili);
    }

}
