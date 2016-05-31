package com.chandan.labs.util;

/**
 * Created by kmalhotra on 21-01-2016.
 */
public class MimeTypeMapper {

    public static final String HTML = "text/html";
    public static final String XML = "text/xml";
    public static final String WAV = "audio/wav";
    public static final String GIF = "image/gif";
    public static final String JPEG = "image/jpeg";
    public static final String PNG = "image/png";
    public static final String AVI = "video/avi";
    public static final String MPEG = "video/mpeg";
    public static final String BASE64 = "application/base64";
    public static final String PDF = "application/pdf";
    public static final String ZIP = "application/x-zip-compressed";
    public static final String MP4 = "video/mp4";
    public static final String MP3 = "audio/mpeg";
    public static final String DOC = "application/msword";
    public static final String DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String XLS = "application/vnd.ms-excel";
    public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String PPT = "application/vnd.ms-powerpoint";
    public static final String PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    public static final String XLSM = "application/vnd.ms-excel.sheet.macroEnabled.12";
    public static final String FLV = "video/x-flv";
    public static final String GPMOBILE = "video/3gpp";
    public static final String MOV = "video/quicktime";

    public static String getMime(String file){

        if(file.endsWith(".jpeg")||file.endsWith(".jpg"))
            return JPEG;
        if(file.endsWith(".avi"))
            return AVI;
        if(file.endsWith(".wav"))
            return WAV;
        if(file.endsWith(".xml"))
            return XML;
        if(file.endsWith(".png"))
            return PNG;
        if(file.endsWith(".gif"))
            return GIF;
        if(file.endsWith(".pdf"))
            return PDF;
        if(file.endsWith(".html")||file.endsWith(".htm"))
            return HTML;
        if(file.endsWith(".mpeg"))
            return MPEG;
        if(file.endsWith(".zip"))
            return ZIP;
        if(file.endsWith(".mp4"))
            return MP4;
        if(file.endsWith(".mp3"))
            return MP3;
        if(file.endsWith(".doc"))
            return DOC;
        if(file.endsWith(".docx"))
            return DOCX;
        if(file.endsWith(".xls"))
            return XLS;
        if(file.endsWith(".xlsx"))
            return XLSX;
        if(file.endsWith(".ppt"))
            return PPT;
        if(file.endsWith(".pptx"))
            return PPTX;
        if(file.endsWith(".xlsm"))
            return XLSM;
        if(file.endsWith(".flv"))
            return FLV;
        if(file.endsWith(".3gp"))
            return GPMOBILE;
        if(file.endsWith(".mov"))
            return MOV;

        return null;
    }

}
