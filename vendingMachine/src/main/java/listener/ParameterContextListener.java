package listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.StringConcatUtil;

public class ParameterContextListener implements ServletContextListener {

	// context init parameter
	public static final String CTX_PARAM_DEPLOY_PATH = "deployPath";
	public static final String CTX_PARAM_PROJECT_NAME = "projectName";
	public static final String CTX_PARAM_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME = "imagesDirectorySymbolicLinkName";
	
	// context attribute
	public static final	String CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_PATH = "imagesDirectorySymbolicLinkPath";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		
		String deployPath = context.getInitParameter(CTX_PARAM_DEPLOY_PATH);
		String projectName = context.getInitParameter(CTX_PARAM_PROJECT_NAME);
		String imagesDirectorySymbolicLinkName = context.getInitParameter(CTX_PARAM_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
		
		String imagesDirectorySymbolicLinkPath = 
				StringConcatUtil.concate(deployPath, File.separator, 
						projectName, File.separator, imagesDirectorySymbolicLinkName);
	
		context.setAttribute(CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_PATH, imagesDirectorySymbolicLinkPath);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
