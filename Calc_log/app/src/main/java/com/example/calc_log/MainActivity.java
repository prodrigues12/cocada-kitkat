package com.example.calc_log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalcular;
    private EditText pedido, itensCaixa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalcular = findViewById(R.id.button_calcular);
        pedido = findViewById(R.id.editTextNumber_pedido);
        itensCaixa = findViewById(R.id.editTextNumber_itensCaixa);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CalculadoActivity.class);

                if (pedido.getText().toString().equals("") || itensCaixa.getText().toString().equals("")) {
                    Snackbar.make(v, "Preenhca os Campos", Snackbar.LENGTH_LONG)
                            .show();

                } else {
                    Integer infoPedido = Integer.parseInt(pedido.getText().toString());
                    Integer infoCaixa = Integer.parseInt(itensCaixa.getText().toString());

                    if(infoCaixa.equals(0)){
                        Toast.makeText(getApplicationContext(), "Campos não podem ser 0", Toast.LENGTH_SHORT).show();
                    }

                    if (infoPedido < infoCaixa) {
                        Toast.makeText(getApplicationContext(), "Itens na caixa maior que Pedido.", Toast.LENGTH_SHORT).show();
                    } else {

                        intent.putExtra("infoPedido", infoPedido);
                        intent.putExtra("infoCaixa", infoCaixa);
                        startActivity(intent);
                    }


                }

            }
        });

    }

}