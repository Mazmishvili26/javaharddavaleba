import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    Socket socket;
    ObjectOutputStream outputStream;
    String txt;


    ObjectInputStream inputStream;

    @Override
    public void run() {
        while (true) {
            try {
                // ObjectOutputStream
                socket = new Socket(InetAddress.getByName("localhost"), 8080);
                System.out.print("Client: ");
                Scanner scan = new Scanner(System.in);
                txt = scan.nextLine();
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(txt);

                // ObjectInputStream
                inputStream = new ObjectInputStream(socket.getInputStream());
                System.out.println("C -> " + inputStream.readObject());

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
