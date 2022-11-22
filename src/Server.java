import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Server extends Thread{


        Socket socket;
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;
        String txt;

        String[] arr = {"help","date","name","error"};

        public void run() {
            try {

                // ObjectInputStream
                ServerSocket serverSocket = new ServerSocket(8080);
                while (true) {
                    socket = serverSocket.accept();
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    String message = (String) inputStream.readObject();
                    System.out.println("S -> " + message);

                    if (Arrays.asList(arr).contains(message)){
                        File reader = new File("info.txt");
                        Scanner fileScan = new Scanner(reader);
                        while (fileScan.hasNextLine()) {
                            String line = fileScan.nextLine();
                            if (line.contains(message)){
                                outputStream = new ObjectOutputStream(socket.getOutputStream());
                                String serverSide = fileScan.nextLine();
                                System.out.println("Server: " + serverSide);
//                                System.out.println(fileScan.nextLine());
                                outputStream.writeObject(serverSide);
                            }
                        }
                    }else {
                        // ObjectOutputStream
                        outputStream = new ObjectOutputStream(socket.getOutputStream());
                        System.out.print("Server: ");
                        Scanner scan = new Scanner(System.in);
                        txt = scan.nextLine();
                        outputStream.writeObject(txt);
                    }


                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

}
