package service.backend.goodsCreate;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import util.ImageUtil;
import util.StringConcatUtil;

public class UploadImageService {

	private static final UploadImageService INSTANCE = new UploadImageService();
	
	private UploadImageService() {
	}
	
	public static UploadImageService getInstance() {
		
		return INSTANCE;
	}
	
	public void upload(Part imagePart, String deployPath, String projectName, String imagesDirectorySymbolicLinkName) throws IOException {
		
		String imagePath = StringConcatUtil.concate(deployPath, File.separator, projectName, File.separator, imagesDirectorySymbolicLinkName, File.separator, imagePart.getSubmittedFileName());
	
		ImageUtil.uploadImage(imagePart.getInputStream(), imagePath);
	}
}
