/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

/**
 *
 * @author sumatra
 */
import java.io.*;
import java.net.*;

class TCPClient {

    String sentence;
    String echo;
    private Socket clientSocket;

    public TCPClient() {
        try {
            this.clientSocket = new Socket("127.0.0.1", 6790);
            saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFile() throws IOException {
        /* Permite leitura de dados do teclado */
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        /* Cria uma stream de entrada para receber os dados do servidor */
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        /* Lê uma mensagem digitada pelo usuário */
        System.out.print("Digite uma menssagem: ");
        sentence = inFromUser.readLine();

        /* Envia para o servidor. Não esquecer do \n no final para permitir que o servidor use readLine */
        outToServer.writeBytes(sentence + '\n');

        /* Lê mensagem de resposta do servidor */
        echo = inFromServer.readLine();

        int filesize = Integer.valueOf(echo);

        System.out.println("Tamanho do arquivo: " + filesize);

        String fileName = "testfile2";

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

        FileOutputStream fos = new FileOutputStream("C:\\Arquivos para download\\" + fileName + ".png");
        byte[] buffer = new byte[1024];

        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }
        System.out.println("Acabou de receber");

        fos.close();
        dis.close();
    }

    public static void main(String[] args) {
        TCPClient fc = new TCPClient();
    }
}
