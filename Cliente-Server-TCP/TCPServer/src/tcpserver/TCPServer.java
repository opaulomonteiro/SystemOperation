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
import java.util.logging.Level;
import java.util.logging.Logger;

class TCPServer extends Thread {

    private Socket clientSock;
    String clientSentence;
    String echo;

    public TCPServer(Socket clientSock) {
        this.clientSock = clientSock;
    }

    public void run() {
        while (true) {
            try {
                sendFile(clientSock);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendFile(Socket clientSock) throws IOException, InterruptedException {
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));

        /* Cria uma stream de saída para enviar dados para o cliente */
        DataOutputStream outToClient = new DataOutputStream(clientSock.getOutputStream());

        /* Aguarda o envio de uma mensagem do cliente. Esta mensagem deve ser terminada em \n ou \r 
			 * Neste exemplo espera-se que a mensagem seja textual (string). Para ler dados não textuais tente
			 * a chamada read() */
        clientSentence = inFromClient.readLine();

        FileInputStream fis = new FileInputStream("C:\\Arquivos para Download\\" + clientSentence);

        InputStream is = new BufferedInputStream(fis);

        System.out.println("tamanho do arquivo: " + fis.getChannel().size() + "\n");
        outToClient.writeBytes("" + fis.getChannel().size() + "\n");

        int filesize = (int) fis.getChannel().size();

        byte[] buffer = new byte[1024];

        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while ((read = fis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            Thread.sleep(100);
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            outToClient.write(buffer, 0, read);
            Thread.sleep(100);
        }
        System.out.println("Acabou de enviar");

        fis.close();
        outToClient.close();
    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6790);
            while (true) {
                Socket clientSocket = ss.accept();
                TCPServer server = new TCPServer(clientSocket);
                server.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
