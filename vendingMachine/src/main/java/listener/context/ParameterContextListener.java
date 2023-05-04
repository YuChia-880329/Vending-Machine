package listener.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ParameterContextListener implements ServletContextListener {

	// context init parameter
	public static final String CTX_PARAM_DEPLOY_PATH = "deployPath";
	public static final String CTX_PARAM_IMAGES_DIRECTORY_NAME = "imagesDirectoryName";
	
	// context attribute
	public static final String CTX_ATTR_DEPLOY_PATH = "deployPath";
	public static final String CTX_ATTR_IMAGES_DIRECTORY_NAME = "imagesDirectoryName";
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		
		String deployPath = context.getInitParameter(CTX_PARAM_DEPLOY_PATH);
		String imagesDirectoryName = context.getInitParameter(CTX_PARAM_IMAGES_DIRECTORY_NAME);
	
		
		context.setAttribute(CTX_ATTR_DEPLOY_PATH, deployPath);
		context.setAttribute(CTX_ATTR_IMAGES_DIRECTORY_NAME, imagesDirectoryName);
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
