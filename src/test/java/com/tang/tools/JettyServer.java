package com.tang.tools;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettyServer {

	public static void main(String[] args) throws Exception {
		Server server = buildNormalServer(8899, "/");
		server.start();
	}
	public static Server buildNormalServer(int port, String contextPath) {
		Server server = new Server(port);
		WebAppContext webContext = new org.mortbay.jetty.webapp.WebAppContext("WebContent", contextPath);
		webContext.setClassLoader(Thread.currentThread()
				.getContextClassLoader());
		webContext.setMaxFormContentSize(-1);
		server.setHandler(webContext);
		server.setStopAtShutdown(true);
		return server;
	}

}
