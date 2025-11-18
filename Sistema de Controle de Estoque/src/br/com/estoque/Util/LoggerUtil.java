package br.com.estoque.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {
    public static void registraErro(String erro){
        try(FileWriter writer = new FileWriter("erro.log", true)){
            writer.write(LocalDateTime.now() + " - "+ erro + "\n");
        }catch (IOException e){
            System.out.println("Erro ao escrever no log: "+ e.getMessage());
        }
    }
}
