package com.main.justthetip;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Button add;
    Button subtract;
    EditText people_Value;
    EditText bill_amount;
    EditText each_pay_view;
    EditText grandTotalView;
    int people_counter;
    double bill_counter;
    EditText percentage_value;
    Button add_percentage;
    Button subtract_percentage;
    double percentage_counter;
    Button calculate;
    double grand_total;
    double each_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        people_Value = (EditText) findViewById(R.id.people);
        subtract = (Button)findViewById(R.id.subtract_people);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people_counter--;
                if(people_counter < 0)
                {
                    people_counter = 0;
                }
                people_Value.setText(String.valueOf(people_counter)); // create an
            }
        });

        add = (Button) findViewById(R.id.add_people);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people_counter++;
                people_Value.setText(String.valueOf(people_counter));
            }
        });

        bill_amount = (EditText) findViewById(R.id.amount);
        subtract = (Button)findViewById(R.id.subtract_bill);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bill_counter -= 5;
                if(bill_counter < 0)
                {
                    bill_counter =0;
                }
                bill_amount.setText(String.valueOf(bill_counter)); // create an
            }
        });
        add = (Button) findViewById(R.id.add_bill);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bill_counter += 5;
                bill_amount.setText(String.valueOf(bill_counter));
            }
        });

        percentage_value = (EditText) findViewById(R.id.percentage_value);
        add_percentage = (Button) findViewById(R.id.add_percentage);
        subtract_percentage = (Button) findViewById(R.id.subtract_percentage);

        add_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percentage_counter++;
                percentage_value.setText(String.valueOf(percentage_counter));
            }
        });
        subtract_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percentage_counter--;
                if (percentage_counter < 0)
                {
                    percentage_counter = 0;
                }
                percentage_value.setText(String.valueOf(percentage_counter));
            }
        });
        calculate = (Button)findViewById(R.id.calculate);
        each_pay_view = (EditText) findViewById(R.id.each_person_edit);
        grandTotalView = (EditText) findViewById(R.id.grand_total_view);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double percentageEq = (percentage_counter / 100) +1;
                grand_total = (bill_counter * percentageEq);
                grandTotalView.setText(String.valueOf(grand_total));
                grand_total /= people_counter;
                each_pay_view.setText(String.valueOf(grand_total));
            }
        });

        /* percentage_value, bill_amount people_Value*/

        //percentage_value.setOnEditorActionListener(new TextView.onEditorActionListener());
        percentage_value.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    String something = percentage_value.getText().toString();
                    percentage_counter = Double.parseDouble(something);
                    percentage_value.setText(something);
                    return true;
                }
                return false;
            }
        });
        percentage_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    String something = percentage_value.getText().toString();
                    percentage_counter = Double.parseDouble(something);
                    percentage_value.setText(something);
                }
            }
        });

        bill_amount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    String something = bill_amount.getText().toString();
                    bill_counter = Double.parseDouble(something);
                    bill_amount.setText(something);
                    return true;
                }
                return false;
            }

        });
        bill_amount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    String something = bill_amount.getText().toString();
                    bill_counter = Double.parseDouble(something);
                    bill_amount.setText(something);
                }
            }
        });

        people_Value.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    String something = people_Value.getText().toString();
                    people_counter = Integer.parseInt(something);
                    people_Value.setText(something);
                    return true;
                }
                return false;
            }

        });
        people_Value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    String something = people_Value.getText().toString();
                    people_counter = Integer.parseInt(something);
                    people_Value.setText(something);

                }
            }
        });

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.appearance) {
            Toast.makeText(this, "Change Appearance", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.version) {
            Toast.makeText(this, "Version", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
