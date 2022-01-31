package com.java.training.application.entity;

import com.java.training.application.status.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<User> users;
}
