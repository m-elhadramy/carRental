package app.car_rental.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class VoitureDTO {

    @NotBlank
    private String marque;

    @NotBlank
    private String modele;

    @NotNull
    private Integer annee;

    private String immatriculation;
    private String couleur;
    private Integer kilometrage;
    private Long typeMoteurId;
    private Long transmissionId;
    private Long typeCarburantId;
    private BigDecimal prixParJour;
    private String notes;
    private Long statutId;

    public VoitureDTO() {}

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }
    public Integer getAnnee() { return annee; }
    public void setAnnee(Integer annee) { this.annee = annee; }
    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }
    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }
    public Integer getKilometrage() { return kilometrage; }
    public void setKilometrage(Integer kilometrage) { this.kilometrage = kilometrage; }
    public Long getTypeMoteurId() { return typeMoteurId; }
    public void setTypeMoteurId(Long typeMoteurId) { this.typeMoteurId = typeMoteurId; }
    public Long getTransmissionId() { return transmissionId; }
    public void setTransmissionId(Long transmissionId) { this.transmissionId = transmissionId; }
    public Long getTypeCarburantId() { return typeCarburantId; }
    public void setTypeCarburantId(Long typeCarburantId) { this.typeCarburantId = typeCarburantId; }
    public BigDecimal getPrixParJour() { return prixParJour; }
    public void setPrixParJour(BigDecimal prixParJour) { this.prixParJour = prixParJour; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public Long getStatutId() { return statutId; }
    public void setStatutId(Long statutId) { this.statutId = statutId; }
}
