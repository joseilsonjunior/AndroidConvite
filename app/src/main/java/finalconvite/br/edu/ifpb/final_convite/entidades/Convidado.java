package finalconvite.br.edu.ifpb.final_convite.entidades;

/**
 * Created by Felipe on 16/04/2016.
 */
    import java.io.Serializable;
    import com.google.gson.annotations.SerializedName;

    public class Convidado implements Serializable{



        public Convidado (){}


        public void Convidado (String nome, String qrcode,String endereco,String cpf) {

            this.nome = nome;
            this.qrcode = qrcode;
            this.cpf = cpf;
            this.endereco = endereco;

        }

        @SerializedName("id")
        private int id;

        @SerializedName("nome")
        private String nome;

        @SerializedName("qrcode")
        private String qrcode;


        @SerializedName("email")
        private String email;


        @SerializedName("endereco")
        private String endereco;

        @SerializedName("cpf")
        private String cpf;


        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }


        public void setEmail(String email) {
            this.email = email;
        }
        public String getEndereco() {
            return endereco;
        }

        public String getEmail() {
            return email;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }


        public String toString() {

            return "[nome: " + nome + "; qrcode: " + qrcode + "]";

        }

    }
