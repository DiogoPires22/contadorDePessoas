package contadordepessoa.com.contadordepessoas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static contadordepessoa.com.contadordepessoas.People.*;


enum People{
    Male,
    Female
}

public class MainActivity extends Activity {
    int numeroHomens=0;
    int numeroPessoas=0;
    int numeroMulheres=0;
    TextView campoTexto;
    Button botaoHomem,botaoMulher,botaoReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia dos campos
          campoTexto= (TextView) findViewById(R.id.textoPessoas);
          botaoHomem = (Button) findViewById(R.id.botaoHomem);
          botaoMulher = (Button) findViewById(R.id.botaoMulher);
          botaoReset = (Button) findViewById(R.id.botaoReset);





        botaoHomem.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                AddPeople(Male);
            }
        });





        botaoMulher.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                AddPeople(Female);
            }

        });


        botaoReset.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                        final AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                        alert.setMessage("Voce deseja resetar o contador?");
                        alert.setCancelable(true);
                        alert.setButton(DialogInterface.BUTTON_POSITIVE,"OK",new DialogInterface.OnClickListener() {
                             public void onClick(DialogInterface dialog, int id) {
                                 numeroPessoas=0;
                                 numeroMulheres=numeroPessoas;
                                 numeroHomens=numeroPessoas;
                                 String msg=Integer.toString(numeroPessoas);
                                 campoTexto.setText("Total: "+msg+" pessoas");
                                 botaoMulher.setText(Integer.toString(numeroMulheres));
                                 botaoHomem.setText(Integer.toString(numeroHomens));
                             }
                        });

                        alert.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancelar",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               alert.hide();
                            }
                        });

                        alert.show();





            }

        });



    }
    public void  AddPeople(People p) {
        numeroPessoas++;
        switch(p){
            case Male:{
                numeroHomens++;
                botaoHomem.setText(Integer.toString(numeroHomens));
            }
            break;
            case Female :{

                numeroMulheres++;
                botaoMulher.setText(Integer.toString(numeroMulheres));
            }
            break;
        }
        String msg=Integer.toString(numeroPessoas);
        campoTexto.setText("Total: "+msg+" pessoas");

    }
}
