package com.java.training.application.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "song")
@Getter
@Setter
@RequiredArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String songName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "album_name")
    private String albumName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "genre_id", nullable = false) // TODO: 20.01.2022 mb remove
    private Genre genre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "song") // TODO: 20.01.2022 cascade type, mappedBy,
    private Set<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "song")
    private Set<Order> orders;


}
