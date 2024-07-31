import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileNameExport {

    public static ArrayList<String> folderToName(String path) {
        ArrayList<String> Dlist = new ArrayList<String>();
        File mapa = new File(path);
        for (File datoteka : mapa.listFiles()) {
            Dlist.add(datoteka.getName());
        }
        return Dlist;
    }
    public static void GenExportFile(ArrayList<String> Dlist, String pathTxt) throws IOException{
        FileWriter fw = new FileWriter(new File(pathTxt), StandardCharsets.UTF_8);
        for (String d : Dlist) {
           fw.write("-"+d+"\n"); 
         }
         fw.close();
         System.out.println("The file has been generated!");
    }
    public static void ListExport(ArrayList<String> Dlist){
        System.out.println("Contents of the directory : ");
        for (String d : Dlist) {
           System.out.println("-"+d); 
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        String path, exportS, pathTxt;

        System.out.println("Directory path: ");
        path = in.nextLine();

        System.out.println("Would you like to generate a text file with the contents of the directory? (y/n): ");
        exportS = in.nextLine();

        if (exportS.toLowerCase().equals("y")) {
            System.out.println("Insert path of where to save the generated text file: ");
            pathTxt = in.nextLine();
            GenExportFile(folderToName(path), pathTxt);
        }else{
            ListExport(folderToName(path));
        }
        in.close();
    }
}
