package com.chandan.labs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.labs.entity.FileUploadTest;

@Repository
public interface FileUploadTestRepo extends JpaRepository<FileUploadTest, Long> {
	

	
}
