package com.chandan.labs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.labs.entity.FileAttachment;

@Repository
public interface FileAttachmentRepo extends JpaRepository<FileAttachment, Long> {
	

	
}
