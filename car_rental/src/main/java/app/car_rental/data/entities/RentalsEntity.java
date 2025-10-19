package app.car_rental.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rentals", schema = "car_rental_db", catalog = "")
public class RentalsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "client_id")
    private long clientId;
    @Basic
    @Column(name = "car_id")
    private long carId;
    @Basic
    @Column(name = "date_debut")
    private Date dateDebut;
    @Basic
    @Column(name = "date_fin")
    private Date dateFin;
    @Basic
    @Column(name = "montant")
    private BigDecimal montant;
    @Basic
    @Column(name = "statut")
    private Integer statut;
    @Basic
    @Column(name = "date_creation")
    private Timestamp dateCreation;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private ClientsEntity clientsByClientId;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private CarsEntity carsByCarId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalsEntity that = (RentalsEntity) o;
        return id == that.id && clientId == that.clientId && carId == that.carId && Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin) && Objects.equals(montant, that.montant) && Objects.equals(statut, that.statut) && Objects.equals(dateCreation, that.dateCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, carId, dateDebut, dateFin, montant, statut, dateCreation);
    }

    public ClientsEntity getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(ClientsEntity clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    public CarsEntity getCarsByCarId() {
        return carsByCarId;
    }

    public void setCarsByCarId(CarsEntity carsByCarId) {
        this.carsByCarId = carsByCarId;
    }
}
