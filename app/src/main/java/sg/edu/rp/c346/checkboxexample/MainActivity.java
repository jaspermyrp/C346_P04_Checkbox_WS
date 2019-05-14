package sg.edu.rp.c346.checkboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI Components //
        cbEnabled = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");

                String message = "";
                double pay = 0.0;

                if (!cbEnabled.isChecked()) {
                    pay = calcPay(100,0);
                    message = "Discount not given, you need to pay $"+pay;
                } else {
                    pay = calcPay(100,20);
                    message = "Discount is given, you need to pay $"+pay;
                    Toast.makeText(MainActivity.this, "Discount given", Toast.LENGTH_LONG).show();
                }

                tvShow.setText(message);

            }
        });
    }

    private double calcPay(double price, double discount) {
        double pay = price * (1 - discount / 100);
        return pay;
    }
}
