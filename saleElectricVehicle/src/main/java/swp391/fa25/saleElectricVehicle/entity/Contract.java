package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contracts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @Column(name = "contract_id", columnDefinition = "CHAR(10)", nullable = false)
    @Size(min = 10, max = 10, message = "Contract ID phải đúng 10 ký tự (CT2025-001)")
    private String contractId;

    @Column(name = "contract_date", columnDefinition = "DATE", nullable = false)
    @NotNull(message = "Contract date không được để trống")
    private LocalDate contractDate;

    @Column(name = "contract_file_url", nullable = false)
    @NotBlank(message = "Contract file URL không được để trống")
    private String contractFileUrl;

    public enum ContractStatus {
        DRAFT, PENDING, COMPLETED, CANCELLED, EXPIRED
    }

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    @Column(name = "deposit_price", columnDefinition = "DECIMAL(12,2)")
    @NotNull(message = "Deposit price không được để trống")
    private BigDecimal depositPrice;

    @Column(name = "total_payment", columnDefinition = "DECIMAL(12,2)")
    @NotNull(message = "Total payment không được để trống")
    private BigDecimal totalPayment;

    @Column(name = "remain_price", columnDefinition = "DECIMAL(12,2)")
    private BigDecimal remainPrice;

    @Column(name = "terms", columnDefinition = "NVARCHAR(1000)")
    private String terms;

    @Column(name = "uploaded_by", columnDefinition = "NVARCHAR(255)")
    @NotBlank(message = "Uploaded by không được để trống")
    private String uploadedBy;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false, updatable = false)
    private String createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private String updatedAt;

    //Dùng để truy vấn tất cả Payment (nếu cần)
//    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Payment> payments = new ArrayList<>();









}
