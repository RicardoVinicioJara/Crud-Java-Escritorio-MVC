
package wilsonR.modelo;

public class Persona {
    int id;
    String nom;
    String sexo;
    String edad;

    public Persona() {
    }

    public Persona(int id, String nom, String sexo, String edad) {
        this.id = id;
        this.nom = nom;
        this.sexo = sexo;
        this.edad = edad;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}

   