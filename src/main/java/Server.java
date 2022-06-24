import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8888;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Hello! Write your name");
            String name = in.readLine();
            out.println("Are you child? (yes/no)");

            String answerForKids = "Welcome to the kids area, " + name + "! Let's play!";
            String answerForAdult = "Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!";

            while (true) {
                String request = in.readLine();
                if (request.equals("yes") || request.equals("no")) {
                    out.println((request.equals("yes")) ? answerForKids : answerForAdult);
                    break;
                } else {
                    out.println("Incorrect input. May check register?");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
