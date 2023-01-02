package mvc.controller;
import java.util.ArrayList;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import mvc.bean.Bean;
import mvc.dao.Dao;
public class Controller extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        Integer rollno=Integer.parseInt(req.getParameter("roll"));
        String fname=req.getParameter("fname");
        String lname=req.getParameter("lname");
        String submit=req.getParameter("submit");
        PrintWriter out=res.getWriter();
        Dao dao=new Dao();
        if(submit.equals("Insert"))
        {
           Bean student=new Bean(rollno, fname, lname);
           boolean status= dao.insertData(student);
           RequestDispatcher rd=null;
           if(!status)
           {
             rd=req.getRequestDispatcher("failure.jsp");

           }
           else{
             rd=req.getRequestDispatcher("success.jsp");
           }
           rd.forward(req,res);
        }
        else{

           ArrayList<Bean> students= dao.getData();
           RequestDispatcher dispatcher=null;
           if(students==null)
           {
             dispatcher=req.getRequestDispatcher("failure.jsp");
           }
           else{
             dispatcher=req.getRequestDispatcher("view.jsp");
             req.setAttribute("students",students);
           }
           dispatcher.forward(req,res);
        }



    }
}


