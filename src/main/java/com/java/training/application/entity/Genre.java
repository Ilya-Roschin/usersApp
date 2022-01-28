package com.java.training.application.entity;

import com.java.training.application.status.GenreEnum;
import lombok.*;
// TODO: 28.01.2022 refactor * import

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre")
    private GenreEnum genre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    private Set<Song> songs;
}
