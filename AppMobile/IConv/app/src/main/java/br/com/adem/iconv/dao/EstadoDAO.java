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

        lista.add(new Estado(new Integer("11"),"Rondônia"));
        lista.add(new Estado(new Integer("12"),"Acre"));
        lista.add(new Estado(new Integer("13"),"Amazonas"));
        lista.add(new Estado(new Integer("14"),"Roraima"));
        lista.add(new Estado(new Integer("15"),"Pará"));
        lista.add(new Estado(new Integer("16"),"Amapá"));
        lista.add(new Estado(new Integer("17"),"Tocantins"));
        lista.add(new Estado(new Integer("21"),"Maranhão"));
        lista.add(new Estado(new Integer("22"),"Piauí"));
        lista.add(new Estado(new Integer("23"),"Ceará"));
        lista.add(new Estado(new Integer("24"),"Rio Grande do Norte"));
        lista.add(new Estado(new Integer("25"),"Paraíba"));
        lista.add(new Estado(new Integer("26"),"Pernambuco"));
        lista.add(new Estado(new Integer("27"),"Alagoas"));
        lista.add(new Estado(new Integer("28"),"Sergipe"));
        lista.add(new Estado(new Integer("29"),"Bahia"));
        lista.add(new Estado(new Integer("31"),"Minas Gerais"));
        lista.add(new Estado(new Integer("32"),"Espírito Santo"));
        lista.add(new Estado(new Integer("33"),"Rio de Janeiro"));
        lista.add(new Estado(new Integer("35"),"São Paulo"));
        lista.add(new Estado(new Integer("41"),"Paraná"));
        lista.add(new Estado(new Integer("42"),"Santa Catarina"));
        lista.add(new Estado(new Integer("43"),"Rio Grande do Sul"));
        lista.add(new Estado(new Integer("50"),"Mato Grosso do Sul"));
        lista.add(new Estado(new Integer("51"),"Mato Grosso"));
        lista.add(new Estado(new Integer("52"),"Goiás"));
        lista.add(new Estado(new Integer("53"),"Distrito Federal"));

        Collections.sort(lista);
        return lista;
    }
}
