package finalconvite.br.edu.ifpb.final_convite.AsyncTask;

import android.os.AsyncTask;

import finalconvite.br.edu.ifpb.final_convite.activity.MainActivity;
import finalconvite.br.edu.ifpb.final_convite.entidades.Convidado;
import finalconvite.br.edu.ifpb.final_convite.util.HttpService;
import finalconvite.br.edu.ifpb.final_convite.util.Response;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


public class CadastrarAsyncTask extends AsyncTask<Convidado, Void, Response> {
    private Activity activity;

    public CadastrarAsyncTask(Activity activity){

        this.activity = activity;

    }

    @Override
    protected Response doInBackground(Convidado... params) {

        Response response = null;

        Convidado convidado = params[0];

        Gson gson = new Gson();

        try {

            response = HttpService.sendJSONPostResquest("convidado/cadastro", gson.toJson(convidado));

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

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            Log.e("FinalConvite","OnPostExecute: Erro");
            Toast.makeText(activity, "Algum erro ocorreu", Toast.LENGTH_LONG).show();

        } else {

            Gson gson = new Gson();

            Convidado convidado = gson.fromJson(response.getContentValue(), Convidado.class);

            Toast.makeText(activity,convidado+" cadastro com sucesso", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();

        }
    }
}
