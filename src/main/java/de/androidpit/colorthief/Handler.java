
package de.androidpit.colorthief;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
 
import java.io.IOException;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.imageio.ImageIO;
import java.net.URL;

public class Handler extends AbstractHandler {
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/plain;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        String url = request.getParameter("url");

        int[] rgb = ColorThief.getColor(ImageIO.read(new URL(url)));

        String hex = String.format("#%02x%02x%02x", rgb[0], rgb[1], rgb[2]);

        response.getWriter().println(hex);
    }
 
    public static void main(String[] args) throws Exception {
        Server server = new Server(8251);
        server.setHandler(new Handler());
 
        server.start();
        server.join();
    }
}
