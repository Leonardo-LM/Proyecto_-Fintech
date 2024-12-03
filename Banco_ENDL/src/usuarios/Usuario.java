package usuarios;

import operaciones_Bancarias.Banco;
import utils.Rol;

import java.io.Serializable;

public class Usuario implements Serializable {
    public String id;
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String RFC;
    private String CURP;
    public String email;
    public Rol rol;

    public Usuario(String id,String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.RFC = RFC;
        this.CURP = CURP;
        this.email = email;
        this.rol = rol;
    }

    public Usuario() {}

    public String mostrarInformacion(){
        String nombreCompleto = this.nombre +" "+ this.apellidoPaterno+" "+this.apellidoMaterno;
        return String.format("" +
                        "\nId: %s, Nombre completo: %s,CURP:%S, RFC: %s"
                , this.id, nombreCompleto,this.CURP, this.RFC
        );
    }

    //-------------------Getters y Setters---------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", RFC='" + RFC + '\'' +
                ", CURP='" + CURP + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                '}';
    }
}
