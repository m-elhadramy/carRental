package app.car_rental.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "depense")
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VoitureId", nullable = false)
    private Car voiture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TypeId", nullable = false)
    private RefDepenseType type;

    @Column(name = "Montant", nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    @Column(name = "DateDepense", nullable = false)
    private LocalDate date;

    @Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    public Depense() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Car getVoiture() { return voiture; }
    public void setVoiture(Car voiture) { this.voiture = voiture; }

    public RefDepenseType getType() { return type; }
    public void setType(RefDepenseType type) { this.type = type; }

    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
