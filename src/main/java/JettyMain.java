import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.artefaktur.sample.j4.jersey.SampleResourceConfig;

import de.micromata.genome.util.runtime.LocalSettings;
import de.micromata.genome.util.runtime.LocalSettingsEnv;

public class JettyMain
{

  public static void main(String[] args) throws Exception
  {
    LocalSettingsEnv env = LocalSettingsEnv.get();
    LocalSettings ls = LocalSettings.get();
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    //Create the server
    Server server = new Server(ls.getIntValue("port", 8080));
    server.setHandler(context);

    //Create a WebApp
    ServletHolder servlet = context.addServlet(ServletContainer.class, "/api/*");
    servlet.setInitParameter("javax.ws.rs.Application", SampleResourceConfig.class.getCanonicalName());
    try {
      server.start();
      System.out.println("\nServer started: http://localhost:8080/api/books/books");
      server.join();
    } finally {
      server.destroy();
    }
  }

}
