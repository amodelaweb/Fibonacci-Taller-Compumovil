package javeriana.edu.co.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class pais extends AppCompatActivity {

    private TextView nombre ;
    private TextView nombre_int ;
    private TextView capital ;
    private TextView sigla ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);
        nombre = (TextView) findViewById(R.id.paia_s);
        nombre_int = (TextView) findViewById(R.id.nombre_int_s);
        capital = (TextView) findViewById(R.id.capital_s);
        sigla = (TextView) findViewById(R.id.sigla_s) ;

        Intent intent = getIntent();
        Pais p = (Pais) intent.getSerializableExtra("Pais");

        nombre.setText(p.getNombre_pais());
        nombre_int.setText(p.getGetNombre_pais_int());
        capital.setText(p.getCapital());
        sigla.setText(p.getSigla());
    }
}
