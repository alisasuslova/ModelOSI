import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("server started");
        int port = 8093; // можно выбрать любой из диапазона 0 -65536. Лучше от 8080 и более.

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port); //создаем сервер
            Socket clientSocket = serverSocket.accept(); // ждем подключения клиента, при подключении создается клиентский сокет
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //выходной поток, в котором мы можем клиенту ответить
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //входной поток. здесь получаем данные от клиента на транспортном уровне

            System.out.printf("New connection accepted. Port %d%n", clientSocket.getPort()); // выводит порт, на который подключился клиентский сокет

            final String name = in.readLine(); // читаем то, что отправил нам клиент
            out.println(String.format("Hi %s, you port is %d", name, clientSocket.getPort())); //вывод на экран
            serverSocket.close(); //закрываем подключение

        }



    }
}
