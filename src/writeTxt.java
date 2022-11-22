import java.io.FileWriter;
import java.io.IOException;

public class writeTxt {

    public void textWriter() {


        String txt1 = "help\nrashi dagexmaro?\n----\n";
        String txt2 = "date\ndges aris 16 noemberi\n----\n";
        String txt3 = "name\nme mqvia irakli\n----\n";
        String txt4 = "error\nError 404 Not Found\n----\n";


        String fullString = txt1 + txt2 + txt3 + txt4;
        FileWriter writer;

        {
            try {
                writer = new FileWriter("info.txt");
                writer.write(fullString);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
