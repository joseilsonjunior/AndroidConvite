package finalconvite.br.edu.ifpb.final_convite.activity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import finalconvite.br.edu.ifpb.final_convite.AsyncTask.CadastrarAsyncTask;
import finalconvite.br.edu.ifpb.final_convite.R;
import finalconvite.br.edu.ifpb.final_convite.entidades.Convidado;

public class CadastraUsuario extends Activity {

    private EditText nome;
    private EditText email;
    private EditText endereco;
    private EditText cpf;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_usuario);

        nome = (EditText) findViewById(R.id.nome_convidado);
        email = (EditText) findViewById(R.id.nome_convidado);
        endereco = (EditText) findViewById(R.id.endereco);
        cpf = (EditText) findViewById(R.id.cpf);


        cadastrar.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {

        Convidado convidado = new Convidado();

        convidado.setNome(nome.getText().toString());
        convidado.setEmail(email.getText().toString());
        convidado.setEndereco(endereco.getText().toString());
        convidado.setCpf(cpf.getText().toString());

        CadastrarAsyncTask cadastrarAsyncTask = new CadastrarAsyncTask(this);
        cadastrarAsyncTask.execute(convidado);

    }
}
