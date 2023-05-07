<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Libros"%>
<%@page import="java.util.List"%>
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
            <h1>Libros</h1>
            <a href="Controlador?accion=add">Agregar Nuevo</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ISBN</th>
                        <th>TITULO</th>
                        <th>CATEGORIA</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    LibroDAO dao = new LibroDAO();
                    List<Libros> list = dao.listar();
                    Iterator<Libros> iter = list.iterator();
                    Libros lib = null;
                    while (iter.hasNext()) {
                        lib = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= lib.getId()%></td>
                        <td><%= lib.getIsbn()%></td>
                        <td><%= lib.getTitulo()%></td>
                        <td><%= lib.getCategoria()%></td>
                        
                        <td>
                            <a href="Controlador?accion=editar&id=<%= lib.getId()%>">Editar</a>
                            <a href="Controlador?accion=eliminar&id=<%= lib.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
