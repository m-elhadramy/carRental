package app.car_rental.api.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VenteDTO {

    @NotNull
    private Long clientId;

    @NotNull
    private Long voitureId;

    @NotNull
    private LocalDateTime dateVente;

    @NotNull
    private BigDecimal prix;

    private Integer kilometrage;
    private Long modePaiementId;
    private boolean gps;
    private boolean childSeat;
    private boolean insurance;
    private BigDecimal remise;
    private Long statutId;
    private String note;

    public VenteDTO() {}

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
    public Long getVoitureId() { return voitureId; }
    public void setVoitureId(Long voitureId) { this.voitureId = voitureId; }
    public LocalDateTime getDateVente() { return dateVente; }
    public void setDateVente(LocalDateTime dateVente) { this.dateVente = dateVente; }
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
    public Integer getKilometrage() { return kilometrage; }
    public void setKilometrage(Integer kilometrage) { this.kilometrage = kilometrage; }
    public Long getModePaiementId() { return modePaiementId; }
    public void setModePaiementId(Long modePaiementId) { this.modePaiementId = modePaiementId; }
    public boolean isGps() { return gps; }
    public void setGps(boolean gps) { this.gps = gps; }
    public boolean isChildSeat() { return childSeat; }
    public void setChildSeat(boolean childSeat) { this.childSeat = childSeat; }
    public boolean isInsurance() { return insurance; }
    public void setInsurance(boolean insurance) { this.insurance = insurance; }
    public BigDecimal getRemise() { return remise; }
    public void setRemise(BigDecimal remise) { this.remise = remise; }
    public Long getStatutId() { return statutId; }
    public void setStatutId(Long statutId) { this.statutId = statutId; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
