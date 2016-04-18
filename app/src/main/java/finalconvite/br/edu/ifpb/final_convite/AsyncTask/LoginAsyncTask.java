package finalconvite.br.edu.ifpb.final_convite.AsyncTask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;

import finalconvite.br.edu.ifpb.final_convite.activity.MainActivity;
import finalconvite.br.edu.ifpb.final_convite.entidades.Administrador;
import finalconvite.br.edu.ifpb.final_convite.util.HttpService;
import finalconvite.br.edu.ifpb.final_convite.util.Response;

/**
 * Created by Felipe on 17/04/2016.
 */
public class LoginAsyncTask extends AsyncTask<Administrador, Void, Response> {

    private Activity activity;

    public LoginAsyncTask(Activity activity){

        this.activity = activity;

    }

    @Override
    protected Response doInBackground(Administrador... administradors) {

        Response response = null;

        Administrador administrador = administradors[0];

        Log.i("FinalConvite", "doInBack" + administradors[0]);

        Gson gson = new Gson();

        try {

            response = HttpService.sendJSONPostResquest("usuario/login", gson.toJson(administrador));

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;

    }

    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "Código HTTP: " + codeHttp
                + " Conteúdo: " + response.getContentValue());

        if (codeHttp == HttpURLConnection.HTTP_OK) {

            Gson gson = new Gson();

            Administrador administrador = gson.fromJson(response.getContentValue(), Administrador.class);

            Toast.makeText(activity, administrador + " está logado no sistema", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();

        } else {

            Log.e("FinalConvite","OnPostExecute: Erro");
            Toast.makeText(activity,"Usuario ou Senha incorreta", Toast.LENGTH_LONG).show();

        }
    }
}
