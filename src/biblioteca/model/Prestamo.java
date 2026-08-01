package biblioteca.model;

import java.time.Instant;

public class Prestamo {

    private String id;
    private String usuarioId;
    private Instant fecha;
    private Double multa;

    public Prestamo() {
    }

    public Prestamo(String id, String usuarioId, Instant fecha, Double multa) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.multa = multa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Double getMulta() {
        return multa;
    }

    public void setMulta(Double multa) {
        this.multa = multa;
    }
}
