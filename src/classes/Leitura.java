package classes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
    public String entDados(String dados){
        
        System.out.println(dados);
        
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(input);
        
        String leit = "";
        
        try {
            leit = buf.readLine();
        } catch (IOException ex) {
            System.out.println("Erro na leitura." + ex);
        }
        return leit;
    }
}
