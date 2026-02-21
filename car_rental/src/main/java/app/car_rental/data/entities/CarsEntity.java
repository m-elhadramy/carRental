package app.car_rental.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cars", schema = "car_rental_db", catalog = "")
public class CarsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "marque")
    private String marque;
    @Basic
    @Column(name = "modele")
    private String modele;
    @Basic
    @Column(name = "annee")
    private int annee;
    @Basic
    @Column(name = "prix_vente")
    private BigDecimal prixVente;
    @Basic
    @Column(name = "tarif_location")
    private BigDecimal tarifLocation;
    @Basic
    @Column(name = "statut")
    private Integer statut;
    @Basic
    @Column(name = "date_ajout")
    private Timestamp dateAjout;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public BigDecimal getTarifLocation() {
        return tarifLocation;
    }

    public void setTarifLocation(BigDecimal tarifLocation) {
        this.tarifLocation = tarifLocation;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsEntity that = (CarsEntity) o;
        return id == that.id && annee == that.annee && Objects.equals(marque, that.marque) && Objects.equals(modele, that.modele) && Objects.equals(prixVente, that.prixVente) && Objects.equals(tarifLocation, that.tarifLocation) && Objects.equals(statut, that.statut) && Objects.equals(dateAjout, that.dateAjout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marque, modele, annee, prixVente, tarifLocation, statut, dateAjout);
    }
}
