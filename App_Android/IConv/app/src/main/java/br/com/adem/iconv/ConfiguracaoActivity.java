package br.com.adem.iconv;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.adem.iconv.dao.EstadoDAO;
import br.com.adem.iconv.dao.MunicipioDAO;
import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;

public class ConfiguracaoActivity extends AppCompatActivity {

    private static final EstadoDAO estadoDAO = new EstadoDAO();
    private ArrayAdapter<Estado> aEstados;
    private Spinner spEstado;
    private TextView lblEstado;

    private static final MunicipioDAO municipioDAO = new MunicipioDAO();
    private ArrayAdapter<Municipio> aMunicipios;
    private Spinner spMunicipios;
    private TextView lblMunicipio;

    private RadioButton opEnteEstadualTelaConfiguracao;
    private RadioButton opEnteMunicipalTelaConfiguracao;

    private Estado estadoSelecionado;

    private Button btOkConfiguracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        lblEstado = (TextView) findViewById(R.id.lblEstadoTelaConfiguracao);
        lblMunicipio = (TextView) findViewById(R.id.lblMunicipioTelaConfiguracao);
        spEstado = (Spinner) findViewById(R.id.spEstadosTelaConfiguracao);
        spMunicipios = (Spinner) findViewById(R.id.spMunicipiosTelaConfiguracao);
        opEnteEstadualTelaConfiguracao = (RadioButton) findViewById(R.id.opEnteEstadualTelaConfiguracao);
        opEnteMunicipalTelaConfiguracao = (RadioButton) findViewById(R.id.opEnteMunicipalTelaConfiguracao);

        // Modelo do Spinner Estado.
        aEstados = new ArrayAdapter<Estado>(this, android.R.layout.simple_spinner_item, estadoDAO.listar());

        // Captura o spinner Estado do XML pelo ID.
        spEstado.setAdapter(aEstados);

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                estadoSelecionado = aEstados.getItem(spEstado.getSelectedItemPosition());
                carregarMunicipios(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // capturando o botao btOkConfiguracao do XML pela ID.
        btOkConfiguracao = (Button) findViewById(R.id.btOkConfiguracao);
        // Evento de click do botao btOkConfiguracao.
        btOkConfiguracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Estado estadoSalvo = null;
                Municipio municipioSalvo = null;

                if (opEnteEstadualTelaConfiguracao == null && opEnteMunicipalTelaConfiguracao == null) {
                    Toast.makeText(v.getContext(), "Selecione Governo Estadual ou Prefeitura na opção \"Convênio firmado com:\".", Toast.LENGTH_SHORT).show();
                } else {
                    if (opEnteEstadualTelaConfiguracao.isChecked() == false && opEnteMunicipalTelaConfiguracao.isChecked() == false) {
                        Toast.makeText(v.getContext(), "Selecione Governo Estadual ou Prefeitura na opção \"Convênio firmado com:\".", Toast.LENGTH_SHORT).show();
                    } else if (opEnteEstadualTelaConfiguracao.isChecked() == true) {
                        if (spEstado != null && spEstado.getAdapter() != null && spEstado.getAdapter().isEmpty() == false) {
                            estadoSalvo = aEstados.getItem(spEstado.getSelectedItemPosition());
                        } else {
                            Toast.makeText(v.getContext(), "Escolha um Estado.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (opEnteMunicipalTelaConfiguracao.isChecked() == true) {
                        if (spEstado != null && spEstado.getAdapter() != null && spEstado.getAdapter().isEmpty() == false) {
                            estadoSalvo = aEstados.getItem(spEstado.getSelectedItemPosition());
                        } else {
                            Toast.makeText(v.getContext(), "Escolha um Estado.", Toast.LENGTH_SHORT).show();
                        }

                        if (spMunicipios != null && spMunicipios.getAdapter() != null && spMunicipios.getAdapter().isEmpty() == false) {
                            municipioSalvo = aMunicipios.getItem(spMunicipios.getSelectedItemPosition());
                        } else {
                            Toast.makeText(v.getContext(), "Escolha um Município.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    if ((opEnteEstadualTelaConfiguracao.isChecked() == true && estadoSalvo != null) ||
                            (opEnteMunicipalTelaConfiguracao.isChecked() == true && estadoSalvo != null && municipioSalvo != null)) {
                        startListaConveniosActivity(v, estadoSalvo, municipioSalvo);
                    }
                }
            }
        });
    }

    private void carregarMunicipios(View view) {
        if (opEnteMunicipalTelaConfiguracao.isChecked() == true) {
            if (spEstado.getSelectedItem() != null) {
                // Modelo do Spinner Municipio.
                estadoSelecionado = (Estado) spEstado.getSelectedItem();
                aMunicipios = new ArrayAdapter<Municipio>(view.getContext(), android.R.layout.simple_spinner_item, municipioDAO.listarPorEstado(estadoSelecionado.getCodigo()));
                spMunicipios.setAdapter(aMunicipios);
            }
        } else {
            // Modelo do Spinner Municipio.
            aMunicipios = new ArrayAdapter<Municipio>(view.getContext(), android.R.layout.simple_spinner_item, new ArrayList<Municipio>());
            spMunicipios.setAdapter(aMunicipios);
        }
    }

    private void startListaConveniosActivity(View v, Estado estadoSalvo, Municipio municipioSalvo) {
        Intent listaConveniosActivity = new Intent(v.getContext(), ListaConveniosActivity.class);
        listaConveniosActivity.putExtra("estado", estadoSalvo);
        listaConveniosActivity.putExtra("municipio", municipioSalvo);
        startActivity(listaConveniosActivity);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.opEnteEstadualTelaConfiguracao:
                if (checked) {
                    lblMunicipio.setVisibility(View.INVISIBLE);
                    spMunicipios.setVisibility(View.INVISIBLE);
                    break;
                }
            case R.id.opEnteMunicipalTelaConfiguracao:
                if (checked) {
                    lblMunicipio.setVisibility(View.VISIBLE);
                    spMunicipios.setVisibility(View.VISIBLE);
                    carregarMunicipios(view);
                    break;
                }
        }
    }
}
