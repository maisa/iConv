package br.com.adem.iconv.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by eduardo on 28/03/2016.
 */
public class Pagamento implements Serializable {
    private String data;
    private String valor;
    private String fornecedor;
    private String cnpjFornecedor;
    private String nrNotaFiscal;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getNrNotaFiscal() {
        return nrNotaFiscal;
    }

    public void setNrNotaFiscal(String nrNotaFiscal) {
        this.nrNotaFiscal = nrNotaFiscal;
    }
}
