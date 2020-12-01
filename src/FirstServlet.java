import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class FirstServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String title="Form parameters";
        String docType="<!DOCTYPE html>\n";
        out.println(docType+"<html>\n"+"<head><title>"+title+"</title></head>\n"+"<body>\n"+
                    "<h1>"+title+"</h1>\n"+"<table border=\"1\">\n"+"<tr>\n"+"<th>Param name</th>"+"<th>Param value(s)</th>\n"+"</tr>\n");
        Enumeration paramNames=request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paramName=(String)paramNames.nextElement();
            out.print("<tr><td>"+paramName+"</td>\n<td>");
            String[] paramValues=request.getParameterValues(paramName);
            if(paramValues.length==1){
                String paramValue=paramValues[0];
                if(paramValue.length()==0)
                out.println("<i>No value</i>");
                else
                out.println(paramValue);
            }
            else{
                out.println("<ul>");
                for(int i=0;i<paramValues.length;i++){
                    out.println("<li>"+paramValues[i]);
                }
                out.println("</ul>");
            }
        }
        out.println("</tr>\n</table>\n</body></html>");            
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}