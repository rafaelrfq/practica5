package edu.pucmm.eict.web.jms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fechaGeneracion;
    private int idDispositivo;
    private float temperatura;
    private float humedad;

    public Mensaje(){ }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public int getIdDispositivo() { return idDispositivo; }

    public void setIdDispositivo(int idDispositivo) { this.idDispositivo = idDispositivo; }

    public float getTemperatura() { return temperatura; }

    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }

    public float getHumedad() { return humedad; }

    public void setHumedad(float humedad) { this.humedad = humedad; }
}
