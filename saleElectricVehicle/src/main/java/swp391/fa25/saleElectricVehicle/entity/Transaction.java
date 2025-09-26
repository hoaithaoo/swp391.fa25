package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")

public class Transaction {
    @Id
    @Column(name = "transaction_id", columnDefinition = "CHAR(6)", nullable = false)
    @Size(min = 6, max = 6, message = "Transaction ID phải đúng 6 ký tự")
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "amount", columnDefinition = "DECIMAL(12,2)", nullable = false)
    @NotNull(message = "Amount không được để trống")
    private BigDecimal amount;

    @Column(name = "transaction_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime transactionTime;

    public enum TransactionStatus {
        PENDING,
        COMPLETED,
        FAILED
    }

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "gateway", columnDefinition = "NVARCHAR(50)", nullable = false)
    @NotBlank(message = "Gateway không được để trống")
    private String gateway;

    @Column(name = "transaction_ref", columnDefinition = "NVARCHAR(255)")
    private String transactionRef;

    @Column(name = "payer_infor", columnDefinition = "NVARCHAR(255)")
    private String payerInfor;

    @Column(name = "note", columnDefinition = "NVARCHAR(1000)")
    private String note;






}
