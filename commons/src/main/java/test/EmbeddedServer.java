package test;

import java.io.IOException;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class EmbeddedServer {

    public static void run(int port) throws Exception {

        try (XmlWebApplicationContext xmlApplicationContext = new XmlWebApplicationContext();
                AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext()) {

            applicationContext.setParent(xmlApplicationContext);

            ServletContextHandler handler = configureServletContextHandler(xmlApplicationContext);

            Server server = new Server(port);
            server.setHandler(handler);

            server.start();
            server.join();
        }
    }

    private static ServletContextHandler configureServletContextHandler(WebApplicationContext applicationContext)
            throws IOException {

        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");
        handler.addServlet(new ServletHolder(new CXFServlet()), "/*");
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(applicationContext);
        handler.addEventListener(contextLoaderListener);
        handler.setResourceBase(new ClassPathResource("webapp").getURI().toString());
        return handler;
    }
}
