package com.singer.singer.services;

import com.singer.singer.entities.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    Page<Singer> findAllByPage(Pageable pageable);

}