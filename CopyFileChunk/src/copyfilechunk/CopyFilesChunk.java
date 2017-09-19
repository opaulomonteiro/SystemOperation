/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copyfilechunk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author 10084906
 */
public class CopyFilesChunk {
    private static final int BUFFER_SIZE = 4096; // 4KB
 
    public static void main(String[] args) {
       
       // String inputFile = args[0];
        String outputFile = "teste";

            
            File file = new File("C:\\Arquivos para Download\\TP1.pdf");
            
            
           System.out.println("Tamanho do arquivo"file.length()); ;
//        try (
//            InputStream inputStream = new FileInputStream(file);
//            OutputStream outputStream = new FileOutputStream(outputFile);
//        ) {
// 
//            byte[] buffer = new byte[BUFFER_SIZE];
// 
//            while (inputStream.read(buffer) != -1) {
//                outputStream.write(buffer);
//            }
//            
//            inputStream.close();
//            outputStream.close();
// 
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
}
