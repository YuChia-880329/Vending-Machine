package listener.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ParameterContextListener implements ServletContextListener {

	// context init parameter
	public static final String CTX_PARAM_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME = "imagesDirectorySymbolicLinkName";
	
	// context attribute
	public static final String CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME = "imagesDirectorySymbolicLinkName";
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		
		String imagesDirectorySymbolicLinkName = context.getInitParameter(CTX_PARAM_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
	
		context.setAttribute(CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME, imagesDirectorySymbolicLinkName);
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
