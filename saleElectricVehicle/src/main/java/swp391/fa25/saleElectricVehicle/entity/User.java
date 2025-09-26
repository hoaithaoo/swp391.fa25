package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id", columnDefinition = "CHAR(6)", nullable = false)
    @Size(min = 6, max = 6, message = "User ID phải đúng 6 ký tự")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store storeId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role roleId;

    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password không được để trống")
    @Size(min = 8, message = "Password phải có ít nhất 8 ký tự")
    private String password;

    @Column(name = "phone")
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải có 10 chữ số")
    private String phone;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;
}