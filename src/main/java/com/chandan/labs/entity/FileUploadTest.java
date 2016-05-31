package com.chandan.labs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "user_survey", name = "FILE_UPLOAD_TEST")
public class FileUploadTest {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	
	@Column(name = "DATA")
	private String data;
	
	@Column(name = "FILE_NAME")
    private String fileName;

    @JsonIgnore
	@JoinColumn(name = "FILE_ID")
	@OneToOne(fetch=FetchType.LAZY,targetEntity=FileAttachment.class,orphanRemoval=true)
	private FileAttachment fileId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileAttachment getFileId() {
		return fileId;
	}

	public void setFileId(FileAttachment fileId) {
		this.fileId = fileId;
	}
    
    
}
