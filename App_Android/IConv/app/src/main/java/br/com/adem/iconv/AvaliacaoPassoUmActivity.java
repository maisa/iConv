package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.adem.iconv.model.Convenio;
import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;

public class AvaliacaoPassoUmActivity extends AppCompatActivity {

    private Button btAvaliacaoAprovaConvenio;
    private Button btAvaliacaoNaoAprovaConvenio;
    private Button btNaoOpinaAvaliacao;
    private Convenio convenioSelecionado;
    private Estado estadoSelecionado;
    private Municipio municipioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_um);

        estadoSelecionado = (Estado) getIntent().getSerializableExtra("estado");
        municipioSelecionado = (Municipio) getIntent().getSerializableExtra("municipio");
        convenioSelecionado = (Convenio) getIntent().getSerializableExtra("convenio");

        if (convenioSelecionado != null) {
            TextView txtConvenioTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConvenioTelaAvaliacaoUm);
            TextView txtConcedenteTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConcedenteTelaAvaliacaoUm);
            TextView txtConvenenteTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConvenenteTelaAvaliacaoUm);
            TextView txtValorTotalTelaAvaliacaoUm = (TextView) findViewById(R.id.txtValorTotalTelaAvaliacaoUm);
            TextView txtValorRepassadoTelaAvaliacaoUm = (TextView) findViewById(R.id.txtValorRepassadoTelaAvaliacaoUm);
            TextView txtValorARepassarTelaAvaliacaoUm = (TextView) findViewById(R.id.txtValorARepassarTelaAvaliacaoUm);
            TextView txtObjetoResumidoTelaAvaliacaoUm = (TextView) findViewById(R.id.txtObjetoResumidoTelaAvaliacaoUm);

            txtConvenioTelaAvaliacaoUm.setText(convenioSelecionado.getConvenio());
            txtConcedenteTelaAvaliacaoUm.setText(convenioSelecionado.getConcedente());
            txtConvenenteTelaAvaliacaoUm.setText(convenioSelecionado.getConvenente());
            txtValorTotalTelaAvaliacaoUm.setText(convenioSelecionado.getValorTotal());
            txtValorRepassadoTelaAvaliacaoUm.setText(convenioSelecionado.getValorRepassado());
            txtValorARepassarTelaAvaliacaoUm.setText(convenioSelecionado.getValorRestante());
            txtObjetoResumidoTelaAvaliacaoUm.setText(convenioSelecionado.getObjeto());
        }

        // capturando o botao btAvaliacaoAprovaConvenio do XML pela ID.
        btAvaliacaoAprovaConvenio = (Button) findViewById(R.id.btAvaliacaoAprovaConvenio);
        // Evento de click do botao btAvaliacaoAprovaConvenio.
        btAvaliacaoAprovaConvenio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Sua opinião foi registrada!", Toast.LENGTH_SHORT).show();
                Intent listaConveniosActivity = new Intent(v.getContext(), ListaConveniosActivity.class);
                listaConveniosActivity.putExtra("convenio", convenioSelecionado);
                listaConveniosActivity.putExtra("estado", estadoSelecionado);
                listaConveniosActivity.putExtra("municipio", municipioSelecionado);
                startActivity(listaConveniosActivity);
            }
        });

        // capturando o botao btAvaliacaoNaoAprovaConvenio do XML pela ID.
        btAvaliacaoNaoAprovaConvenio = (Button) findViewById(R.id.btAvaliacaoNaoAprovaConvenio);
        // Evento de click do botao btAvaliacaoNaoAprovaConvenio.
        btAvaliacaoNaoAprovaConvenio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avaliacaoPassoDoisActivity = new Intent(v.getContext(), AvaliacaoPassoDoisActivity.class);
                avaliacaoPassoDoisActivity.putExtra("convenio", convenioSelecionado);
                avaliacaoPassoDoisActivity.putExtra("estado", estadoSelecionado);
                avaliacaoPassoDoisActivity.putExtra("municipio", municipioSelecionado);
                startActivity(avaliacaoPassoDoisActivity);
            }
        });

        // capturando o botao btNaoOpinaAvaliacao do XML pela ID.
        btNaoOpinaAvaliacao = (Button) findViewById(R.id.btNaoOpinaAvaliacao);
        // Evento de click do botao btNaoOpinaAvaliacao.
        btNaoOpinaAvaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listaConveniosActivity = new Intent(v.getContext(), ListaConveniosActivity.class);
                listaConveniosActivity.putExtra("convenio", convenioSelecionado);
                listaConveniosActivity.putExtra("estado", estadoSelecionado);
                listaConveniosActivity.putExtra("municipio", municipioSelecionado);
                startActivity(listaConveniosActivity);
            }
        });
    }

    public void abrirTelaPrestacaoContas(View view) {
        Intent prestacaoContasActivity = new Intent(view.getContext(), PrestacaoContasActivity.class);
        prestacaoContasActivity.putExtra("convenio", convenioSelecionado);
        prestacaoContasActivity.putExtra("estado", estadoSelecionado);
        prestacaoContasActivity.putExtra("municipio", municipioSelecionado);
        startActivity(prestacaoContasActivity);
    }
}
