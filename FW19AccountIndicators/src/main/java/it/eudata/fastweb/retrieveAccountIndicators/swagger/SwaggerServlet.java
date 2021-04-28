package it.eudata.fastweb.retrieveAccountIndicators.swagger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * Servlet implementation class SwaggerServlet
 */
public class SwaggerServlet extends HttpServlet {
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);

	        BeanConfig beanConfig = new BeanConfig();
	        beanConfig.setVersion("1.0.2");
	        beanConfig.setTitle("Fastweb_2019");
	        beanConfig.setSchemes(new String[]{"http"});
//	        beanConfig.setHost("localhost:8002");
	        beanConfig.setBasePath("/webapi");
	        beanConfig.setResourcePackage("it.eudata.fastweb.retrieveAccountIndicators.resources");
	        beanConfig.setScan(true);
	    }

}
