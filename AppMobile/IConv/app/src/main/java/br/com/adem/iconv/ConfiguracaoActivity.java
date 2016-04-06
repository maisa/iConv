package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.adem.iconv.dao.EstadoDAO;
import br.com.adem.iconv.dao.MunicipioDAO;
import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;

public class ConfiguracaoActivity extends AppCompatActivity {

    private static final EstadoDAO estadoDAO = new EstadoDAO();
    private ArrayAdapter<Estado> aEstados;
    private Spinner spEstado;

    private static final MunicipioDAO municipioDAO = new MunicipioDAO();
    private ArrayAdapter<Municipio> aMunicipios;
    private Spinner spMunicipios;

    private Button btOkConfiguracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        // Modelo do Spinner Estado.
        aEstados = new ArrayAdapter<Estado>(this, android.R.layout.simple_spinner_item, estadoDAO.listar());
        // Captura o spinner Estado do XML pelo ID.
        spEstado = (Spinner) findViewById(R.id.spEstados);
        spEstado.setAdapter(aEstados);

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Estado estadoSelecionado = aEstados.getItem(spEstado.getSelectedItemPosition());

                //Toast.makeText(view.getContext(), "Estado Selecionado ID[" + estadoSelecionado.getCodigo() + "]; UF[" + estadoSelecionado.getUnidadeFederativa() + "]", Toast.LENGTH_SHORT).show();

                if (spEstado.getSelectedItemPosition() != 0) {
                    // Modelo do Spinner Municipio.
                    aMunicipios = new ArrayAdapter<Municipio>(view.getContext(), android.R.layout.simple_spinner_item, municipioDAO.listarPorEstado(estadoSelecionado.getCodigo()));
                    // Captura o spinner Municipio XML pelo ID.
                    spMunicipios = (Spinner) findViewById(R.id.spMunicipios);
                    spMunicipios.setAdapter(aMunicipios);
                }
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

                if (spEstado != null) {
                    estadoSalvo = aEstados.getItem(spEstado.getSelectedItemPosition());
                } else {
                    Toast.makeText(v.getContext(), "É necessário escolher um Estado.", Toast.LENGTH_SHORT).show();
                }

                if (spMunicipios != null) {
                    municipioSalvo = aMunicipios.getItem(spMunicipios.getSelectedItemPosition());
                } else {
                    Toast.makeText(v.getContext(), "É necessário escolher um Município.", Toast.LENGTH_SHORT).show();
                }

                if (estadoSalvo != null && municipioSalvo != null) {
                    Intent mainActivity = new Intent(v.getContext(), MainActivity.class);
                    mainActivity.putExtra("estado", estadoSalvo);
                    mainActivity.putExtra("municipio", municipioSalvo);
                    startActivity(mainActivity);
                }
            }
        });
    }
}
