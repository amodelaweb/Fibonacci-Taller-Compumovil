package javeriana.edu.co.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Factorial2 extends AppCompatActivity {

    private TextView mult ;
    private LinearLayout linear ;
    private LinearLayout linear2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial2);

        linear = (LinearLayout) findViewById(R.id.cajafac)  ;
        linear2 = (LinearLayout) findViewById(R.id.cajafac1) ;
        Intent intent = getIntent();
        int n = intent.getIntExtra("num",1);
        factorial(n) ;
    }

    private void factorial ( int n ){
        String multi = "" ;
        BigInteger result = new BigInteger("00000001");;
        multi = multi + String.valueOf(result) ;
        TextView texto = new TextView(linear.getContext()) ;
        texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        texto.setText(String.valueOf(result) );
        texto.setBackgroundColor(getResources().getColor(R.color.amarillooro));
        linear.addView(texto);
        for ( int i = 2  ; i <= n ; i++){
            TextView texto2 = new TextView(linear.getContext()) ;
            texto2.setText( "*" );
            texto2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            texto2.setBackgroundColor(getResources().getColor(R.color.amarillooro));
            linear.addView(texto2);
            TextView texto4 = new TextView(linear.getContext()) ;
            texto4.setText( Integer.toString(i));
            texto4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            texto4.setBackgroundColor(getResources().getColor(R.color.amarillooro));
            linear.addView(texto4);

            result = result.multiply(new BigInteger(Integer.toString(i)));
            multi = multi + "*"  + Integer.toString(i) ;
        }

        TextView resultadof = new TextView(linear2.getContext()) ;
        resultadof.setText( String.valueOf(result));
        resultadof.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        resultadof.setBackgroundColor(getResources().getColor(R.color.amarillooro));
        linear2.addView(resultadof);


    }
}
