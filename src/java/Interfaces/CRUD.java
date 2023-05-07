
package Interfaces;

import Modelo.Libros;
import java.util.List;

public interface CRUD {
    public List listar();
    public Libros list(int id);
    public boolean add(Libros lib);
    public boolean edit(Libros lib);
    public boolean eliminar(int id);
    
}
