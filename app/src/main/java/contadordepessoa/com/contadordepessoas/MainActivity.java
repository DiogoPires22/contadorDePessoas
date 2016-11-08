package contadordepessoa.com.contadordepessoas;

import android.app.Activity;
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
                numeroPessoas=0;
                numeroMulheres=numeroPessoas;
                numeroHomens=numeroPessoas;
                String msg=Integer.toString(numeroPessoas);
                campoTexto.setText("Total: "+msg+" pessoas");
                botaoMulher.setText(Integer.toString(numeroMulheres));
                botaoHomem.setText(Integer.toString(numeroHomens));
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
