

<%@page import="Modelo.Libros"%>
<%@page import="ModeloDAO.LibroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
        <link rel="stylesheet" href="estilos.css">
    </head>
    <body>
        <div>
            <%
            LibroDAO dao=new LibroDAO();
            int id=Integer.parseInt((String)request.getAttribute("idlib"));
            Libros l=(Libros)dao.list(id);
            %>
        <h1>Editar Libros</h1>
        <form action="Controlador">         
            Isbn: <input type="text" name="txtIsbn" value="<%= l.getIsbn()%>"><br><br>
            Titulo: <input type="text" name="txtTitulo" value="<%= l.getTitulo()%>"><br><br>
            Categoria: <input type="text" name="txtCategoria" value="<%= l.getCategoria()%>"><br><br>
            <input type="hidden" name="txtid" value="<%= l.getId()%>"><br><br>
            <input type="submit" name="accion" value="Actualizar"><br>
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
        </div>
    </body>
</html>
