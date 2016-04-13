package br.com.adem.iconv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.adem.iconv.MunicipioAuxiliar1;
import br.com.adem.iconv.MunicipioAuxiliar2;
import br.com.adem.iconv.MunicipioAuxiliar3;
import br.com.adem.iconv.MunicipioAuxiliar4;
import br.com.adem.iconv.model.Municipio;

/**
 * Created by eduardo on 28/03/2016.
 */
public class MunicipioDAO {
    
    private List<Municipio> listar() {
        List<Municipio> lista = new ArrayList<Municipio>();
        lista.addAll(MunicipioAuxiliar1.listar());
        lista.addAll(MunicipioAuxiliar2.listar());
        lista.addAll(MunicipioAuxiliar3.listar());
        lista.addAll(MunicipioAuxiliar4.listar());
        Collections.sort(lista);
        return lista;
    }

    public List<Municipio> listarPorEstado(Integer codigoEstado) {
        List<Municipio> lista = new ArrayList<Municipio>();
        for (Municipio municipio : listar()) {
            if (municipio.getCodigoEstado().equals(codigoEstado) == true) {
                lista.add(municipio);
            }
        }
        return lista;
    }
}
