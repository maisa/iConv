package br.com.adem.iconv;

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

    //private static final String[] estados = {"Selecione o Estado", "Amazonas", "Roraima"};
    private static final EstadoDAO estadoDAO = new EstadoDAO();
    private ArrayAdapter<Estado> aEstados;
    private Spinner spEstado;

    //private static final String[] municipios = {"Selecione o Município", "Manaus", "Boa Vista"};
    private static final MunicipioDAO municipioDAO = new MunicipioDAO();
    private ArrayAdapter<Municipio> aMunicipios;
    private Spinner spMunicipios;

    private Button btOkConfiguracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Abrindo Tela de Configuração.", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(view.getContext(), "Criando a lista de Municipios.", Toast.LENGTH_SHORT).show();

                Estado estadoSelecionado = aEstados.getItem(spEstado.getSelectedItemPosition());

                Toast.makeText(view.getContext(), "Estado Selecionado ID[" + estadoSelecionado.getCodigo() + "]; UF[" + estadoSelecionado.getUnidadeFederativa() + "]", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(v.getContext(), "Estado selecionado (getSelectedItemPosition):" + spEstado.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
                Toast.makeText(v.getContext(), "Estado selecionado (getSelectedItemId):" + spEstado.getSelectedItemId(), Toast.LENGTH_SHORT).show();
                Toast.makeText(v.getContext(), "Estado selecionado (getSelectedItem):" + spEstado.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void salvarConfiguracao(View view) {
        Toast.makeText(this, "Salvando as preferências.", Toast.LENGTH_SHORT).show();
    }
}
