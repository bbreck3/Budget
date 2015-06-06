package budget.example.com.budget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Budget extends Activity {

    private TextView popup_dialog_message, Income_label;

    public Intent intent;
    private EditText userIncome,food_textbox,rent_textbox,laundry_textbox,savings_textbox;
    private Context context = this;

    public Button user_submit,food_update,savings_update,laundry_update,rent_update,balance,sum;
    public static TextView food, laundry,savings,expences,rent,food_amount,laundry_amount,savings_amount,income_amount, rent_amount,balance_amount, remaining;
    public static int tot_expences,food_val, sav_val, rent_val,laundry_val;

    String user_income;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_breakdown);

       // popup();


/**
 *
 *      THsi is an issue... THe popup dialog is implemented but the user income amount on the main screen is not setting to the popup inout amount...
 *
 *
 */

        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.popup, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.income_amount_dialog);


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String temp;
                                // get user input and set it to result
                                // edit text

                                user_income = userInput.getText().toString();
                                //temp = userInput.getText().toString();
                                //result = temp;
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        /**
         *
         * Temporary fix for the income is to make a tempory Sting value hardcoded until the popup dial issue is resolved
         */

        user_income = "1000";


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

                //grabs the values from the edit text box of each respective field and set it to an integer variable inorder to
                //prepare for total (sum)
                food_val = Integer.parseInt(food_textbox.getText().toString());//food_amount.getText().toString());
                sav_val =  Integer.parseInt(savings_textbox.getText().toString());//savings_amount.getText().toString());
                rent_val =  Integer.parseInt(rent_textbox.getText().toString());//rent_amount.getText().toString());
                laundry_val =  Integer.parseInt(laundry_textbox.getText().toString());//laundry_amount.getText().toString());

            //grabs the values from the edit text box of each respective field and set it to an integer variable inorder to
               // update the value of the textview
                food_amount.setText(food_textbox.getText().toString());//food_amount.getText().toString());
                rent_amount.setText(rent_textbox.getText().toString());//food_amount.getText().toString());
               laundry_amount.setText(laundry_textbox.getText().toString());//food_amount.getText().toString());
                savings_amount.setText(savings_textbox.getText().toString());//food_amount.getText().toString());

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




        //userIncome = (EditText) findViewById(R.id.UserInput);
        //user_submit = (Button) findViewById(R.id.submit);

        /*user_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Budget_breakdown.class);

                intent.putExtra("user_income",userIncome.getText().toString());
                startActivity(intent);
                income_amount = (TextView) findViewById(R.id.income_amount);
                income_amount.setText(userIncome.getText());


            }
        });*/



    }
    public void popup() {


// get prompts.xml view
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.popup, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);

            final EditText userInput = (EditText) promptsView
                    .findViewById(R.id.income_amount_dialog);


            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                       String temp;
                                    // get user input and set it to result
                                    // edit text

                                    user_income = userInput.getText().toString();
                                    //temp = userInput.getText().toString();
                                    //result = temp;
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();


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
