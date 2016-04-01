package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.adem.iconv.model.Convenio;
import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;

public class ListaConveniosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_convenios);

        Estado estado = (Estado) getIntent().getSerializableExtra("estado");
        Municipio municipio = (Municipio) getIntent().getSerializableExtra("municipio");

        TextView lblEstadoTelaListaConvenios = (TextView) findViewById(R.id.lblEstadoTelaListaConvenios);
        StringBuilder textoLabelEstado = new StringBuilder(lblEstadoTelaListaConvenios.getText());
        textoLabelEstado.append(estado.getUnidadeFederativa());
        lblEstadoTelaListaConvenios.setText(textoLabelEstado.toString());

        TextView lblMunicipioTelaListaConvenios = (TextView) findViewById(R.id.lblMunicipioTelaListaConvenios);
        StringBuilder textoLabelMunicipio = new StringBuilder(lblMunicipioTelaListaConvenios.getText());
        textoLabelMunicipio.append(municipio.getNomeMunicipio());
        lblMunicipioTelaListaConvenios.setText(textoLabelMunicipio.toString());

        /*List<String> convenios = new ArrayList<String>();
        convenios.add("Convenio 1");
        convenios.add("Convenio 2");
        convenios.add("Convenio 3");
        convenios.add("Convenio 4");
        ArrayAdapter aConvenios = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, convenios);
        ListView listaConvenios = (ListView) findViewById(R.id.listViewListaConvenios);
        listaConvenios.setAdapter(aConvenios);*/

        String[] de = {"convenio", "concedente", "convenente", "imagem"};
        int[] para = {R.id.txtConvenioListaConvenios, R.id.txtConcedenteListaConvenios, R.id.txtConvenenteListaConvenios, R.id.imgStatusListaConvenios};
        final SimpleAdapter aConvenios = new SimpleAdapter(this, listarConvenios(), R.layout.layout_lista_convenios, de, para);
        final ListView listaConvenios = (ListView) findViewById(R.id.listViewListaConvenios);
        listaConvenios.setAdapter(aConvenios);

        listaConvenios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> convenioSelecionado = (Map<String, Object>) parent.getItemAtPosition(position);
                Convenio convenio = new Convenio();
                convenio.setConvenio((String) convenioSelecionado.get("convenio"));
                convenio.setConcedente((String) convenioSelecionado.get("concedente"));
                convenio.setConvenente((String) convenioSelecionado.get("convenente"));

                // Chamar a Activity de Avaliacao Passando o Convenio Selecionado.
                Intent avalicaoPassoUmActivity = new Intent(view.getContext(), AvaliacaoPassoUmActivity.class);
                avalicaoPassoUmActivity.putExtra("convenio", convenio);
                startActivity(avalicaoPassoUmActivity);
            }
        });
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
        item2.put("convenente", "Convenente 2");
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
