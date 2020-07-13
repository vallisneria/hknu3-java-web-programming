package ch15_01;

import java.io.*;
import java.net.*;
import java.nio.Buffer;

public class DailyAdviceClient {
    public void go() {
        try {
            Socket s = new Socket("127.0.0.1", 4242);

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");

        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
