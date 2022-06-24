import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String Ip = "netology.homework";
        int port = 8888;

        try (Socket clientSocket = new Socket(Ip, port);
             Scanner scanner = new Scanner(System.in);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());
            out.println(scanner.nextLine());

            while(true) {
                String response = in.readLine();
                if (response.contains("Welcome")) {
                    System.out.println(response);
                    break;
                } else {
                    System.out.println(response);
                    out.println(scanner.nextLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
