package budget.example.com.budget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Budget extends Activity {

    private TextView popup_dialog_message;
    private EditText userIncome,food_textbox,rent_textbox,laundry_textbox,savings_textbox;
    private Context context = this;

    public Button user_submit,food_update,savings_update,laundry_update,rent_update;
    public TextView food, laundry,savings,expences,rent,food_amount,laundry_amount,savings_amount,income_amount, rent_amount;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

        userIncome = (EditText) findViewById(R.id.UserInput);
        user_submit = (Button) findViewById(R.id.submit);

        user_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Budget_breakdown.class);

                intent.putExtra("user_income",userIncome.getText().toString());
                startActivity(intent);
                income_amount = (TextView) findViewById(R.id.income_amount);
                income_amount.setText(userIncome.getText());


            }
        });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.budget, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
