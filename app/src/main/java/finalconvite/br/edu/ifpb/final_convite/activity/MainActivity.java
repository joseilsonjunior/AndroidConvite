package finalconvite.br.edu.ifpb.final_convite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import finalconvite.br.edu.ifpb.final_convite.AsyncTask.BuscarNomeAsyncTask;
import finalconvite.br.edu.ifpb.final_convite.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaobuscarnome = (Button) findViewById(R.id.buscar_nome);
        Button botaobuscarqr = (Button) findViewById(R.id.buscar_qr);
        Button botaocadastro = (Button) findViewById(R.id.cadastrar);

        botaobuscarqr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        QrCodeActivity.class);


                startActivity(intent);

                finish();
            }
        });


        botaobuscarnome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        BuscarPorNomeActivity.class);


                startActivity(intent);

                finish();
            }
        });
        botaocadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        CadastraUsuario.class);


                startActivity(intent);

                finish();
            }
        });
    }
}
