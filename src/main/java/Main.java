import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        String host = "localhost";
        //String host = "127.0.0.1";
        int port = 8093;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);  //выходной поток
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) { //входной

            out.println("Alice"); //отправляем одну строку "Netology"

            String  resp = in.readLine(); //читаем одну строку "Netology"
            System.out.println(resp); // вывод на экран и завершение работы
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
