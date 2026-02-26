package app.car_rental.api.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocationDTO {

    @NotNull
    private Long clientId;

    @NotNull
    private Long voitureId;

    @NotNull
    private LocalDate dateDebut;

    @NotNull
    private LocalDate dateFin;

    private BigDecimal prix;
    private boolean gps;
    private boolean childSeat;
    private boolean insurance;

    public LocationDTO() {}

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
    public Long getVoitureId() { return voitureId; }
    public void setVoitureId(Long voitureId) { this.voitureId = voitureId; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
    public boolean isGps() { return gps; }
    public void setGps(boolean gps) { this.gps = gps; }
    public boolean isChildSeat() { return childSeat; }
    public void setChildSeat(boolean childSeat) { this.childSeat = childSeat; }
    public boolean isInsurance() { return insurance; }
    public void setInsurance(boolean insurance) { this.insurance = insurance; }
}
