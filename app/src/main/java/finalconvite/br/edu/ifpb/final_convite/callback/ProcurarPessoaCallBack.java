package finalconvite.br.edu.ifpb.final_convite.callback;

/**
 * Created by Felipe on 16/04/2016.
 */
import finalconvite.br.edu.ifpb.final_convite.entidades.Convidado;
import java.util.List;
public interface ProcurarPessoaCallBack {

    void backBuscarNome(List<Convidado> names);

    void errorBuscarNome(String error);
}
