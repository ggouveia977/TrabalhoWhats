package br.com.up.trabalhowhats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout inputLayoutNumero;
    TextInputLayout inputLayoutMensagem;

    TextInputEditText inputTextNumero;
    TextInputEditText inputTextMensagem;

    Button buttonAddGift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutNumero = findViewById(R.id.input_layout_numero);
        inputLayoutMensagem = findViewById(R.id.input_layout_mensagem);

        inputTextNumero = findViewById(R.id.input_text_numero);
        inputTextMensagem = findViewById(R.id.input_text_mensagem);

        buttonAddGift = findViewById(R.id.button_add_gift);

        buttonAddGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMensagem();
            }
        });
    }

    public void newMensagem() {
        String numero = inputTextNumero.getText().toString();
        String mensagem    = inputTextMensagem.getText().toString();

        if(!numero.isEmpty() && !mensagem.isEmpty()){

            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/"+numero+"?text="+mensagem));
            startActivity(i);


        }else{
            Toast.makeText(MainActivity.this,"Preencha as informções faltantes",Toast.LENGTH_SHORT).show();
        }
    }







}