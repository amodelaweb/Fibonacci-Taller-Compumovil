package javeriana.edu.co.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fibonacci2 extends AppCompatActivity {


    private int t1 = 0  ;
    private int t2 = 1 ;

    private LinearLayout layout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci2);
        layout = (LinearLayout) findViewById(R.id.caja) ;
        Intent intent = getIntent();
        int n = intent.getIntExtra("num",1);
        calcular(n) ;
    }

    private void calcular(int n ){
        int res ;
        for (int i = 0 ; i < n ;i++){
            res  = t1 + t2 ;
            t1 = t2  ;
            t2 = res ;

            String resp = Integer.toString(res) ;

            TextView texto = new TextView(layout.getContext()) ;
            texto.setText(resp);

            layout.addView(texto);
        }
    }
}
