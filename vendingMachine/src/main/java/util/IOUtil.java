package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOUtil {

	public static String read(InputStream is) throws IOException {
		
		return read(is, false);
	}
	public static String read(InputStream is, boolean changeLine) throws IOException {
		
		String str = null;
		try(Reader reader = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(reader);){
			
			List<String> strs = new ArrayList<>();
			while((str=br.readLine()) != null) {
				
				strs.add(str);
				
				if(changeLine)
					strs.add("\n");
			}
			
			str = StringConcatUtil.concate(strs.toArray(new String[strs.size()]));
			
		}catch(IOException ex) {
			
			throw ex;
		}
		
		return str;
	}
	public static List<byte[]> readByte(InputStream is) throws IOException{
		
		List<byte[]> buffers = new ArrayList<>();
		try(BufferedInputStream bis = new BufferedInputStream(is);){
			
			byte[] buffer = new byte[100];
			int num = -1;
			while((num=bis.read(buffer)) != -1) {
				
				buffers.add(Arrays.copyOf(buffer, num));
			}
		}catch(IOException ex) {
			
			throw ex;
		}
		
		return buffers;
	}

	
	public void write(OutputStream os, List<String> msgs) throws IOException {
		
		try(Writer writer = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(writer);){
			
			for(String msg : msgs) {
				
				bw.write(msg);
				bw.write("\n");
			}
		}catch(IOException ex) {
			
			throw ex;
		}
	}
	public static void writeByte (OutputStream os, List<byte[]> buffers) throws IOException {
		
		try(BufferedOutputStream bos = new BufferedOutputStream(os);){
			
			for(byte[] buffer : buffers) {
				
				bos.write(buffer);
			}
		} catch (IOException ex) {
			
			throw ex;
		}
	}
}
