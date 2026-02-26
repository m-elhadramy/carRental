package app.car_rental.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CarId", nullable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ClientId", nullable = false)
    private Client client;

    @Column(name = "SaleDate", nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "Mileage")
    private Integer mileage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PaymentMethodId", nullable = false)
    private RefPaymentMethod paymentMethod;

    @Column(name = "GPS")
    private boolean gps;

    @Column(name = "ChildSeat")
    private boolean childSeat;

    @Column(name = "Insurance")
    private boolean insurance;

    @Column(name = "Discount", precision = 10, scale = 2)
    private BigDecimal discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StatusId", nullable = false)
    private RefCarStatus status;

    @Column(name = "Note", columnDefinition = "NVARCHAR(MAX)")
    private String note;

    @Column(name = "TotalPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    public Sale() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public LocalDateTime getSaleDate() { return saleDate; }
    public void setSaleDate(LocalDateTime saleDate) { this.saleDate = saleDate; }

    public Integer getMileage() { return mileage; }
    public void setMileage(Integer mileage) { this.mileage = mileage; }

    public RefPaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(RefPaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public boolean isGps() { return gps; }
    public void setGps(boolean gps) { this.gps = gps; }

    public boolean isChildSeat() { return childSeat; }
    public void setChildSeat(boolean childSeat) { this.childSeat = childSeat; }

    public boolean isInsurance() { return insurance; }
    public void setInsurance(boolean insurance) { this.insurance = insurance; }

    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }

    public RefCarStatus getStatus() { return status; }
    public void setStatus(RefCarStatus status) { this.status = status; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
}
