
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Libros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements CRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Libros l=new Libros();
    
    @Override
    public List listar() {
      ArrayList<Libros>list=new ArrayList<>();
      String sql = "select * from Libros";
      try{
          con = cn.getConnection();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              Libros lib = new Libros();
              lib.setId(rs.getInt("id"));
              lib.setIsbn(rs.getString("Isbn"));
              lib.setTitulo(rs.getString("titulo"));
              lib.setCategoria(rs.getString("categoria"));
              list.add(lib);
          }
      }catch(Exception e){    
      }
      return list;
    }

    @Override
    public Libros list(int id) {
         String sql = "select * from Libros where id="+id;
      try{
          con = cn.getConnection();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              l.setId(rs.getInt("id"));
              l.setIsbn(rs.getString("ISBN"));
              l.setTitulo(rs.getString("Titulo"));
              l.setCategoria(rs.getString("Categoria"));
              
          }
      }catch(Exception e){    
      }
      return l;
    }

    @Override
    public boolean add(Libros libros) {
        String sql="insert into libros(Isbn,Titulo,Categoria)values('"+libros.getIsbn()+"','"+libros.getTitulo()+"','"+libros.getCategoria()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Libros libros) {
        String sql="update libros set ISBN='"+libros.getIsbn()+"',Titulo='"+libros.getTitulo()+"',Categoria='"+libros.getCategoria()+"'where id="+libros.getId();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from Libros where Id="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }
    
}
