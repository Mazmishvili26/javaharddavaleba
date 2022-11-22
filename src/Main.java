import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("info.txt");

        if (file.exists() == false){
            writeTxt write = new writeTxt();
            write.textWriter();
        }


        Server server = new Server();
        server.start();

        Client client = new Client();
        Thread thread = new Thread(client);
        thread.start();



    }
}