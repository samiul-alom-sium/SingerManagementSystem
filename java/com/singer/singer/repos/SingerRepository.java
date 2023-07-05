package com.singer.singer.repos;

import com.singer.singer.entities.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    Page<Singer> findAll(Pageable pageable);
}
