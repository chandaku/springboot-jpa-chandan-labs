package com.chandan.labs.util;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.chandan.labs.entity.FileAttachment;
import com.chandan.labs.exception.DataNotFoundException;

@Component
public class FileUploadUtil {
	
	public byte[] getBlob(String query,long id,String blobField,Connection con){
       
		PreparedStatement pstm = null;
        ResultSet rs=null;
        try {
            pstm = con.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob(blobField);
                if (blob == null) {
                    throw new DataNotFoundException("Attachment Not found for Data id:" + id);
                }
                return IOUtils.toByteArray(blob.getBinaryStream());
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Problem with downloading attachment");
        }  finally {
            try {
            	if(rs!=null)rs.close();
                if(pstm!=null)pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Problem with downloading attachment");
            }
        }
        throw new RuntimeException("Problem with downloading attachment");
	}
	
	
	public void validateAttachmentAvaialblity(FileAttachment attachment){
		if(attachment==null){
			throw new DataNotFoundException("No File Exist, Please upload Before you want to download");
		}
	}
	
	
}
