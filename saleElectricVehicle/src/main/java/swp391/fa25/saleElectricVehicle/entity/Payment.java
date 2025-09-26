package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payment")

public class Payment {
    @Id
    @Column(name = "payment_id", columnDefinition = "CHAR(6)", nullable = false)
    @Size(min = 6, max = 6, message = "Payment ID phải đúng 6 ký tự")
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @Column(name = "remain_price", columnDefinition = "DECIMAL(12,2)")
    private BigDecimal remainPrice;

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED
    }

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "payment_method", columnDefinition = "NVARCHAR(50)", nullable = false)
    @NotBlank(message = "Payment method không được để trống")
    private String paymentMethod;

    @Column(name = "amount", columnDefinition = "DECIMAL(12,2)", nullable = false)
    @NotNull(message = "Amount không được để trống")
    private BigDecimal amount;

    private String createdAt;
    private String updatedAt;

    //Dùng để truy vấn tất cả Transaction (nếu cần)
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();











}
