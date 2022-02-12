package com.java.training.application.entity;

import com.java.training.application.status.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "song")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "group")
    private String group;

    @Column(name = "album")
    private String album;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "genre_id")
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "song")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "songs")
    private Set<Order> orders = new HashSet<>();

}
