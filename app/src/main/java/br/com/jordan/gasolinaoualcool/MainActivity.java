package br.com.jordan.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etAlcool, etGasolina;
    private Button btVerificar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlcool = (EditText) findViewById(R.id.etAlcool);
        etGasolina = (EditText) findViewById(R.id.etGasolina);
        btVerificar = (Button) findViewById(R.id.btVerificar);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btVerificar.setOnClickListener(listenerVerificar);
    }

    private View.OnClickListener listenerVerificar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (!(etAlcool.getText().toString().isEmpty() && etGasolina.getText().toString().isEmpty())) {
                double alcool = Double.parseDouble(etAlcool.getText().toString());
                double gasolina = Double.parseDouble(etGasolina.getText().toString());

                double resultado = alcool / gasolina;

                if(resultado >= 0.7){
                    tvResultado.setText("É melhor utilizar Gasolina");
                }else{
                    tvResultado.setText("É melhor utilizar Álcool");
                }

                etAlcool.setText("");
                etGasolina.setText("");
            }else{
                Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
