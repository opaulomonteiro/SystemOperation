/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/**
 *
 * @author sumatra
 */
import java.io.*;
import java.net.*;

class TCPServer {

    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String echo;

        /* Cria socket do servidor */

        ServerSocket welcomeSocket = new ServerSocket(6790);

        while (true) {

            /* Aguarda o recebimento de uma conexão. O servidor fica aguardando neste ponto 
			 * até que nova conexão seja aceita. */
            Socket connectionSocket = welcomeSocket.accept();

            /* Cria uma stream de entrada para receber os dados do cliente */
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            /* Cria uma stream de saída para enviar dados para o cliente */
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            /* Aguarda o envio de uma mensagem do cliente. Esta mensagem deve ser terminada em \n ou \r 
			 * Neste exemplo espera-se que a mensagem seja textual (string). Para ler dados não textuais tente
			 * a chamada read() */
            clientSentence = inFromClient.readLine();

            File dir = new File("C:\\Arquivos para Download\\" + clientSentence);

            outToClient.writeBytes("Tamanho do arquivo desejado: " + dir.length());
            
            
            
//            File myFile = new File("E7060v1.2.zip");
//        byte[] mybytearray = new byte[(int) myFile.length()];
//         
//        FileInputStream fis = new FileInputStream(myFile);
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        bis.read(mybytearray, 0, mybytearray.length);
//         
//        OutputStream os = connectionSocket.getOutputStream();
//         
//        os.write(mybytearray, 0, mybytearray.length);
//         
//        os.flush();
            
            

//            try (
//                    FileInputStream inputStream = new FileInputStream(dir);
//                    OutputStream outputStream = new FileOutputStream(dir.getName())) {
//                byte[] buffer = new byte[BUFFER_SIZE];
//
//                while (inputStream.read(buffer) != -1) {
//                    outputStream.write(buffer);
//                }
//
//                inputStream.close();
//                outputStream.close();
//                
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }           

                /* Encerra socket do cliente */
                connectionSocket.close();
            }
        }
    }
