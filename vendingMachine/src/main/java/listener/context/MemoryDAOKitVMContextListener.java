package listener.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class MemoryDAOKitVMContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Thread requireUpdateThread = new Thread(MemoryDAOKitVMDAO.requireUpdateRunnable(), "requireUpdateThread");
		requireUpdateThread.start();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
