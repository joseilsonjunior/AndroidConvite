package finalconvite.br.edu.ifpb.final_convite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import finalconvite.br.edu.ifpb.final_convite.R;

public class ConteudoQRCode extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_qrcode);


        TextView conteudoQRcode = (TextView) findViewById(R.id.ConteudoShow);

        Intent intent = getIntent();

        conteudoQRcode.setText(("Content: " + (String) intent.getSerializableExtra("conteudoQRCode")));
    }
}
