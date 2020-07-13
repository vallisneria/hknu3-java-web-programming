package ch15_01;

import java.io.*;
import java.net.*;

public class DailyAdviceServer {
    String[] adviceList = {"Take smaller bites", "Fo for the tight jeans. No they do NOT make you look fat",
            "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
            "You might want to rethink that haircut."};

    public void go() {
        try {
            ServerSocket serverSock = new ServerSocket(4242);

            while (true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int i = (int) (Math.random() * adviceList.length);
        return adviceList[i];
    }

    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");

        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
