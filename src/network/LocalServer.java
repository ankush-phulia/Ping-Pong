package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitin on 24/4/16.
 */
public class LocalServer {
    ServerSocket myServer;
    List<Socket> clientSocket = new ArrayList<>();
    List<DataOutputStream> writingStreamClient = new ArrayList<>();
    List<SocketAddress> ip_address = new ArrayList<>();
    List<ReadData> inputStreamClient = new ArrayList<>();

    // Creates a new server with port no. 'port'
    // Throws IOException if unsuccessful
    public LocalServer(int port) throws IOException {
        myServer = new ServerSocket(port, 3);
        threadMessage("Server created on port " + myServer.getLocalPort());
    }


    // Establish connection with a new client
    // returns Socket Address of client
    public SocketAddress acceptClient() throws IOException {
        Socket waitingForClient = myServer.accept();
        clientSocket.add(waitingForClient);
        writingStreamClient.add(new DataOutputStream(waitingForClient.getOutputStream()));
        ip_address.add(waitingForClient.getRemoteSocketAddress());

        ReadData readFromClient = new ReadData(waitingForClient);
        inputStreamClient.add(readFromClient);
        Thread readThread = new Thread(readFromClient);
        readThread.start();

        threadMessage("Just connected to " + waitingForClient.getRemoteSocketAddress());
        return waitingForClient.getRemoteSocketAddress();
    }


    // writes 'writeData' to client with Socket Address 'ip_addr'
    // returns false if client is disconnected else true
    public boolean writeToClient (SocketAddress ip_addr, String writeData) {
        int position = ip_address.indexOf(ip_addr);
        DataOutputStream out = writingStreamClient.get(position);
        Socket client = clientSocket.get(position);

        try {
            out.writeUTF(writeData);
        }
        catch (IOException e) {
            e.printStackTrace();
            if (!client.isConnected()) {
                threadMessage("Client is disconnected...");
                // Client is disconnected. Take necessary steps here
                ip_address.remove(position);
                writingStreamClient.remove(position);
                clientSocket.remove(position);
                inputStreamClient.remove(position);
                return false;
            }
        }
        return true;
    }


    // writes 'writeData' to all clients
    // returns false if any client is disconnected else true
    public boolean writeToAllClients (String writeData) {
        boolean success = true;
        for (int position = 0; position < clientSocket.size(); position++) {
            DataOutputStream out = writingStreamClient.get(position);
            Socket client = clientSocket.get(position);

            try {
                out.writeUTF(writeData);
            }
            catch (IOException e) {
                e.printStackTrace();
                if (!client.isConnected()) {
                    threadMessage("Client is disconnected...");
                    // Client is disconnected. Take necessary steps here
                    ip_address.remove(position);
                    writingStreamClient.remove(position);
                    clientSocket.remove(position);
                    inputStreamClient.remove(position);

                    position--;
                    if (success)
                        success = false;
                }
            }
        }
        return success;
    }


    // reads data from client with Socket Address 'ip_addr'
    // returns null if no data is available
    public String readFromClient (SocketAddress ip_addr) {
        int position = ip_address.indexOf(ip_addr);
        ReadData rd = inputStreamClient.get(position);
        return  rd.readFromBuffer();
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
