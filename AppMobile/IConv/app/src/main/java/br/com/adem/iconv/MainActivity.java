package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;

public class MainActivity extends AppCompatActivity {

    private Button btConfiguracaoInicial;
    private Button btContinuar;

    private Estado estadoSelecionado;
    private Municipio municipioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estadoSelecionado = (Estado) getIntent().getSerializableExtra("estado");
        municipioSelecionado = (Municipio) getIntent().getSerializableExtra("municipio");

        btConfiguracaoInicial = (Button) findViewById(R.id.btConfiguracaoInicial);
        btContinuar = (Button) findViewById(R.id.btContinuar);

        if (estadoSelecionado == null && municipioSelecionado == null) {
            btConfiguracaoInicial.setVisibility(View.VISIBLE);
            btContinuar.setVisibility(View.INVISIBLE);
        } else {
            btConfiguracaoInicial.setVisibility(View.INVISIBLE);
            btContinuar.setVisibility(View.VISIBLE);
        }
    }

    public void abrirTelaConfiguracao(View view) {
        Intent configuracaoActivity = new Intent(this, ConfiguracaoActivity.class);
        startActivity(configuracaoActivity);
    }

    public void abrirTelaListaConvenios(View view) {
        Intent listaConveniosActivity = new Intent(this, ListaConveniosActivity.class);
        listaConveniosActivity.putExtra("estado", estadoSelecionado);
        listaConveniosActivity.putExtra("municipio", municipioSelecionado);
        startActivity(listaConveniosActivity);
    }
}
