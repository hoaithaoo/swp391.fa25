package swp391.fa25.saleElectricVehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @Column(name = "feedback_id", columnDefinition = "CHAR(6)", nullable = false)
    @Size(min = 6, max = 6, message = "Feedback ID phải đúng 6 ký tự")
    private String feedbackId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FeedbackStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "create_by")
    @CreatedBy
    private User createBy;

    @Column(name = "resolve_at")
    private LocalDateTime resolveAt;

    @ManyToOne
    @JoinColumn(name = "resolve_by")
    private User resolveBy;

    public enum FeedbackStatus {
        PENDING,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }
}