package org.gege.design.delegation.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gege
 * @Description
 * @date 2019/3/21 9:06
 */
public class DispatchServlet extends HttpServlet {

    private Map<String,Handler> handlerMap = new HashMap<String,Handler>();

    {
        handlerMap.put("a",new AHandler());
        handlerMap.put("b",new BHandler());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello word");
        System.out.println(req.getRequestURI());
       //System.out.println(req.getRequestURL());
        String uri = req.getRequestURI();
        if(uri.endsWith("a.html")){
            handlerMap.get("a").controller();
        }else if(uri.endsWith("b.html")){
            handlerMap.get("b").controller();
        }else{
            resp.getOutputStream().print("erro");
            return;
        }
        resp.getOutputStream().print("success");
    }

}
