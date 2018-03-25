package com.example.etien.calculatrice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.etien.calculatrice.Calculatrice.Returnresultat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19;
    TextView operande1, operande2, symbole;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bt1 = (Button) findViewById(R.id.bt1);
        this.bt2 = (Button) findViewById(R.id.bt2);
        this.bt3 = (Button) findViewById(R.id.bt3);
        this.bt4 = (Button) findViewById(R.id.bt4);
        this.bt5 = (Button) findViewById(R.id.bt5);
        this.bt6 = (Button) findViewById(R.id.bt6);
        this.bt7 = (Button) findViewById(R.id.bt7);
        this.bt8 = (Button) findViewById(R.id.bt8);
        this.bt9 = (Button) findViewById(R.id.bt9);
        this.bt10 = (Button) findViewById(R.id.bt10);
        this.bt11 = (Button) findViewById(R.id.bt11);
        this.bt12 = (Button) findViewById(R.id.bt12);
        this.bt13 = (Button) findViewById(R.id.bt13);
        this.bt14 = (Button) findViewById(R.id.bt14);
        this.bt15 = (Button) findViewById(R.id.bt15);
        this.bt16 = (Button) findViewById(R.id.bt16);
        this.bt17 = (Button) findViewById(R.id.bt17);
        this.bt18 = (Button) findViewById(R.id.bt18);
        this.bt19 = (Button) findViewById(R.id.bt19);

        this.operande1 = (TextView) findViewById(R.id.idoperande1);
        this.operande2 = (TextView) findViewById(R.id.idoperande2);
        this.symbole = (TextView) findViewById(R.id.idsymbole);

        this.bt1.setOnClickListener(this);
        this.bt2.setOnClickListener(this);
        this.bt3.setOnClickListener(this);
        this.bt4.setOnClickListener(this);
        this.bt5.setOnClickListener(this);
        this.bt6.setOnClickListener(this);
        this.bt7.setOnClickListener(this);
        this.bt8.setOnClickListener(this);
        this.bt9.setOnClickListener(this);
        this.bt10.setOnClickListener(this);
        this.bt11.setOnClickListener(this);
        this.bt12.setOnClickListener(this);
        this.bt12.setOnClickListener(this);
        this.bt13.setOnClickListener(this);
        this.bt14.setOnClickListener(this);
        this.bt15.setOnClickListener(this);
        this.bt16.setOnClickListener(this);
        this.bt17.setOnClickListener(this);
        this.bt18.setOnClickListener(this);
        this.bt19.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        input(((Button)view).getText().toString());
    }

    public void input(String text)
    {
        if (isnumber(text) == true)
        {
            inputchiffre(text);
        }
        else if (text.equals("="))
        {
            egal();
        }
        else if (text.equals("(-)"))
        {
            inputmoins();
        }
        else if(text.equals("C"))
        {
            clear();
        }
        else
        {
            inputsymbole(text);
        }

    }

    private void inputmoins()
    {
        if (this.symbole.getText().toString().equals("="))
        {
            clear();
        }

        if (this.symbole.getText().toString().equals("") && this.operande1.getText().toString().equals(""))
        {
            this.operande1.setText("-");
        }
        else if (this.operande2.getText().toString().equals("") && !this.symbole.getText().toString().equals(""))
        {
            this.operande2.setText("-");
        }
    }

    private void inputpoint()
    {
        if(this.symbole.getText().toString().equals("="))
        {
            clear();
        }

        if (this.symbole.getText().toString().equals("") && !this.operande1.getText().toString().equals(""))
        {
            this.operande1.setText(".");
        }
        else if (!this.operande2.getText().toString().equals("") && !this.symbole.getText().toString().equals(""))
        {
            this.operande2.setText(".");
        }
    }


    public boolean isnumber (String text)
    {
        boolean valid;
        try
        {
            Float.parseFloat(text);
            valid =true;
        }
        catch (Exception e)
        {
            valid = false;
        }
        return valid;
    }

    public void inputsymbole(String textsymbole)
    {
        if (this.operande1.getText().toString().equals(""))
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Veuillez rentrer un nombre valide d'abord";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (!this.symbole.getText().toString().equals(""))
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Operateur deja rensigné";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        else
        {
            this.symbole.setText(textsymbole);
        }
    }

    public void inputchiffre(String textechiffre)
    {
        if (this.symbole.getText().toString().equals(""))
        {
            String operande1 = this.operande1.getText().toString();
            this.operande1.setText(operande1+textechiffre);
        }
        else if (this.symbole.getText().toString().equals("="))
        {
            clear();
            String operande1 = this.operande1.getText().toString();
            this.operande1.setText(operande1+textechiffre);
        }
        else
        {
            String operande2 = this.operande2.getText().toString();
            this.operande2.setText(operande2+textechiffre);
        }

    }

    public void egal()
    {
        if ((this.symbole.getText().toString().equals("")) || (this.operande1.toString().equals("")) || (this.operande2.toString().equals("")))
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Veuillez entrer une operation valide";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            String symbole = this.symbole.getText().toString();
            String operande1= this.operande1.getText().toString();
            String operande2= this.operande2.getText().toString();

            String operation = operande1+" "+symbole+" "+operande2;

            String res = Returnresultat(symbole, operande1, operande2);

            this.operande1.setText(operation);
            this.symbole.setText("=");
            this.operande2.setText(res);
        }
    }

    public void clear()
    {
        this.operande1.setText("");
        this.operande2.setText("");
        this.symbole.setText("");
    }
}
