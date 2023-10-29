import java.io.*;

public class Caesar {
    private static final int KEY = 4;

    public static void main(String[] args) {
        File infile = new File(args[0]);
        int c;
        char outputChar;
        int charValue;

        try{
            BufferedReader in = new BufferedReader(new FileReader(infile));
            BufferedWriter out = new BufferedWriter(new FileWriter("outfile"));
            while((c = in.read()) != -1) {
                if(c < 32 || c > 126){
                    outputChar = (char)c;
                    out.write(outputChar);
                }
                charValue = c + KEY;

                if(charValue > 126){
                    charValue = charValue -95;
                    outputChar = (char)charValue;
                } else if(charValue < 32){
                    charValue = charValue + 95;
                    outputChar = (char)charValue;
                } else {
                    outputChar = (char)charValue;
                }
                out.write(outputChar);
            }
            
            in.close();
            out.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
