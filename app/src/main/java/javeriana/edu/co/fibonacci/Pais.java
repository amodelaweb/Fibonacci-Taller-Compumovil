package javeriana.edu.co.fibonacci;

import java.io.Serializable;

public class Pais implements Serializable{
    private String capital ;
    private String nombre_pais ;
    private String getNombre_pais_int ;
    private String sigla ;

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getGetNombre_pais_int() {
        return getNombre_pais_int;
    }

    public void setGetNombre_pais_int(String getNombre_pais_int) {
        this.getNombre_pais_int = getNombre_pais_int;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais(String capital, String nombre_pais, String getNombre_pais_int, String sigla) {
        this.capital = capital;
        this.nombre_pais = nombre_pais;
        this.getNombre_pais_int = getNombre_pais_int;
        this.sigla = sigla;
    }
}
