package utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SaveToCsv {

    public static void saveToCsv(List<String> data) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "target/save_to_csv/output_" + timestamp + ".csv";

        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String row = String.join(",", data);

            writer.write(row);
            writer.newLine();
            System.out.println("Saved in file: " + filename);
        }
    }
}
