package Maxi.org;

import Maxi.org.models.Book;
import Maxi.org.resolver.BookQueryResolver;
import Maxi.org.servlets.BookServlet;
import Maxi.org.storage.BookInMemoryStorage;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
public class Main {
    public static void main(String[] args) throws Exception {

        Server server= new Server(8082);
        ServletContextHandler context= new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new BookServlet()),"/lib");

        server.start();
        BookInMemoryStorage.getInstance().populateDatabase();
        server.join();
    }
}