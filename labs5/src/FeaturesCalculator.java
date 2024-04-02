import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class FeaturesCalculator {

    private final ArrayList<ArrayList<Integer>> binary_mask;
    private final Integer[] mass_center;
    private final String filename;

    public FeaturesCalculator(String filename) {
        this.filename = filename;
        this.binary_mask = new ArrayList<>();
        this.mass_center = new Integer[2];
    }

    public void read_data() throws FileNotFoundException {

        File fileHandle = new File(filename);
        Scanner reader = new Scanner(fileHandle);

        while (reader.hasNextLine()){
            String data = reader.nextLine();
            String[] values = data.split(" ");
            ArrayList<Integer> row = new ArrayList<>();
            for (String value : values) {
                row.add(Integer.parseInt(value));
            }
            binary_mask.add(row);
        }
        reader.close();
    }

    public void calculate_mass_center() {
        int Xsum = 0, Ysum = 0, count = 0;
        for (int i = 0; i < binary_mask.size(); i++) {
            for (int j = 0; j < binary_mask.get(i).size(); j++) {
                if (binary_mask.get(i).get(j) == 1) {
                    Xsum += i;
                    Ysum += j;
                    count++;
                }
            }
        }

        mass_center[0] = Math.round((float)Xsum / count);
        mass_center[1] = Math.round((float)Ysum / count);

    }

    public void save_results() throws IOException {
        FileWriter file = new FileWriter(filename.replace(".txt", "_out.txt"));
        for (int i = 0; i < binary_mask.size(); i++) {
            for (int j = 0; j < binary_mask.get(i).size(); j++) {
                if(i == mass_center[0] && j == mass_center[1]){
                    file.write("P ");
                }
                else {
                    file.write(binary_mask.get(i).get(j) == 0 ? "0 ": "1 ");
                }
            }
            file.write("\n");
        }
        file.close();
        System.out.println(STR."Wyniki zostały zapisane do pliku \{filename.replace(".txt", "_out.txt")}");
    }

    public static void main(String[] args) throws IOException {
        var program = new FeaturesCalculator(new Scanner(System.in).nextLine());
        program.read_data();
        program.calculate_mass_center();
        program.save_results();
    }

}

//Проверку на то введена ли правильно название файла
// +- корректировка
//C:\Users\Oleksandr\Desktop\laboratorium5\labs5\data\binary_mask_1.txt