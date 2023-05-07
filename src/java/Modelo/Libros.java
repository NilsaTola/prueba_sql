package Modelo;

public class Libros {
   int id;
   String isbn;
   String titulo;
   String Categoria;

    public Libros() {
    }

    public Libros(int id, String isbn, String titulo, String Categoria) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.Categoria = Categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
   
   
}

