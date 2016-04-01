package br.com.adem.iconv;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.adem.iconv.model.Convenio;

public class PrestacaoContasActivity extends AppCompatActivity {

    private Convenio convenioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestacao_contas);

        convenioSelecionado = (Convenio) getIntent().getSerializableExtra("convenio");

        String[] de = {"data", "valor", "fornecedor", "cnpj", "notafiscal"};
        int[] para = {R.id.txtDataPagamento, R.id.txtValor, R.id.txtFornecedor, R.id.txtCnpj, R.id.txtNotaFiscal};
        final SimpleAdapter aPagamento= new SimpleAdapter(this, listarPagamentos(), R.layout.layout_lista_pagamentos, de, para);
        final ListView listaPagamento = (ListView) findViewById(R.id.listViewListaPagamentosEfetuados);
        listaPagamento.setAdapter(aPagamento);
    }

    private List<? extends Map<String, ?>> listarPagamentos() {
        List<Map<String, Object>> listaPagamentos = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("data", "23/10/2011");
        item.put("valor", "10323,87");
        item.put("fornecedor", "Fornecedor 1");
        item.put("cnpj", "52.266.765/0001-71");
        item.put("notafiscal", "4398403984");
        listaPagamentos.add(item);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("data", "12/04/2012");
        item2.put("valor", "98392,12");
        item2.put("fornecedor", "Fornecedor 2");
        item2.put("cnpj", "26.188.163/0001-33");
        item2.put("notafiscal", "2672");
        listaPagamentos.add(item2);

        Map<String, Object> item3 = new HashMap<>();
        item3.put("data", "19/07/2012");
        item3.put("valor", "32984,19");
        item3.put("fornecedor", "Fornecedor 3");
        item3.put("cnpj", "57.744.819/0001-80");
        item3.put("notafiscal", "2984209");
        listaPagamentos.add(item3);

        Map<String, Object> item4 = new HashMap<>();
        item4.put("data", "27/01/2013");
        item4.put("valor", "67372,81");
        item4.put("fornecedor", "Fornecedor 4");
        item4.put("cnpj", "73.554.587/0001-54");
        item4.put("notafiscal", "8237");
        listaPagamentos.add(item4);

        return listaPagamentos;
    }

    public void voltarTelaAvaliacaoPassoUm(View view) {
        Intent voltarTelaActivity = new Intent(view.getContext(), AvaliacaoPassoUmActivity.class);
        voltarTelaActivity.putExtra("convenio", convenioSelecionado);
        startActivity(voltarTelaActivity);
    }
}
