package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id", columnDefinition = "CHAR(6)", nullable = false)
    @Size(min = 6, max = 6, message = "Customer ID phải đúng 6 ký tự")
    private String customerId;

    @Column(name = "full_name", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Full name không được để trống")
    private String fullName;

    @Column(name = "address", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Address không được để trống")
    private String address;

    @Column(name = "email", columnDefinition = "NVARCHAR(255)", nullable = false)
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @Column(name = "phone", columnDefinition = "CHAR(10)", nullable = false)
    @NotBlank(message = "Phone không được để trống")
    @Pattern(regexp = "^0\\d{9}$", message = "Phone không hợp lệ")
    private String phone;

    @Column(name = "id_number", columnDefinition = "CHAR(12)", nullable = false)
    @NotBlank(message = "ID Number không được để trống")
    @Pattern(regexp = "^\\d{12}$", message = "ID Number phải đúng 12 chữ số")
    private String idNumber;

    private String createdAt;
    private String updatedAt;




}
