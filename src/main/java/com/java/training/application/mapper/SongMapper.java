package com.java.training.application.mapper;

import com.java.training.application.dto.SongDto;
import com.java.training.application.entity.Review;
import com.java.training.application.entity.Song;
import com.java.training.application.exception.EntityNotFoundException;
import com.java.training.application.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.java.training.application.Constant.USER_NOT_FOUND_MESSAGE;

@Component
public class SongMapper {

    @Autowired
    private ReviewRepository reviewRepository;

    public SongDto toDto(final Song song) {
        final SongDto songDto = new SongDto();
        songDto.setId(song.getId());
        songDto.setSongName(song.getName());
        songDto.setAlbum(song.getAlbum());
        songDto.setGenreEnum(song.getGenre());
        songDto.setGroup(song.getGroup());
        songDto.setReviewsId(song.getReviews().stream().
                map(Review::getId)
                .collect(Collectors.toList()));
        return songDto;
    }

    public Song toEntity(final SongDto songDto) {
        return Song.builder()
                .id(songDto.getId())
                .name(songDto.getSongName())
                .album(songDto.getAlbum())
                .genre(songDto.getGenreEnum())
                .group(songDto.getGroup())
                .price(songDto.getPrice())
                .reviews(findReviewsById(songDto.getReviewsId()))
                .build();
    }

    private List<Review> findReviewsById(final List<Long> reviewId) {
        List<Review> reviews = new ArrayList<>();
        for (long id : reviewId) {
            reviews.add(reviewRepository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException(USER_NOT_FOUND_MESSAGE)));
        }
        return reviews;
    }


}
