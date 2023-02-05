package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.alura.aluraviagens.R;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);


        Button botaoRealizaPagamento = findViewById(R.id.activity_pagamento_botao_realiza_pagamento);

 botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
         startActivity(intent);
     }
 });

    }
}