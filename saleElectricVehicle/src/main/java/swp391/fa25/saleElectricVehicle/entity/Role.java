package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "role_id", columnDefinition = "CHAR(6)", nullable = false)
    @Size(min = 6, max = 6, message = "Role ID phải đúng 6 ký tự")
    private String roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;
}
