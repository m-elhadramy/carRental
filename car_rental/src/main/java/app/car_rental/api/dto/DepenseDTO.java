package app.car_rental.api.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DepenseDTO {

    @NotNull
    private Long voitureId;

    @NotNull
    private Long typeId;

    @NotNull
    private BigDecimal montant;

    @NotNull
    private LocalDate date;

    private String description;

    public DepenseDTO() {}

    public Long getVoitureId() { return voitureId; }
    public void setVoitureId(Long voitureId) { this.voitureId = voitureId; }
    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
