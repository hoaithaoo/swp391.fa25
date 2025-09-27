package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name= "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelId;

    @Column(nullable = false)
    private String modelName;

    @Column(nullable = false)
    private int modelYear;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private BigDecimal batteryCapacity;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private BigDecimal range;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private BigDecimal powerHp;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private BigDecimal torqueNm;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private BigDecimal acceleration;

    @Column(nullable = false)
    private int seatingCapacity;

    @Column(nullable = false)
    private String color;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String bodyType;

    @Column(columnDefinition = "NVARCHAR(1000)")
    private String description;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private StoreStock storeStocks;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private Promotion promotion;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private Appointment appointment;
}
