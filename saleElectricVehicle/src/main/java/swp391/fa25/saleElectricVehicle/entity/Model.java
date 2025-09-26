package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name= "models")
public class Model {
    @Id
    @Column(name = "model_id", columnDefinition = "CHAR(6)")
    @Size(min = 6, max = 6, message = "Model ID phải đúng 6 ký tự")
    @Pattern(regexp = "^\\d{6}%")
    private String modelId;

    @Column(name = "model_name", nullable = false)
    @NotBlank(message = "Model name không được để trống")
    private String modelName;

    @Column(name = "model_year", nullable = false)
    @NotNull(message = "Model year không được để trống")
    private Integer modelYear;

    @Column(name = "battery_capacity", columnDefinition = "DECIMAL(5,2)")
    @NotNull(message = "Battery capacity không được để trống")
    private BigDecimal batteryCapacity;

    @Column(name = "range", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal range;

    @Column(name = "power_hp", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal powerHp;

    @Column(name = "torque_nm", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal torqueNm;

    @Column(name = "acceleration", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal acceleration;

    @Column(name = "seating_capacity")
    private Integer seatingCapacity;

    @Column(name = "cc")
    private Integer cc;

    @Column(name = "price", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "description", columnDefinition = "NVARCHAR(1000)")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private String createAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private String updatedAt;








}
