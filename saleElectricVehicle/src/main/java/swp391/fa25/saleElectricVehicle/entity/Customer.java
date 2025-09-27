package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String address;

    @Column
    @Email(message = "Email không hợp lệ")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^0\\d{9}$", message = "Phone không hợp lệ")
    private String phone;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{12}$", message = "ID Number phải đúng 12 chữ số")
    private String idNumber;

    @Column(nullable = false)
    private String createdAt;

    @Column
    private String updatedAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Order> orders = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Appointment appointment;
}
