package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Date;
import java.sql.SQLData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utilities {
    //Função utilizada para copiar uma imagem de um local para outro, e retornar o novo caminho
    public String copiaImagem(String sImagem, String sDiretorio) throws FileNotFoundException, IOException {
        //Exemplo de diretório: /src/images/Distribuidoras/
        String[] sArray = sImagem.split("\\\\");
        String sNomeArquivo = sArray[sArray.length-1];
        FileInputStream origem;   
        FileOutputStream destino;  
  
        FileChannel fcOrigem;  
        FileChannel fcDestino;  
        
        //Arquivo a ser copiado
        origem = new FileInputStream(sImagem);
        
        //Local onde irá ficar a cópia do arquivo
        destino = new FileOutputStream(System.getProperty("user.dir") + sDiretorio + sNomeArquivo);
  
        fcOrigem = origem.getChannel();  
        fcDestino = destino.getChannel();  
  
        //Copia o arquivo e salva no diretório especificado
        fcOrigem.transferTo(0, fcOrigem.size(), fcDestino); 
  
        origem.close();  
        destino.close();  
        
        return (sDiretorio+sNomeArquivo);
    }
    
    //Função utilizada para converter uma sting para um SQL Date
    public Date converteData(String sData) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        java.util.Date dataJava = df.parse(sData);  
        java.sql.Date dataSql = new Date(dataJava.getTime());  
        return dataSql;
    }
    
    //Função para passar a data de "YYYY-MM-DD" para "DD-MM-YYYY"
    public String ajustaData (Date dData) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        String sData = df.format(dData);
        return sData;
    }
}
