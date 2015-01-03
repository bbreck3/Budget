package budget.example.com.budget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    public Button user_submit,food_update,savings_update,laundry_update,rent_update;
    public TextView food, laundry,savings,expences,rent,food_amount,laundry_amount,savings_amount,income_amount, rent_amount;
    String user_income;
    String test= "test";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_budget_breakdown);
        Intent intent = getIntent();

        user_income = intent.getStringExtra("user_income");

        income_amount = (TextView)findViewById(R.id.income_amount);
        income_amount.setText(user_income);

        food_textbox = (EditText) findViewById(R.id.food_textbox);
        food_update = (Button) findViewById(R.id.update_food);
        food_update.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                setContentView(R.layout.activity_budget);
                food_amount.setText(food_textbox.getText());
            }

        });
        rent_textbox = (EditText) findViewById(R.id.rent_textbox);
        rent_update = (Button) findViewById(R.id.update_rent);
        rent_update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                rent_amount.setText(rent_textbox.getText());
            }

        });
        savings_textbox = (EditText) findViewById(R.id.rent_textbox);
        savings_update = (Button) findViewById(R.id.update_savings);
        savings_update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                savings_amount.setText(savings_textbox.getText());
            }

        });

        laundry_textbox = (EditText) findViewById(R.id.laundry_textbox);
        laundry_update = (Button) findViewById(R.id.update_laundry);
        laundry_update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                laundry_amount.setText(laundry_textbox.getText());
            }

        });

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
