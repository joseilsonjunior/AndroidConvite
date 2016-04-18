package finalconvite.br.edu.ifpb.final_convite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import finalconvite.br.edu.ifpb.final_convite.AsyncTask.LoginAsyncTask;
import finalconvite.br.edu.ifpb.final_convite.R;
import finalconvite.br.edu.ifpb.final_convite.entidades.Administrador;

public class LoginActivity extends Activity implements OnClickListener {

    private EditText emaillogin;
    private EditText senhalogin;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emaillogin = (EditText) findViewById(R.id.email_login);
        senhalogin = (EditText) findViewById(R.id.senha_login);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        Administrador administrador = new Administrador();
        administrador.setEmail(emaillogin.getText().toString());
        administrador.setSenha(senhalogin.getText().toString());

        LoginAsyncTask loginAsyncTask = new LoginAsyncTask(this);
        loginAsyncTask.execute(administrador);

    }
}
