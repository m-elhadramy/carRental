package app.car_rental.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Make", nullable = false, length = 100)
    private String make;

    @Column(name = "Model", nullable = false, length = 100)
    private String model;

    @Column(name = "`Year`", nullable = false)
    private int year;

    @Column(name = "LicensePlate", length = 50)
    private String licensePlate;

    @Column(name = "Color", length = 50)
    private String color;

    @Column(name = "Mileage")
    private Integer mileage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EngineTypeId")
    private RefEngineType engineType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TransmissionId")
    private RefTransmission transmission;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FuelTypeId")
    private RefFuelType fuelType;

    @Column(name = "PricePerDay", precision = 10, scale = 2)
    private BigDecimal pricePerDay;

    @Column(name = "Notes", columnDefinition = "NVARCHAR(MAX)")
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StatusId")
    private RefCarStatus status;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    public Car() {}

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Integer getMileage() { return mileage; }
    public void setMileage(Integer mileage) { this.mileage = mileage; }

    public RefEngineType getEngineType() { return engineType; }
    public void setEngineType(RefEngineType engineType) { this.engineType = engineType; }

    public RefTransmission getTransmission() { return transmission; }
    public void setTransmission(RefTransmission transmission) { this.transmission = transmission; }

    public RefFuelType getFuelType() { return fuelType; }
    public void setFuelType(RefFuelType fuelType) { this.fuelType = fuelType; }

    public BigDecimal getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(BigDecimal pricePerDay) { this.pricePerDay = pricePerDay; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public RefCarStatus getStatus() { return status; }
    public void setStatus(RefCarStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
