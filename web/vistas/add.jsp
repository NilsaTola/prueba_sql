
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
        <h1>Agregar Libros</h1>
        <form action="Controlador">         
            Isbn: <input type="text" name="txtIsbn"><br><br>
            Titulo: <input type="text" name="txtTitulo"><br><br>
            Categoria: <input type="text" name="txtCategoria"><br><br>
            <input type="submit" name="accion" value="AGREGAR"><br>
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </body>
</html>
