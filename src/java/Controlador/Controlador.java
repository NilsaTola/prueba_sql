
package Controlador;

import Modelo.Libros;
import ModeloDAO.LibroDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String editar="vistas/edit.jsp";
    Libros l=new Libros();
    LibroDAO dao=new LibroDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;          
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String Isbn=request.getParameter("txtIsbn");
            String Titulo=request.getParameter("txtTitulo");
            String Categoria=request.getParameter("txtCategoria");
            l.setIsbn(Isbn);
            l.setTitulo(Titulo);
            l.setCategoria(Categoria);
            dao.add(l);
            acceso=listar;
            
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idlib",request.getParameter("id"));
            acceso = editar;
            
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int id=Integer.parseInt(request.getParameter("txtid"));
            String Isbn=request.getParameter("txtIsbn");
            String Titulo=request.getParameter("txtTitulo");
            String Categoria=request.getParameter("txtCategoria");
            l.setId(id);
            l.setIsbn(Isbn);
            l.setTitulo(Titulo);
            l.setCategoria(Categoria);
            dao.edit(l);
            acceso=listar;
            
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            l.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
