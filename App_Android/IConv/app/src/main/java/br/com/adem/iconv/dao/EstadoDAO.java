package br.com.adem.iconv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.adem.iconv.model.Estado;

/**
 * Created by eduardo on 28/03/2016.
 */
public class EstadoDAO {

    public List<Estado> listar() {
        List<Estado> lista = new ArrayList<>();

        lista.add(new Estado(new Integer("11"),"Rondônia", "RO"));
        lista.add(new Estado(new Integer("12"),"Acre", "AC"));
        lista.add(new Estado(new Integer("13"),"Amazonas", "AM"));
        lista.add(new Estado(new Integer("14"),"Roraima", "RR"));
        lista.add(new Estado(new Integer("15"),"Pará", "PA"));
        lista.add(new Estado(new Integer("16"),"Amapá", "AP"));
        lista.add(new Estado(new Integer("17"),"Tocantins", "TO"));
        lista.add(new Estado(new Integer("21"),"Maranhão", "MA"));
        lista.add(new Estado(new Integer("22"),"Piauí", "PI"));
        lista.add(new Estado(new Integer("23"),"Ceará", "CE"));
        lista.add(new Estado(new Integer("24"),"Rio Grande do Norte", "RN"));
        lista.add(new Estado(new Integer("25"),"Paraíba", "PB"));
        lista.add(new Estado(new Integer("26"),"Pernambuco", "PE"));
        lista.add(new Estado(new Integer("27"),"Alagoas", "AL"));
        lista.add(new Estado(new Integer("28"),"Sergipe", "SE"));
        lista.add(new Estado(new Integer("29"),"Bahia", "BA"));
        lista.add(new Estado(new Integer("31"),"Minas Gerais", "MG"));
        lista.add(new Estado(new Integer("32"),"Espírito Santo", "ES"));
        lista.add(new Estado(new Integer("33"),"Rio de Janeiro", "RJ"));
        lista.add(new Estado(new Integer("35"),"São Paulo", "SP"));
        lista.add(new Estado(new Integer("41"),"Paraná", "PR"));
        lista.add(new Estado(new Integer("42"),"Santa Catarina", "SC"));
        lista.add(new Estado(new Integer("43"),"Rio Grande do Sul", "RS"));
        lista.add(new Estado(new Integer("50"),"Mato Grosso do Sul", "MS"));
        lista.add(new Estado(new Integer("51"),"Mato Grosso", "MT"));
        lista.add(new Estado(new Integer("52"),"Goiás", "GO"));
        lista.add(new Estado(new Integer("53"),"Distrito Federal", "DF"));

        Collections.sort(lista);
        return lista;
    }
}
