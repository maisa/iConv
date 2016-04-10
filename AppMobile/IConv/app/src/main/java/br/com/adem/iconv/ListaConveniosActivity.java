package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    private Estado estadoSelecionado;
    private Municipio municipioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_convenios);

        TextView lblEstadoTelaListaConvenios = (TextView) findViewById(R.id.lblEstadoTelaListaConvenios);
        TextView lblMunicipioTelaListaConvenios = (TextView) findViewById(R.id.lblMunicipioTelaListaConvenios);

        estadoSelecionado = (Estado) getIntent().getSerializableExtra("estado");
        municipioSelecionado = (Municipio) getIntent().getSerializableExtra("municipio");

        if (estadoSelecionado != null) {
            StringBuilder textoLabelEstado = new StringBuilder(lblEstadoTelaListaConvenios.getText());
            textoLabelEstado.append(estadoSelecionado.getUnidadeFederativa());
            lblEstadoTelaListaConvenios.setText(textoLabelEstado.toString());
            lblEstadoTelaListaConvenios.setVisibility(View.VISIBLE);
        } else {
            lblEstadoTelaListaConvenios.setVisibility(View.INVISIBLE);
        }
        if (municipioSelecionado != null) {
            StringBuilder textoLabelMunicipio = new StringBuilder(lblMunicipioTelaListaConvenios.getText());
            textoLabelMunicipio.append(municipioSelecionado.getNomeMunicipio());
            lblMunicipioTelaListaConvenios.setText(textoLabelMunicipio.toString());
            lblMunicipioTelaListaConvenios.setVisibility(View.VISIBLE);
        } else {
            lblMunicipioTelaListaConvenios.setVisibility(View.INVISIBLE);
        }

        List<? extends Map<String, ?>> listaConvenios = listarConvenios(estadoSelecionado, municipioSelecionado);
        if (listaConvenios.isEmpty() == true) {
            if (estadoSelecionado != null && municipioSelecionado == null) {
                Toast.makeText(this, "Nenhum convênio foi encontrado para o Estado " + estadoSelecionado.getUnidadeFederativa() + ".", Toast.LENGTH_SHORT).show();
            } else if (estadoSelecionado != null && municipioSelecionado != null) {
                Toast.makeText(this, "Nenhum convênio foi encontrado para o Município " + municipioSelecionado.getNomeMunicipio() + ".", Toast.LENGTH_SHORT).show();
            }
        }
        String[] de = {"convenio", "concedente", "convenente", "vlrConvenio", "vlrRepassado", "vlrRestaRepassar", "objetoResumido", "imagem"};
        int[] para = {R.id.txtConvenioListaConvenios, R.id.txtConcedenteListaConvenios, R.id.txtConvenenteListaConvenios,
                    R.id.txtValorTotalListaConvenios, R.id.txtValorRepassadoListaConvenios, R.id.txtValorARepassarListaConvenios,
                    R.id.txtObjetoListaConvenios, R.id.imgStatusListaConvenios};
        final SimpleAdapter aConvenios = new SimpleAdapter(this, listaConvenios, R.layout.layout_lista_convenios, de, para);
        final ListView listViewConvenios = (ListView) findViewById(R.id.listViewListaConvenios);
        listViewConvenios.setAdapter(aConvenios);

        listViewConvenios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> convenioSelecionado = (Map<String, Object>) parent.getItemAtPosition(position);
                Convenio convenio = new Convenio();
                convenio.setConvenio((String) convenioSelecionado.get("convenio"));
                convenio.setConcedente((String) convenioSelecionado.get("concedente"));
                convenio.setConvenente((String) convenioSelecionado.get("convenente"));
                convenio.setValorTotal((String) convenioSelecionado.get("vlrConvenio"));
                convenio.setValorRepassado((String) convenioSelecionado.get("vlrRepassado"));
                convenio.setValorRestante((String) convenioSelecionado.get("vlrRestaRepassar"));
                convenio.setObjeto((String) convenioSelecionado.get("objetoResumido"));

                // Chamar a Activity de Avaliacao Passando o Convenio Selecionado.
                Intent avalicaoPassoUmActivity = new Intent(view.getContext(), AvaliacaoPassoUmActivity.class);
                avalicaoPassoUmActivity.putExtra("convenio", convenio);
                startActivity(avalicaoPassoUmActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences: {
                Intent configuracaoActivity = new Intent();
                //intent.setClassName(this, SettingsActivity.class.getName());
                configuracaoActivity.setClassName(this, ConfiguracaoActivity.class.getName());
                configuracaoActivity.putExtra("estado", estadoSelecionado);
                configuracaoActivity.putExtra("municipio", municipioSelecionado);
                startActivity(configuracaoActivity);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Map<String, Object>> listarConvenios(Estado estado, Municipio municipio) {
        List<Map<String, Object>> listaConvenios = new ArrayList<Map<String, Object>>();

        if (estado != null && estado.getUnidadeFederativa().compareTo("Amazonas") == 0) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("convenio", "826401");
            item.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item.put("convenente", "FUNDACAO HOSPITALAR DE HEMATOLOGIA E HEMOTERAPIA DO AMAZONAS");
            item.put("vlrConvenio", "5.448.085,00");
            item.put("vlrRepassado", "0,00");
            item.put("vlrRestaRepassar", "5.448.085,00");
            item.put("objetoResumido", "AQUISICAO DE EQUIPAMENTO E MATERIAL PERMANENTE PARA UNIDADE DE HEMATOLOGIA E HEMOTERAPIA");
            item.put("imagem", R.mipmap.ic_launcher);
            listaConvenios.add(item);

            Map<String, Object> item2 = new HashMap<>();
            item2.put("convenio", "826406");
            item2.put("concedente", "CEF-PROGRAMAS DO MINISTERIO DA SAUDE");
            item2.put("convenente", "FUNDO MUNICIPAL DE SAUDE DE MANAUS");
            item2.put("vlrConvenio", "449.999,60");
            item2.put("vlrRepassado", "0,00");
            item2.put("vlrRestaRepassar", "449.999,60");
            item2.put("objetoResumido", "AMPLIACAO DE UNIDADE DE ATENCAO ESPECIALIZADA EM SAUDE");
            item2.put("imagem", R.mipmap.ic_launcher);
            listaConvenios.add(item2);

            Map<String, Object> item3 = new HashMap<>();
            item3.put("convenio", "774037");
            item3.put("concedente", "SECRETARIA NACIONAL DE SEGURANCA PUBLICA");
            item3.put("convenente", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA");
            item3.put("vlrConvenio", "1.000.000,00");
            item3.put("vlrRepassado", "1.000.000,00");
            item3.put("vlrRestaRepassar", "0,00");
            item3.put("objetoResumido", "Aquisicao de veiculos para o Comando de Policiamento Metropolitano e as Companhias Interativas Comunitarias (CICOMS).");
            item3.put("imagem", R.mipmap.ic_launcher);
            listaConvenios.add(item3);

            Map<String, Object> item4 = new HashMap<>();
            item4.put("convenio", "821530");
            item4.put("concedente", "FUNDO NACIONAL PARA A CRIANCA E O ADOLESCENTE");
            item4.put("convenente", "SECRETARIA DE ESTADO DE JUSTICA, DIREITOS HUMANOS E CIDADANIA");
            item4.put("vlrConvenio", "172.167,98");
            item4.put("vlrRepassado", "172.167,98");
            item4.put("vlrRestaRepassar", "0,00");
            item4.put("objetoResumido", "Promover a formacao permanente dos profissionais que atuam no atendimento a adolescentes que cumprem medidas socioeducativas, conforme as orientacoes do SINASE.");
            item4.put("imagem", R.mipmap.ic_launcher);
            listaConvenios.add(item4);

            Map<String, Object> item5 = new HashMap<>();
            item5.put("convenio", "743507");
            item5.put("concedente", "SECRETARIA ESP. DE POLITICAS PARA AS MULHERES");
            item5.put("convenente", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA");
            item5.put("vlrConvenio", "240.284,70");
            item5.put("vlrRepassado", "240.284,70");
            item5.put("vlrRestaRepassar", "0,00");
            item5.put("objetoResumido", "IMPLANTACAO DO NUCLEO DE ATENDIMENTO AS MULHERES VITIMAS DE VIOLENCIA SEXUAL, DOMESTICA E FAMILIAR E OUTRAS VIOLENCIAS NO IML.");
            item5.put("imagem", R.mipmap.ic_launcher);
            listaConvenios.add(item5);

            Map<String, Object> item6 = new HashMap<>();
            item6.put("convenio", "743168");
            item6.put("concedente", "COORDENACAO-GERAL DE CONVENIOS - CGCV");
            item6.put("convenente", "EMPRESA ESTADUAL DE TURISMO - AMAZONASTUR");
            item6.put("vlrConvenio", "275.967,17");
            item6.put("vlrRepassado", "275.967,17");
            item6.put("vlrRestaRepassar", "0,00");
            item6.put("objetoResumido", "PROMOCAO DO DESTINO AMAZONAS - VERBA DESCENTRALIZADA 2010 - AMAZONAS");
            item6.put("imagem", R.mipmap.ic_launcher);
            listaConvenios.add(item6);
        }

        return listaConvenios;
    }
}
