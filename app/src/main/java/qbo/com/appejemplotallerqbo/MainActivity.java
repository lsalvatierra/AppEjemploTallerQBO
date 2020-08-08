package qbo.com.appejemplotallerqbo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText ettalla, etpeso;
    private Button btncalcular;
    private TextView tvresultado;
    private ListView lvimc;
    private List<String> listimc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ettalla = findViewById(R.id.ettalla);
        etpeso = findViewById(R.id.etpeso);
        btncalcular = findViewById(R.id.btncalcular);
        tvresultado = findViewById(R.id.tvresultado);
        lvimc = findViewById(R.id.lvimc);
        listimc = new ArrayList<>();

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ettalla.getText().toString().equals("")){
                    ettalla.setError("Ingrese su talla");
                }else if(etpeso.getText().toString().equals("")){
                    etpeso.setError("Ingrese su peso");
                }else{
                    Double peso, talla, tallam, imc;
                    String resultadoIMC ="";
                    peso = Double.parseDouble(etpeso.getText().toString());
                    talla = Double.parseDouble(ettalla.getText().toString());
                    tallam = talla / 100;
                    imc = peso / (tallam * tallam);
                    if(imc <= 18.5){
                        resultadoIMC = "Por debajo del peso";

                        tvresultado.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorimcbajo));
                    }else if(imc <= 25){
                        resultadoIMC ="Con peso normal";
                        tvresultado.setTextColor(getResources().getColor(R.color.colorimcnormal));
                    }else if(imc <= 30){
                        resultadoIMC = "Con sobrepeso";
                        tvresultado.setTextColor(getResources().getColor(R.color.colorimcsobrepeso));
                    }else if(imc <= 35){
                        resultadoIMC="Obesidad leve";
                        tvresultado.setTextColor(getResources().getColor(R.color.colorimcobesidad1));
                    }else if(imc <= 39){
                        resultadoIMC = "Obsesidad media";
                        tvresultado.setTextColor(getResources().getColor(R.color.colorimcobesidad2));
                    }else {
                        resultadoIMC ="Obesidad mórbida";
                        tvresultado.setTextColor(getResources().getColor(R.color.colorimcobesidad3));
                    }
                    DecimalFormat df = new DecimalFormat("##.00");
                    tvresultado.setText("Su valor de IMC es:"+ df.format(imc)+
                            " ud. se encuentra: " + resultadoIMC);
                    listimc.add("Valor IMC: "+ df.format(imc)+" "+resultadoIMC);
                    //Reutilizar el adapter y el layout del S.O.
                    ArrayAdapter adapterandroidver = new ArrayAdapter(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            listimc);
                    lvimc.setAdapter(adapterandroidver);
                }
            }
        });

    }
}
