package com.practice.cachepractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.cachepractice.entity.FileData;

public interface FileRepository extends JpaRepository<FileData, Integer> {
	

}
