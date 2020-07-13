import java.io.*;
import java.net.*;
import java.util.*;

public class MusicServer {
    ArrayList clientOutputStream;

    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");
        System.out.println("Music Server Start");
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket socket;

        public ClientHandler(Socket clientSocket) {
            try {
                socket = clientSocket;
                in = new ObjectInputStream(socket.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            Object o1, o2;

            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();
                    tellEveryone(o1, o2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void go() {
        clientOutputStream = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStream.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(Object one, Object two) {
        Iterator it = clientOutputStream.iterator();
        while (it.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) it.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}