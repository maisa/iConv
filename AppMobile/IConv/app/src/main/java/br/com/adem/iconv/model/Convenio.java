package br.com.adem.iconv.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eduardo on 28/03/2016.
 */
public class Convenio implements Serializable {

    private String convenio;
    private String concedente;
    private String convenente;
    private String objeto;
    private String valorTotal;
    private String valorRepassado;
    private String valorRestante;
    private List<PrestacaoContas> prestacaoContasList;

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getConcedente() {
        return concedente;
    }

    public void setConcedente(String concedente) {
        this.concedente = concedente;
    }

    public String getConvenente() {
        return convenente;
    }

    public void setConvenente(String convenente) {
        this.convenente = convenente;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getValorRepassado() {
        return valorRepassado;
    }

    public void setValorRepassado(String valorRepassado) {
        this.valorRepassado = valorRepassado;
    }

    public String getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(String valorRestante) {
        this.valorRestante = valorRestante;
    }

    public List<PrestacaoContas> getPrestacaoContasList() {
        return prestacaoContasList;
    }

    public void setPrestacaoContasList(List<PrestacaoContas> prestacaoContasList) {
        this.prestacaoContasList = prestacaoContasList;
    }
}
