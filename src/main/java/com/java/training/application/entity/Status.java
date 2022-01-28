package com.java.training.application.entity;

import com.java.training.application.status.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private StatusEnum status;
}
