package app.car_rental.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "car_rental_db", catalog = "")
public class SalesEntity {
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
    @Column(name = "prix")
    private BigDecimal prix;
    @Basic
    @Column(name = "date_vente")
    private Date dateVente;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private ClientsEntity clientsByClientId;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
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

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesEntity that = (SalesEntity) o;
        return id == that.id && clientId == that.clientId && carId == that.carId && Objects.equals(prix, that.prix) && Objects.equals(dateVente, that.dateVente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, carId, prix, dateVente);
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
