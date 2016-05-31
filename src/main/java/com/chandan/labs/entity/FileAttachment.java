package com.chandan.labs.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "user_survey", name = "COMMON_FILE_ATTACH_IN")
public class FileAttachment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	
	@JsonIgnore
	@Column(name = "FILE_ATTACHMENT")
	private Blob fileAttachment;
	
	@JsonIgnore
	@Column(name = "FILE_MIME_TYPE")
	private String fileMimeType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Blob getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(Blob fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	public String getFileMimeType() {
		return fileMimeType;
	}

	public void setFileMimeType(String fileMimeType) {
		this.fileMimeType = fileMimeType;
	}
	
	

}
