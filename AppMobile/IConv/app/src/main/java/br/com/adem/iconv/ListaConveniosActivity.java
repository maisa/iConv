package br.com.adem.iconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListaConveniosActivity extends AppCompatActivity {

    private TextView lblEstadoTelaListaConvenios;
    private TextView lblMunicipioTelaListaConvenios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_convenios);

        lblEstadoTelaListaConvenios = (TextView) findViewById(R.id.lblEstadoTelaListaConvenios);
        StringBuilder textoLabelEstado = new StringBuilder(lblEstadoTelaListaConvenios.getText());
        textoLabelEstado.append(" Amazonas");
        lblEstadoTelaListaConvenios.setText(textoLabelEstado.toString());

        lblMunicipioTelaListaConvenios = (TextView) findViewById(R.id.lblMunicipioTelaListaConvenios);
        StringBuilder textoLabelMunicipio = new StringBuilder(lblMunicipioTelaListaConvenios.getText());
        textoLabelMunicipio.append(" Manaus");
        lblMunicipioTelaListaConvenios.setText(textoLabelMunicipio.toString());

    }
}
