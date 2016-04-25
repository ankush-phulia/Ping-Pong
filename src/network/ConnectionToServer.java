package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by nitin on 24/4/16.
 */
public class ConnectionToServer {
    Socket clientSocket;
    DataOutputStream writingStream;
    ReadData readingStream;


    // Connect to a client with IP Address/Name 'inetAddr' & port no. 'port'
    // Throws IOException if unsuccessful
    public ConnectionToServer(String inetAddr, int port) throws IOException {
        clientSocket = new Socket(inetAddr, port);
        threadMessage("Connection established with " + clientSocket.getRemoteSocketAddress() +
                " on port " + clientSocket.getLocalPort());

        writingStream = new DataOutputStream(clientSocket.getOutputStream());
        readingStream = new ReadData(clientSocket);
        Thread readThread = new Thread(readingStream);
        readThread.start();
    }


    // writes 'writeData' to server
    // returns false if client is disconnected else true
    public boolean writeToServer (String writeData) {

        try {
            writingStream.writeUTF(writeData);
        }
        catch (IOException e) {
            e.printStackTrace();
            if (!clientSocket.isConnected()) {
                threadMessage("Server is disconnected...");
                // Server is disconnected. Take necessary steps here

                return false;
            }
        }
        return true;
    }


    // reads data from server
    // returns null if no data is available
    public String readFromClient () {
        return  readingStream.readFromBuffer();
    }


    /* For debugging purpose only.
     * Display a message, preceded by
     * the name of the current thread
     */
    private static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

}
