package model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utilities {
    //Função utilizada para copiar uma imagem de um local para outro, e retornar o novo caminho
    public String copiaImagem(String sImagem, String sDiretorio) {
        if (!sImagem.trim().isEmpty()) {
            System.out.println(sImagem);
            System.out.println(sDiretorio);
            //Exemplo de diretório: /src/images/Distribuidoras/
            String[] sArray = sImagem.split("\\\\");
            String sNomeArquivo = sArray[sArray.length-1];
            FileInputStream origem;   
            FileOutputStream destino;  

            FileChannel fcOrigem;  
            FileChannel fcDestino;  

            try {
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
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao copiar imagem", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao copiar imagem", JOptionPane.ERROR_MESSAGE);
            }

            return (sDiretorio+sNomeArquivo);
        }
        return null;
    }
    
    //Função utilizada para converter uma sting para um SQL Date
    public Date converteData(String sData) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        java.util.Date dataJava;  
        try {
            dataJava = df.parse(sData);
            java.sql.Date dataSql = new Date(dataJava.getTime());  
            return dataSql;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao converter data de fundação", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    //Função para passar a data de "YYYY-MM-DD" para "DD-MM-YYYY"
    public String ajustaData (Date dData) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        String sData = df.format(dData);
        return sData;
    }
    
    //Função utilizada para criar pasta
    public File criaPasta (String CaminhoNome) {
        //Caminho + Nome da pasta. Exemplo: src/images/Jogos/
        File diretorio = new File(System.getProperty("user.dir") + "/" + CaminhoNome);
        
        //Cria todos os diretórios e subdiretórios
        diretorio.mkdirs();
        
        return diretorio;
    }
    
    //Função utilizada para centralizar um JFrame
    public void centralizarFrame (JFrame obj) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        obj.setLocation(dimension.width/2-obj.getSize().width/2, dimension.height/2-obj.getSize().height/2);
    }
    
    //Função utilizada para centralizar um JDialog
    public void centralizarDialog (JDialog obj) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        obj.setLocation(dimension.width/2-obj.getSize().width/2, dimension.height/2-obj.getSize().height/2);
    }
    
    //Função utilizada para incluir um ícone na tela
    public Image adicionarIcone (String sIcone) {
        return (Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + sIcone));
    }
}
