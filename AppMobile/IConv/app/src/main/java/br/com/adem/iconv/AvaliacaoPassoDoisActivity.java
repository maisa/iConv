package br.com.adem.iconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.adem.iconv.model.Convenio;

public class AvaliacaoPassoDoisActivity extends AppCompatActivity {

    private Button btConfirmaAvalicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_dois);

        final Convenio convenio = (Convenio) getIntent().getSerializableExtra("convenio");
        if (convenio != null) {
            TextView txtConvenioTelaAvaliacaoDois = (TextView) findViewById(R.id.txtConvenioTelaAvaliacaoDois);
            TextView txtConcedenteTelaAvaliacaoDois = (TextView) findViewById(R.id.txtConcedenteTelaAvaliacaoDois);
            TextView txtConvenenteTelaAvaliacaoDois = (TextView) findViewById(R.id.txtConvenenteTelaAvaliacaoDois);

            txtConvenioTelaAvaliacaoDois.setText(convenio.getConvenio());
            txtConcedenteTelaAvaliacaoDois.setText(convenio.getConcedente());
            txtConvenenteTelaAvaliacaoDois.setText(convenio.getConvenente());
        }

        // capturando o botao btConfirmaAvalicao do XML pela ID.
        btConfirmaAvalicao = (Button) findViewById(R.id.btConfirmaAvalicao);
        // Evento de click do botao btConfirmaAvalicao.
        btConfirmaAvalicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Avaliação Confirmada!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
