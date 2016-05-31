package com.chandan.labs.dto.common;

/**
 * Created by kmalhotra on 05-02-2016.
 */
public class DownloadAttachmentDTO {

    private String mimeType;

    private byte[] bytes;

    public DownloadAttachmentDTO(String mimeType, byte[] bytes) {
        this.mimeType = mimeType;
        this.bytes = bytes;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
