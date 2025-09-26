package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @Column(name = "store_id", columnDefinition = "CHAR(6)")
    @Size(min = 6, max = 6, message = "Store ID phải có đúng 6 ký tự")
    @Pattern(regexp = "^DL\\d{3}$", message = "Store ID phải bắt đầu bằng 'DL' theo sau là 3 chữ số")
    private String storeId;

    @Column(name = "store_name", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Store name không được để trống")
    private String storeName;

    @Column(name = "address", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Address không được để trống")
    private String address;

    @Column(name = "phone")
    @Pattern(regexp = "^0\\d{9}$", message = "Phone không hợp lệ")
    @NotBlank(message = "Phone không được để trống")
    private String phone;

    @Column(name = "province_name", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Province name không được để trống")
    private String provinceName;

    @Column(name = "owner_name", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Owner name không được để trống")
    private String ownerName;

//    @Column(name = "status", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private StoreStatus status = StoreStatus.ACTIVE;

//    public enum StoreStatus {
//        ACTIVE("active"),
//        INACTIVE("inactive");
//
//    }
    private String contractStartDate;
    private String contractEndDate;
    private String createdAt;
    private String updatedAt;
}
