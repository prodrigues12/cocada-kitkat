package com.example.calc_log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoActivity extends AppCompatActivity {

    private TextView caixas, unidades;
    private Button novoCalculo, buttonFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculado);

        caixas = findViewById(R.id.textView_caixas);
        unidades = findViewById(R.id.textView_unidade);
        novoCalculo = findViewById(R.id.button_novoCalculo);
        buttonFechar = findViewById(R.id.button3);

        Bundle dados = getIntent().getExtras();

        Integer recebidoPedido = dados.getInt("infoPedido");
        Integer recebidoCaixa = dados.getInt("infoCaixa");

        Integer qtdCaixas = recebidoPedido / recebidoCaixa;
        Integer qtdUnidades =recebidoPedido % recebidoCaixa;

        caixas.setText("Caixas: " + qtdCaixas.toString());
        unidades.setText("unidades: " + qtdUnidades.toString());

        novoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });
        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}