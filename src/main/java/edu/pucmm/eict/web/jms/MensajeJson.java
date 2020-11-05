package edu.pucmm.eict.web.jms;

import java.time.LocalDateTime;

public class MensajeJson {
    private LocalDateTime fechaGeneracion;
    private int idDispositivo;
    private float temperatura;
    private float humedad;

    public MensajeJson(){ }

    public MensajeJson(LocalDateTime fecha, int idDisp, float temperatura, float humedad){
        this.fechaGeneracion = fecha;
        this.idDispositivo = idDisp;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public int getIdDispositivo() { return idDispositivo; }

    public void setIdDispositivo(int idDispositivo) { this.idDispositivo = idDispositivo; }

    public float getTemperatura() { return temperatura; }

    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }

    public float getHumedad() { return humedad; }

    public void setHumedad(float humedad) { this.humedad = humedad; }
}
