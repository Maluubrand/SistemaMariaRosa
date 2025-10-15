package tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ViaCEP {

    public static Endereco buscar(String cep) {
        Endereco endereco = new Endereco();
        try {
            // Remove qualquer caractere que não seja número
            cep = cep.replaceAll("[^0-9]", "");

            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            JSONObject json = new JSONObject(content.toString());

            if (json.has("erro")) {
                endereco.setErro(true);
            } else {
                endereco.setLogradouro(json.optString("logradouro"));
                endereco.setBairro(json.optString("bairro"));
                endereco.setCidade(json.optString("localidade"));
                endereco.setUf(json.optString("uf"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            endereco.setErro(true);
        }

        return endereco;
    }
}
