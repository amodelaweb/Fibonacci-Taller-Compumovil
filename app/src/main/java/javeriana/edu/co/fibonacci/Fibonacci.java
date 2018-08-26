package javeriana.edu.co.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Date;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Fibonacci extends AppCompatActivity {

    private static int veces_fib = 0 ;
    private static int veces_fact = 0 ;
    private static Date ultimo_fib = new Date();
    private static Date ultimo_fact = new Date();
    private Button boton ;
    private Button boton2 ;
    private EditText numero  ;
    private EditText numero2  ;
    private TextView vecesfib ;
    private TextView vecesfac ;
    private TextView ultimofac ;
    private TextView ultimofib ;
    private ImageButton biografia ;
    private Button banderabut ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        boton = (Button) findViewById(R.id.boton);
        boton2 = (Button) findViewById(R.id.boton2);
        numero = (EditText) findViewById(R.id.numero) ;
        numero2 = (EditText) findViewById(R.id.numero2) ;
        vecesfib = (TextView) findViewById(R.id.vecesfib);
        vecesfac = (TextView) findViewById(R.id.vecesfact);
        ultimofac = (TextView) findViewById(R.id.ultimofact);
        ultimofib = (TextView) findViewById(R.id.ultimofib);
        biografia = (ImageButton) findViewById(R.id.imagen) ;
        banderabut = (Button) findViewById(R.id.botonpaises);
        banderabut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),Banderas.class);
                startActivity(intent);
            }
        });
        biografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),BiografiaGalileo.class);
                startActivity(intent);
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veces_fib+=1 ;
                ultimo_fib = new Date();
                Intent intent = new Intent(view.getContext(),Fibonacci2.class);
                intent.putExtra("num", Integer.parseInt(String.valueOf(numero.getText())) );

                startActivity(intent);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veces_fact+=1 ;
                ultimo_fact = new Date() ;
                Intent intent = new Intent(view.getContext(),Factorial2.class);
                intent.putExtra("num", Integer.parseInt(String.valueOf(numero2.getText())) );
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        vecesfib.setText(Integer.toString(veces_fib));
        vecesfac.setText(Integer.toString(veces_fact));
        if (veces_fact > 0){
            ultimofac.setText(ultimo_fact.toString());
        }
        if (veces_fib > 0) {
            ultimofib.setText(ultimo_fib.toString());
        }
    }
}
