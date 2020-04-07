package wilsonR.controlador;

import wilsonR.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Persona p = new Persona();
    
    public String maxId(){
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select max(id) from persona");
            rs = ps.executeQuery();
            while (rs.next()) {
                return (Integer.valueOf(rs.getString(1))+1)+"";
            }
        } catch (Exception e) {
        }
        return "0";
    }
    public List<Persona> listar() {
        List<Persona> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from persona");
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSexo(rs.getString(3));
                p.setEdad(rs.getString(4));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Persona per) {  
        int r=0;
        String sql="insert into persona(Nombres,Sexo,Edad)values(?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,per.getNom());
            ps.setString(2,per.getSexo());
            ps.setString(3,per.getEdad());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
        return r;
    }
    public int Actualizar(Persona per) {  
        int r=0;
        String sql="update persona set Nombres=?,Sexo=?,Edad=? where Id=?";        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,per.getNom());
            ps.setString(2,per.getSexo());
            ps.setString(3,per.getEdad());
            ps.setInt(4,per.getId());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
    public int Delete(int id){
        int r=0;
        String sql="delete from persona where Id="+id;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
