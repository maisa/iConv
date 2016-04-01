package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.adem.iconv.model.Convenio;

public class AvaliacaoPassoUmActivity extends AppCompatActivity {

    private Button btAvaliacaoAprovaConvenio;
    private Button btAvaliacaoNaoAprovaConvenio;
    private Button btNaoOpinaAvaliacao;
    private Convenio convenioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_um);

        convenioSelecionado = (Convenio) getIntent().getSerializableExtra("convenio");
        if (convenioSelecionado != null) {
            TextView txtConvenioTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConvenioTelaAvaliacaoUm);
            TextView txtConcedenteTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConcedenteTelaAvaliacaoUm);
            TextView txtConvenenteTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConvenenteTelaAvaliacaoUm);

            txtConvenioTelaAvaliacaoUm.setText(convenioSelecionado.getConvenio());
            txtConcedenteTelaAvaliacaoUm.setText(convenioSelecionado.getConcedente());
            txtConvenenteTelaAvaliacaoUm.setText(convenioSelecionado.getConvenente());
        }

        // capturando o botao btAvaliacaoAprovaConvenio do XML pela ID.
        btAvaliacaoAprovaConvenio = (Button) findViewById(R.id.btAvaliacaoAprovaConvenio);
        // Evento de click do botao btAvaliacaoAprovaConvenio.
        btAvaliacaoAprovaConvenio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Convênio Aprovado.", Toast.LENGTH_SHORT).show();
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
                startActivity(avaliacaoPassoDoisActivity);
            }
        });

        // capturando o botao btNaoOpinaAvaliacao do XML pela ID.
        btNaoOpinaAvaliacao = (Button) findViewById(R.id.btNaoOpinaAvaliacao);
        // Evento de click do botao btNaoOpinaAvaliacao.
        btNaoOpinaAvaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Não opinou sobre o Convênio.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void abrirTelaPrestacaoContas(View view) {
        Intent prestacaoContasActivity = new Intent(view.getContext(), PrestacaoContasActivity.class);
        prestacaoContasActivity.putExtra("convenio", convenioSelecionado);
        startActivity(prestacaoContasActivity);
    }
}
