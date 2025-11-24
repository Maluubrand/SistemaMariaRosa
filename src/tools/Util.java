/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.JSONObject;
/**
 *
 * @author u1845853
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);

        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
            if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(-1);
            }

        }
    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

   public static boolean pergunta(String cad) {
    return JOptionPane.showConfirmDialog(null, cad) == JOptionPane.YES_OPTION;

    }

    public static int strToInt(String num) {
        return Integer.parseInt(num);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }

    public static double strToDouble(String cad) {
        return Double.parseDouble(cad); //My person make in my castle 

    }

    public static String doubleToStr(double num) {
        return String.valueOf(num); //My person make in my castle 

    }

        public static Date strToDate(String data) {
          SimpleDateFormat fm = new SimpleDateFormat("dd/MM/YYYY");
        try {
            return fm.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

public static String dateToStr(Date data) {
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/YYYY");
        return fm.format(data);
    }



     

   public static void validarCep(String cep, JTextField txtEndereco, JTextField txtBairro, JTextField txtCidade) {
    try {
        cep = cep.trim().replaceAll("[^0-9]", ""); // remove espaços e caracteres não numéricos

        if (cep.isEmpty() || cep.length() != 8) {
            JOptionPane.showMessageDialog(null, "Cep salvo com sucesso");
            return;
        }

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");

        if (!scanner.hasNext()) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter dados do CEP!");
            return;
        }

        String jsonStr = scanner.useDelimiter("\\A").next();
        JSONObject json = new JSONObject(jsonStr);

        if (json.has("erro")) {
            JOptionPane.showMessageDialog(null, "CEP não encontrado!");
            txtEndereco.setText("");
            txtBairro.setText("");
            txtCidade.setText("");
        } else {
            txtEndereco.setText(json.optString("logradouro"));
            txtBairro.setText(json.optString("bairro"));
            txtCidade.setText(json.optString("localidade"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar CEP: " + e.getMessage());
    }
}

}
