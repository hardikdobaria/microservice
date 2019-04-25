package cdl.wh.warehousezuul;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SimpleFilter extends ZuulFilter {

	 private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
	   @Override
	   public String filterType() {
		   log.info(String.format("request --- filterType"));
	       return "pre";
	   }
	   @Override
	   public int filterOrder() {
		   log.info(String.format("request --- filterOrder"));
	       return 1;
	   }
	   @Override
	   public boolean shouldFilter() {
		   log.info(String.format("request --- shouldFilter"));
	       return true;
	   }
	   @Override
	   public Object run() {
	       RequestContext ctx = RequestContext.getCurrentContext();
	       HttpServletRequest request = ctx.getRequest();
	       
	       log.info(String.format("%s request --- to %s", request.getMethod(), request.getRequestURL().toString()));
	       
	       Enumeration<String> headerNames = request.getHeaderNames();
	       while(headerNames.hasMoreElements()) {
	         String headerName = headerNames.nextElement();
	         System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
	       }
	       
	       return null;
	   }
	
}
