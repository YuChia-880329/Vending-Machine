package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.Part;

public class ImageUtil {

	public static void uploadImage(Part imagePart, InputStream is, String directoryPath) throws IOException {
		
		try(OutputStream os = new FileOutputStream(directoryPath);){
			
			List<byte[]> buffers = IOUtil.readByte(is);
			IOUtil.writeByte(os, buffers);
		}  catch (IOException ex) {
			
			throw ex;
		}
	}
}
