package br.com.adem.iconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaConveniosActivity extends AppCompatActivity {

    private TextView lblEstadoTelaListaConvenios;
    private TextView lblMunicipioTelaListaConvenios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_convenios);

        String estado = getIntent().getStringExtra("estado");
        String municipio = getIntent().getStringExtra("municipio");

        lblEstadoTelaListaConvenios = (TextView) findViewById(R.id.lblEstadoTelaListaConvenios);
        StringBuilder textoLabelEstado = new StringBuilder(lblEstadoTelaListaConvenios.getText());
        textoLabelEstado.append(estado);
        lblEstadoTelaListaConvenios.setText(textoLabelEstado.toString());

        lblMunicipioTelaListaConvenios = (TextView) findViewById(R.id.lblMunicipioTelaListaConvenios);
        StringBuilder textoLabelMunicipio = new StringBuilder(lblMunicipioTelaListaConvenios.getText());
        textoLabelMunicipio.append(municipio);
        lblMunicipioTelaListaConvenios.setText(textoLabelMunicipio.toString());

        /*List<String> convenios = new ArrayList<String>();
        convenios.add("Convenio 1");
        convenios.add("Convenio 2");
        convenios.add("Convenio 3");
        convenios.add("Convenio 4");
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, convenios);
        ListView listaConvenios = (ListView) findViewById(R.id.listViewListaConvenios);
        listaConvenios.setAdapter(adapter);*/

        String[] de = {"convenio", "concedente", "convenente", "imagem"};
        int[] para = {R.id.txtConvenioListaConvenios, R.id.txtConcedenteListaConvenios, R.id.txtConvenenteListaConvenios, R.id.imgStatusListaConvenios};
        SimpleAdapter adapter = new SimpleAdapter(this, listarConvenios(), R.layout.layout_lista_convenios, de, para);
        ListView listaConvenios = (ListView) findViewById(R.id.listViewListaConvenios);
        listaConvenios.setAdapter(adapter);
    }

    private List<Map<String, Object>> listarConvenios() {
        List<Map<String, Object>> listaConvenios = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("convenio", "Convenio 1");
        item.put("concedente", "Concedente 1");
        item.put("convenente", "Convenente 1");
        item.put("imagem", R.mipmap.ic_launcher);
        listaConvenios.add(item);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("convenio", "Convenio 2");
        item2.put("concedente", "Concedente 2");
        item2.put("convenente", "Convenente 3");
        item2.put("imagem", R.mipmap.ic_launcher);
        listaConvenios.add(item2);

        Map<String, Object> item3 = new HashMap<>();
        item3.put("convenio", "Convenio 3");
        item3.put("concedente", "Concedente 3");
        item3.put("convenente", "Convenente 3");
        item3.put("imagem", R.mipmap.ic_launcher);
        listaConvenios.add(item3);

        Map<String, Object> item4 = new HashMap<>();
        item4.put("convenio", "Convenio 4");
        item4.put("concedente", "Concedente 4");
        item4.put("convenente", "Convenente 4");
        item4.put("imagem", R.mipmap.ic_launcher);
        listaConvenios.add(item4);

        return listaConvenios;
    }
}
