package edu.sunyulster.thomasol.calcpctinc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Instance variables
    //private double origVal = 0;
    //private double newVal =0;
    //private double pctIncVal =0;

    private float a,p,r,n,m,rate;
    private float b,pow,e;

    private EditText amount;
    private EditText interest;
    private EditText time;
    private TextView emi;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amount);
        interest = (EditText) findViewById(R.id.interest);
        time = (EditText) findViewById(R.id.time);
        emi = (TextView)findViewById(R.id.emi);
        buttonView = (Button) findViewById(R.id.button);

        buttonView.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // Code here is our logic
                try {

                    p= Float.parseFloat(amount.getText().toString()) ;
                    r= Float.parseFloat(interest.getText().toString()) ;
                    n= Float.parseFloat(time.getText().toString()) ;

                    //E = P×r×(1 + r)^n/((1 + r)^n - 1)
                    m=n*12;
                    rate=r/12/100;
                    pow = (float) Math.pow((1+rate),m);
                    a=p*rate*pow;
                    b=pow-1;
                    e=a/b;
                    emi.setText(String.format("%.2f",e));
                }
                catch (Exception e){
                    System.out.print(e);
                }
            }
        });



    }
}
