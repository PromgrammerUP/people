package org.javachina.people.view;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.javachina.connectionpool.ConnectionPool;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("连接池开始初始化……");
		ConnectionPool.init();
		System.out.println("连接池初始化完毕……");
	}

}
