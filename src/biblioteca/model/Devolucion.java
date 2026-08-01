package biblioteca.model;

import java.time.LocalDateTime;

public class Devolucion {

    private String id;
    private String prestamoId;
    private LocalDateTime returnDate;
    private Double fee;

    public Devolucion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(String prestamoId) {
        this.prestamoId = prestamoId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Devolucion(String id, String prestamoId, LocalDateTime returnDate, Double fee) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.returnDate = returnDate;
        this.fee = fee;
    }
}