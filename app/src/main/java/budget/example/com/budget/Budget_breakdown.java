package budget.example.com.budget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Budget_breakdown extends Activity {


    private TextView popup_dialog_message;
    private EditText userIncome,food_textbox,rent_textbox,laundry_textbox,savings_textbox;
    private Context context = this;

    public Button user_submit,food_update,savings_update,laundry_update,rent_update,balance,sum;
    public static TextView food, laundry,savings,expences,rent,food_amount,laundry_amount,savings_amount,income_amount, rent_amount,balance_amount, remaining;
    public static int tot_expences,food_val, sav_val, rent_val,laundry_val;
    String user_income;
   // String test= "test";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_budget_breakdown);
        Intent intent = getIntent();

        user_income = intent.getStringExtra("user_income");

        income_amount = (TextView)findViewById(R.id.income_amount);
        income_amount.setText(user_income);

        food_textbox = (EditText) findViewById(R.id.food_textbox);
        rent_textbox = (EditText) findViewById(R.id.rent_textbox);
        savings_textbox = (EditText) findViewById(R.id.savings_textbox);
        laundry_textbox = (EditText) findViewById(R.id.laundry_textbox);



        expences = (TextView)findViewById(R.id.expendentures);
        balance = (Button)findViewById(R.id.balance);
        balance.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                     food_val = Integer.parseInt(food_amount.getText().toString());
                     sav_val =  Integer.parseInt(savings_amount.getText().toString());
                     rent_val =  Integer.parseInt(rent_amount.getText().toString());
                     laundry_val =  Integer.parseInt(laundry_amount.getText().toString());
                    tot_expences = food_val + sav_val +rent_val + laundry_val;
                    expences.setText(Integer.toString(tot_expences));
                    int test = Integer.parseInt(income_amount.getText().toString());
                    int leftover = test-tot_expences;//test-tot_expences;
                    remaining.setText(Integer.toString(leftover));
                    balance_amount.setText(Integer.toString(leftover));
                }

        });


        remaining = (TextView)findViewById(R.id.remaining);
       balance_amount = (TextView)findViewById(R.id.balance_amount);


        food_amount = (TextView) findViewById(R.id.food_amount);
        laundry_amount = (TextView) findViewById(R.id.laundry_amount);
        savings_amount = (TextView) findViewById(R.id.savings_amount);
        rent_amount = (TextView) findViewById(R.id.rent_amount);







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_budget_breakdown, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
