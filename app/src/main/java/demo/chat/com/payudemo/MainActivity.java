package demo.chat.com.payudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText fname, pnumber, emailAddress, rechargeAmt;
    Button Paynow;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String MobilePattern = "[0-9]{10}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = (EditText) findViewById(R.id.name);
        pnumber = (EditText) findViewById(R.id.phone);
        emailAddress = (EditText) findViewById(R.id.email);
        rechargeAmt = (EditText) findViewById(R.id.amount);
        Paynow = (Button) findViewById(R.id.pay);
        Paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((fname.getText().length() == 0)) {
                    fname.setError("Enter Your Number");
                } else if (!pnumber.getText().toString().matches(MobilePattern)) {
                    pnumber.setError("Enter 10 digit no.");
                } else if (!emailAddress.getText().toString().matches(emailPattern)) {
                    emailAddress.setError("Enter Email id");
                } else if (rechargeAmt.getText().toString().trim().equalsIgnoreCase("")) {
                    rechargeAmt.setError("Enter amount");
                } else {

                    String getFname = fname.getText().toString().trim();
                    String getPhone = pnumber.getText().toString().trim();
                    String getEmail = emailAddress.getText().toString().trim();
                    String getAmt = rechargeAmt.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this, PayMentGateWay.class);
                    intent.putExtra("FIRST_NAME", getFname);
                    intent.putExtra("PHONE_NUMBER", getPhone);
                    intent.putExtra("EMAIL_ADDRESS", getEmail);
                    intent.putExtra("RECHARGE_AMT", getAmt);
                    startActivity(intent);

                }


            }
        });
    }
}