package kz.bitlab.spring_jpa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "application")
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String courseName;
    private String commentary;
    private String phone;
    private boolean handled;

}
