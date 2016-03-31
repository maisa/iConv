package br.com.adem.iconv.model;

/**
 * Created by eduardo on 28/03/2016.
 */
public class Municipio implements Comparable<Municipio> {

    private Integer codigo;
    private String nomeMunicipio;
    private Integer codigoEstado;

    public Municipio(Integer codigo, String nomeMunicipio, Integer codigoEstado) {
        this.codigo = codigo;
        this.nomeMunicipio = nomeMunicipio;
        this.codigoEstado = codigoEstado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    @Override
    public String toString() {
        return getNomeMunicipio();
    }

    @Override
    public int compareTo(Municipio another) {
        return this.nomeMunicipio.compareToIgnoreCase(another.getNomeMunicipio());
    }
}
