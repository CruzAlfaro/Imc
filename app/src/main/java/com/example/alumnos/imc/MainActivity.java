package com.example.alumnos.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mCampoPeso;
    private EditText mCampoEstatura;
    private Button mBotonCalcular;
    private Button mBotonLimpiar;
    private TextView mEtiquetaImc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText mCampoPeso = (EditText)findViewById(R.id.campo_peso);
        final EditText mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
        Button mBotonCalcular = (Button) findViewById(R.id.boton_calcular);
        Button mBotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        final TextView mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);

        mBotonCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / (estatura * estatura);
                s = String.format("%2.2f", imc);
                mEtiquetaImc.setText(s);
            }
        });

        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }
        });
    }
}
