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
            Map<String, Object> item1 = new HashMap<String, Object>();
            Map<String, Object> item2 = new HashMap<String, Object>();
            Map<String, Object> item3 = new HashMap<String, Object>();
            Map<String, Object> item4 = new HashMap<String, Object>();
            Map<String, Object> item5 = new HashMap<String, Object>();
            Map<String, Object> item6 = new HashMap<String, Object>();
            Map<String, Object> item7 = new HashMap<String, Object>();
            Map<String, Object> item8 = new HashMap<String, Object>();
            Map<String, Object> item9 = new HashMap<String, Object>();
            Map<String, Object> item10 = new HashMap<String, Object>();
            Map<String, Object> item11 = new HashMap<String, Object>();
            Map<String, Object> item12 = new HashMap<String, Object>();
            Map<String, Object> item13 = new HashMap<String, Object>();
            Map<String, Object> item14 = new HashMap<String, Object>();
            Map<String, Object> item15 = new HashMap<String, Object>();
            Map<String, Object> item16 = new HashMap<String, Object>();
            Map<String, Object> item17 = new HashMap<String, Object>();
            Map<String, Object> item18 = new HashMap<String, Object>();
            Map<String, Object> item19 = new HashMap<String, Object>();
            Map<String, Object> item20 = new HashMap<String, Object>();
            Map<String, Object> item21 = new HashMap<String, Object>();

            item1.put("convenio", "801847");
            item2.put("convenio", "797382");
            item3.put("convenio", "793507");
            item4.put("convenio", "793474");
            item5.put("convenio", "792558");
            item6.put("convenio", "792504");
            item7.put("convenio", "792129");
            item8.put("convenio", "791946");
            item9.put("convenio", "790639");
            item10.put("convenio", "785408");
            item11.put("convenio", "782978");
            item12.put("convenio", "782748");
            item13.put("convenio", "782643");
            item14.put("convenio", "782455");
            item15.put("convenio", "779430");
            item16.put("convenio", "779428");
            item17.put("convenio", "776823");
            item18.put("convenio", "776448");
            item19.put("convenio", "776371");
            item20.put("convenio", "774378");
            item21.put("convenio", "774259");

            item1.put("objetoResumido", "O exame Nacional do Ensino Medio  ENEM e um evento de magnitude nacional, de natureza democratica onde os candidatos concorrem em mesmas condicoes, tendo em vista aplicacao padrao de avaliacao, ao acesso as Instituicoes de Ensino Superior - IES. Isto posto presume-se a participacao substantiva de grande parte da sociedade (previsao de mais de sete milhoes de candidatos inscritos nas proximas edicoes e quatrocentas mi");
            item2.put("objetoResumido", "Estudos e pesquisas voltados para acoes de vigilancia, prevencao e controle da Malaria.");
            item3.put("objetoResumido", "Implantacao de 25 (vinte e cinco) nucleos do Programa de  Esporte e Lazer da Cidade - PELC  NUCLEO URBANO no municipio de MANAUS/AM.");
            item4.put("objetoResumido", "FORTALECIMENTO DA DELEGACIA ESPECIALIZADA DE HOMICIDIOS E SEQUESTRO DO ESTADO DO AMAZONAS.");
            item5.put("objetoResumido", "MUNICIPALIZACAO DA PROTECAO E DEFESA DO CONSUMIDOR NO ESTADO DO AMAZONAS");
            item6.put("objetoResumido", "Capacitacao e treinamento dos profissionais da assistencia tecnica e da area da Piscicultura, com enfoque nas Boas Praticas de Manejo na criacao de peixes em viveiros, tanques redes e canais de igarapes.");
            item7.put("objetoResumido", "MANUTENCAO DO PROGRAMA NACIONAL TELESSAUDE BRASIL REDES");
            item8.put("objetoResumido", "Fortalecimento do Conselho Estadual de SeguranAa Alimentar e Nutricional e a CAmara Intersetorial de SeguranAa Alimentar e Nutricional, componentes do SISAN, alAm da elaboraAAo do Plano de SeguranAa Alimentar e Nutricional do AMAZONAS, com ampla participaAAo do Consea Estadual ,bem como a sensibilizaAAo de pelo menos 50% dos municApios do estado para a adesAo ao SISAN.");
            item9.put("objetoResumido", "Modernizacao de Unidades de Apoio a Distribuicao de Produtos da Agricultura Familiar.");
            item10.put("objetoResumido", "Instituir cooperacao tecnico-cientifica entre as convenentes para a execucao do Programa de Excelencia em Pesquisa Basica e Aplicada em Saude - PROEP do Centro de Pesquisa Leonidas e Maria Deane/FIOCRUZ, visando a promocao de projetos de pesquisa estrategicos.");
            item11.put("objetoResumido", "Modernizacao das instalacoes da Fundacao Vila Olimpica Danilo Duarte de Mattos Areosa.");
            item12.put("objetoResumido", "ACOES DE PREVENCAO E REAPARELHAMENTO DOS ORGAOS ENVOLVIDOS NAS POLITICAS DE ENFRENTAMENTO A REDUCAO DA DEMANDA DE CRACK E OUTRAS DROGAS NO ESTADO DO AMAZONAS.");
            item13.put("objetoResumido", "Programas e Projetos de Extensao da UEA para 2013.");
            item14.put("objetoResumido", "Construcao do Centro de Detencao Provisoria Masculino de Manaus - CDP II com capacidade para 571 vagas.");
            item15.put("objetoResumido", "Realizar estudo do impacto da tecnica Xpert MTB/RIF para o diagnostico da tuberculose pulmonar em pacientes residentes no interior do estado do Amazonas.");
            item16.put("objetoResumido", "Estudos e Pesquisas para avaliar a eficacia de esquemas antimalaricos alternativos em associacao a primaquina no tratamento de pacientes com malaria vivax sem complicacoes, provenientes das unidades de diagnostico e tratamento de malaria da atencao basica do municipio de Coari-AM e da FMT-HDV em Manaus-AM.");
            item17.put("objetoResumido", "Estudo e pesquisa para determinar a acuracia dos fatores de mau prognostico para a dengue");
            item18.put("objetoResumido", "Promover a reorientacao da formacao profissional em saude - PRO-SAUDE e PET-SAUDE");
            item19.put("objetoResumido", "Estruturar os Institutos de Criminalistica - IC, de Identificacao - II e Medico Legal - IML pertencentes ao Departamento de Policia Tecnico-Cientifica da Policia Civil do Estado do Amazonas com acoes voltadas ao aprimoramento e estruturacao dos servicos prestados pelos Institutos nas areas de pericia em local de crimes violentos, medicina legal, balistica forense, DNA (criminal), informatica forense, quimica forense");
            item20.put("objetoResumido", "Implementar o Programa de Pesquisa para o Sistema Unico de Saude - SUS: gestao compartilhada de saude (PPSUS) do Departamento de Ciencia e Tecnologia da Secretaria de Ciencia, Tecnologia e Insumos Estrategicos do Ministerio da Saude (DECIT/SCTI/MS), que busca apoiar pesquisas voltadas para problemas prioritarios de saude e o fortalecimento da gestao do SUS, no Estado no Amazonas - Edicao 2012.");
            item21.put("objetoResumido", "Implementacao do CIAB-AD (Centro Interdisciplinar de Atencao Biopsicosocial  Alcool e drogas) para o desenvolvimento das atividades de prevencao, apoio, tratamento, acompanhamento e reabilitacao de profissionais do Sistema de Seguranca Publica do Estado do Amazonas, nos casos do uso abusivo de substancias psicoativas.");

            item1.put("concedente", "MEC/INEP/INST.NAC.DE EST.E PESQ.EDUCAC./DF");
            item2.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item3.put("concedente", "SUBSECRET.DE PLANEJ. ORCAM. E ADMINISTRACAO");
            item4.put("concedente", "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP");
            item5.put("concedente", "SECRETARIA DE DIREITO ECONOMICO - SDE");
            item6.put("concedente", "MINISTERIO DA PESCA E AQUICULTURA");
            item7.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item8.put("concedente", "Secretaria Nacional de Seg. Alim.e Nutricional");
            item9.put("concedente", "PROJETO DE OPERACIONALIZ. DOS PROGRAMAS SESAN");
            item10.put("concedente", "FUNDACAO OSWALDO CRUZ/RJ");
            item11.put("concedente", "CEF/MINISTERIO DO ESPORTE");
            item12.put("concedente", "FUNDO NACIONAL ANTIDROGAS");
            item13.put("concedente", "SECRETARIA DE EDUCACAO SUPERIOR");
            item14.put("concedente", "CEF - DEPARTAMENTO PENITENCIARIO NACIONAL-MJ");
            item15.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item16.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item17.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item18.put("concedente", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE");
            item19.put("concedente", "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP");
            item20.put("concedente", "CNPQ - ADMINSTRACAO CENTRAL");
            item21.put("concedente", "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP");

            item1.put("convenente", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA");
            item2.put("convenente", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO");
            item3.put("convenente", "SECRETARIA DE ESTADO DA JUVENTUDE, ESPORTE E LAZER");
            item4.put("convenente", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA");
            item5.put("convenente", "SECRETARIA DE ESTADO DE JUSTICA, DIREITOS HUMANOS E CIDADANIA");
            item6.put("convenente", "SECRETARIA DE ESTADO DE PRODUCAO RURAL");
            item7.put("convenente", "UNIVERSIDADE DO ESTADO DO AMAZONAS");
            item8.put("convenente", "SECRETARIA DE ESTADO DA ASSISTENCIA SOCIAL E CIDADANIA");
            item9.put("convenente", "SECRETARIA DE ESTADO DE PRODUCAO RURAL");
            item10.put("convenente", "FUNDACAO DE AMPARO A PESQUISA DO ESTADO DO AMAZONAS - FAPEAM");
            item11.put("convenente", "SECRETARIA DE ESTADO DA JUVENTUDE, ESPORTE E LAZER");
            item12.put("convenente", "SECRETARIA DE ESTADO DE JUSTICA, DIREITOS HUMANOS E CIDADANIA");
            item13.put("convenente", "UNIVERSIDADE DO ESTADO DO AMAZONAS");
            item14.put("convenente", "SECRETARIA DE ESTADO DE ADMINISTRACAO PENITENCIARIA - SEAP");
            item15.put("convenente", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO");
            item16.put("convenente", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO");
            item17.put("convenente", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO");
            item18.put("convenente", "UNIVERSIDADE DO ESTADO DO AMAZONAS");
            item19.put("convenente", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA");
            item20.put("convenente", "FUNDACAO DE AMPARO A PESQUISA DO ESTADO DO AMAZONAS - FAPEAM");
            item21.put("convenente", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA");

            item1.put("vlrConvenio", "306.103,37");
            item2.put("vlrConvenio", "475.000,00");
            item3.put("vlrConvenio", "3.480.320,00");
            item4.put("vlrConvenio", "409.800,00");
            item5.put("vlrConvenio", "498.938,94");
            item6.put("vlrConvenio", "198.616,98");
            item7.put("vlrConvenio", "2.432.000,00");
            item8.put("vlrConvenio", "362.820,48");
            item9.put("vlrConvenio", "7.600.000,00");
            item10.put("vlrConvenio", "2.088.000,00");
            item11.put("vlrConvenio", "6.000.000,00");
            item12.put("vlrConvenio", "112.028,77");
            item13.put("vlrConvenio", "353.015,67");
            item14.put("vlrConvenio", "12.709.386,00");
            item15.put("vlrConvenio", "141.611,90");
            item16.put("vlrConvenio", "396.720,00");
            item17.put("vlrConvenio", "121.125,00");
            item18.put("vlrConvenio", "663.894,00");
            item19.put("vlrConvenio", "600.000,00");
            item20.put("vlrConvenio", "2.000.000,00");
            item21.put("vlrConvenio", "813.501,20");

            item1.put("vlrRepassado", "259.063,37");
            item2.put("vlrRepassado", "475.000,00");
            item3.put("vlrRepassado", "2.340.160,00");
            item4.put("vlrRepassado", "409.800,00");
            item5.put("vlrRepassado", "498.938,94");
            item6.put("vlrRepassado", "198.616,98");
            item7.put("vlrRepassado", "2.432.000,00");
            item8.put("vlrRepassado", "362.820,48");
            item9.put("vlrRepassado", "2.851.790,00");
            item10.put("vlrRepassado", "1.518.698,98");
            item11.put("vlrRepassado", "1.524.000,00");
            item12.put("vlrRepassado", "112.028,77");
            item13.put("vlrRepassado", "353.015,67");
            item14.put("vlrRepassado", "10.167.508,80");
            item15.put("vlrRepassado", "141.611,90");
            item16.put("vlrRepassado", "396.720,00");
            item17.put("vlrRepassado", "121.125,00");
            item18.put("vlrRepassado", "107.152,49");
            item19.put("vlrRepassado", "600.000,00");
            item20.put("vlrRepassado", "200.0000,00");
            item21.put("vlrRepassado", "813.501,20");

            item1.put("vlrRestaRepassar", "47.040,00");
            item2.put("vlrRestaRepassar", "0,00");
            item3.put("vlrRestaRepassar", "1.140.160,00");
            item4.put("vlrRestaRepassar", "0,00");
            item5.put("vlrRestaRepassar", "0,00");
            item6.put("vlrRestaRepassar", "0,00");
            item7.put("vlrRestaRepassar", "0,00");
            item8.put("vlrRestaRepassar", "0,00");
            item9.put("vlrRestaRepassar", "4.748.210,00");
            item10.put("vlrRestaRepassar", "569.301,02");
            item11.put("vlrRestaRepassar", "4.476.000,00");
            item12.put("vlrRestaRepassar", "0,00");
            item13.put("vlrRestaRepassar", "0,00");
            item14.put("vlrRestaRepassar", "2.541.877,20");
            item15.put("vlrRestaRepassar", "0,00");
            item16.put("vlrRestaRepassar", "0,00");
            item17.put("vlrRestaRepassar", "0,00");
            item18.put("vlrRestaRepassar", "556.741,51");
            item19.put("vlrRestaRepassar", "0,00");
            item20.put("vlrRestaRepassar", "0,00");
            item21.put("vlrRestaRepassar", "0,00");

            item1.put("vlrContrapartida", "3.092,00");
            item2.put("vlrContrapartida", "25.000,00");
            item3.put("vlrContrapartida", "248.070,00");
            item4.put("vlrContrapartida", "21.569,00");
            item5.put("vlrContrapartida", "51.015,06");
            item6.put("vlrContrapartida", "22.000,02");
            item7.put("vlrContrapartida", "128.000,00");
            item8.put("vlrContrapartida", "19.095,82");
            item9.put("vlrContrapartida", "487.300,00");
            item10.put("vlrContrapartida", "937.920,00");
            item11.put("vlrContrapartida", "1.091.334,29");
            item12.put("vlrContrapartida", "0,00");
            item13.put("vlrContrapartida", "20.405,67");
            item14.put("vlrContrapartida", "9.277.717,12");
            item15.put("vlrContrapartida", "7.453,26");
            item16.put("vlrContrapartida", "20.880,00");
            item17.put("vlrContrapartida", "6.375,00");
            item18.put("vlrContrapartida", "6.706,26");
            item19.put("vlrContrapartida", "6.095,72");
            item20.put("vlrContrapartida", "100.0000,00");
            item21.put("vlrContrapartida", "8.784,00");

            item1.put("dtInicioVigencia", "27/06/2014");
            item2.put("dtInicioVigencia", "26/12/2013");
            item3.put("dtInicioVigencia", "31/12/2013");
            item4.put("dtInicioVigencia", "27/12/2013");
            item5.put("dtInicioVigencia", "30/12/2013");
            item6.put("dtInicioVigencia", "31/12/2013");
            item7.put("dtInicioVigencia", "31/12/2013");
            item8.put("dtInicioVigencia", "23/12/2013");
            item9.put("dtInicioVigencia", "30/12/2013");
            item10.put("dtInicioVigencia", "02/12/2013");
            item11.put("dtInicioVigencia", "03/12/2013");
            item12.put("dtInicioVigencia", "09/10/2013");
            item13.put("dtInicioVigencia", "02/09/2013");
            item14.put("dtInicioVigencia", "16/09/2013");
            item15.put("dtInicioVigencia", "26/12/2012");
            item16.put("dtInicioVigencia", "26/12/2012");
            item17.put("dtInicioVigencia", "12/12/2012");
            item18.put("dtInicioVigencia", "26/12/2012");
            item19.put("dtInicioVigencia", "27/12/2012");
            item20.put("dtInicioVigencia", "23/01/2013");
            item21.put("dtInicioVigencia", "27/12/2012");

            item1.put("dtFimVigencia", "31/12/2016");
            item2.put("dtFimVigencia", "27/10/2017");
            item3.put("dtFimVigencia", "08/06/2016");
            item4.put("dtFimVigencia", "26/08/2016");
            item5.put("dtFimVigencia", "30/04/2016");
            item6.put("dtFimVigencia", "01/07/2016");
            item7.put("dtFimVigencia", "09/06/2016");
            item8.put("dtFimVigencia", "31/01/2017");
            item9.put("dtFimVigencia", "27/06/2016");
            item10.put("dtFimVigencia", "01/12/2017");
            item11.put("dtFimVigencia", "30/06/2016");
            item12.put("dtFimVigencia", "09/10/2016");
            item13.put("dtFimVigencia", "13/05/2016");
            item14.put("dtFimVigencia", "15/09/2016");
            item15.put("dtFimVigencia", "25/11/2016");
            item16.put("dtFimVigencia", "20/06/2016");
            item17.put("dtFimVigencia", "07/05/2016");
            item18.put("dtFimVigencia", "05/05/2016");
            item19.put("dtFimVigencia", "17/06/2016");
            item20.put("dtFimVigencia", "06/10/2016");
            item21.put("dtFimVigencia", "24/04/2016");

            item1.put("imagem", R.mipmap.ic_detective);
            item2.put("imagem", R.mipmap.ic_detective);
            item3.put("imagem", R.mipmap.ic_detective);
            item4.put("imagem", R.mipmap.ic_detective);
            item5.put("imagem", R.mipmap.ic_detective);
            item6.put("imagem", R.mipmap.ic_detective);
            item7.put("imagem", R.mipmap.ic_detective);
            item8.put("imagem", R.mipmap.ic_detective);
            item9.put("imagem", R.mipmap.ic_detective);
            item10.put("imagem", R.mipmap.ic_detective);
            item11.put("imagem", R.mipmap.ic_detective);
            item12.put("imagem", R.mipmap.ic_detective);
            item13.put("imagem", R.mipmap.ic_detective);
            item14.put("imagem", R.mipmap.ic_detective);
            item15.put("imagem", R.mipmap.ic_detective);
            item16.put("imagem", R.mipmap.ic_detective);
            item17.put("imagem", R.mipmap.ic_detective);
            item18.put("imagem", R.mipmap.ic_detective);
            item19.put("imagem", R.mipmap.ic_detective);
            item20.put("imagem", R.mipmap.ic_detective);
            item21.put("imagem", R.mipmap.ic_detective);

            listaConvenios.add(item1);
            listaConvenios.add(item2);
            listaConvenios.add(item3);
            listaConvenios.add(item4);
            listaConvenios.add(item5);
            listaConvenios.add(item6);
            listaConvenios.add(item7);
            listaConvenios.add(item8);
            listaConvenios.add(item9);
            listaConvenios.add(item10);
            listaConvenios.add(item11);
            listaConvenios.add(item12);
            listaConvenios.add(item13);
            listaConvenios.add(item14);
            listaConvenios.add(item15);
            listaConvenios.add(item16);
            listaConvenios.add(item17);
            listaConvenios.add(item18);
            listaConvenios.add(item19);
            listaConvenios.add(item20);
            listaConvenios.add(item21);

        } else if (estado != null && estado.getUnidadeFederativa().compareTo("Rio Grande do Sul") == 0) {
            Map<String, Object> item22 = new HashMap<String, Object>();

            item22.put("convenio", "774076");
            item22.put("objetoResumido", "Contribuir para a diminuicao do desemprego no Estado, oferecendo atendimento integrado ao trabalhador dispensado sem justa causa para que o mesmo usufrua do beneficio do seguro-desemprego e tambem promovendo a qualificacao e re-qualificacao profissional buscando a insercao e reinsercao do trabalhador no mercado de trabalho. Garantir a validade de sua experiencia profissional e conhecimento atraves da certificacao pro");
            item22.put("concedente", "SECRETARIA DE POLITICAS PUBLICAS DE EMPREGO");
            item22.put("convenente", "FUNDACAO GAUCHA DO TRABALHO E ACAO SOCIAL");
            item22.put("vlrConvenio", "38.781.216,00");
            item22.put("vlrRepassado", "28.856.612,99");
            item22.put("vlrRestaRepassar", "9.924.603,01");
            item22.put("vlrContrapartida", "4.309.024,00");
            item22.put("dtInicioVigencia", "08/11/2012");
            item22.put("dtFimVigencia", "12/10/2017");
            item22.put("imagem", R.mipmap.ic_detective);

            listaConvenios.add(item22);
        }

        return listaConvenios;
    }
}
