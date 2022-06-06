package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
