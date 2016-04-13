package br.com.adem.iconv.model;

import java.io.Serializable;

/**
 * Created by eduardo on 28/03/2016.
 */
public class Estado implements Comparable<Estado>, Serializable {
    private Integer codigo;
    private String unidadeFederativa;
    private String sigla;

    public Estado() {

    }

    public Estado(Integer codigo, String unidadeFederativa, String sigla) {
        this.codigo = codigo;
        this.unidadeFederativa = unidadeFederativa;
        this.sigla = sigla;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return getUnidadeFederativa();
    }

    @Override
    public int compareTo(Estado another) {
        return this.getUnidadeFederativa().compareToIgnoreCase(another.getUnidadeFederativa());
    }
}
