import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {

        return hamletData;
    }
    public String changeHamletToLeon(){
        Pattern pattern = Pattern.compile("[hH][aA][mM][lL][eE][tT]");
        Matcher matcher = pattern.matcher(hamletData);
        boolean matchFound = matcher.find();
        String newPoem = hamletData;
        if(matchFound) {
            newPoem = matcher.replaceAll("Leon");
        }

        return newPoem;
    }
    public String changeHoratioToTariq(){
        Pattern pattern = Pattern.compile("[hH][oO][rR][aA][tT][iI][oO]");
        Matcher matcher = pattern.matcher(hamletData);
        boolean matchFound = matcher.find();
        String newPoem = hamletData;
        if (matchFound) {
            newPoem = matcher.replaceAll("Tariq");
        }


        return newPoem;
    }
    public String findHoratio(){
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Horatio");
        boolean matchFound = matcher.find();
        String newPoem = hamletData;
        if (matchFound) {
            newPoem = pattern.pattern();
        }


        return newPoem;
    }


    public Boolean findHamlet(){
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Hamlet");
        boolean matchFound = matcher.find();

        return matchFound;

    }



}
