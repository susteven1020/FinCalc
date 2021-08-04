package com.example.fincalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcInvest = this.findViewById(R.id.calcInvest);
        calcInvest.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText principal = MainActivity.this.findViewById(R.id.principle);
                EditText profitRate = MainActivity.this.findViewById(R.id.profitRate);
                EditText investYears = MainActivity.this.findViewById(R.id.investYears);

                // check input values are null/empty https://luckyboy7527.pixnet.net/blog/post/102390946
                if( !"".equals(principal.getText().toString()) && !"".equals(profitRate.getText().toString()) && !"".equals(investYears.getText().toString()) ) {
                    double a = Double.parseDouble(principal.getText().toString());
                    double r = Double.parseDouble(profitRate.getText().toString());
                    double n = Double.parseDouble(investYears.getText().toString());
                    double s = a * Math.pow(1+r,n);
                    TextView investTotal = MainActivity.this.findViewById(R.id.investTotal);

                    // keep 4 digits after period(.) https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/541192/
                    investTotal.setText(" " + Math.round(s*10000)/10000.0);
                }

                else {
                    TextView investTotal = MainActivity.this.findViewById(R.id.investTotal);

                    // setText color https://stackoverflow.com/questions/4602902/how-to-set-the-text-color-of-textview-in-code
                    // dark red 	#8B0000
                    investTotal.setTextColor(0xAA8B0000);

                    // setText from strings.xml https://stackoverflow.com/questions/6938838/how-to-set-text-to-a-text-view-from-a-string-xml-and-normal-string-at-a-time
                    investTotal.setText(" " + getString(R.string.input_error));
                }

            }
        });

        Button calcLoan = this.findViewById(R.id.calcLoan);
        calcLoan.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText loan = MainActivity.this.findViewById(R.id.loan);
                EditText interest = MainActivity.this.findViewById(R.id.interest);
                EditText loanYears = MainActivity.this.findViewById(R.id.loanYears);
                if( !"".equals(loan.getText().toString()) && !"".equals(interest.getText().toString()) && !"".equals(loanYears.getText().toString()) ) {
                    double s = Double.parseDouble(loan.getText().toString());
                    double r = Double.parseDouble(interest.getText().toString());
                    double n = Double.parseDouble(loanYears.getText().toString());
                    double m = s * (Math.pow((1 + r / 12), (n * 12)) * (r / 12)) / (Math.pow((1 + r / 12), (n * 12)) - 1);
                    TextView repayment = MainActivity.this.findViewById(R.id.repayment);
                    repayment.setText(" " + Math.round(m*10000)/10000.0);
                }

                else {
                    TextView repayment = MainActivity.this.findViewById(R.id.repayment);
                    repayment.setTextColor(0xAA8B0000);
                    repayment.setText(" " + getString(R.string.input_error));
                }
            }
        });
    }
}