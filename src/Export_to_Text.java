import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class Export_to_Text {
    public void Export_to_Text(String inputExpression, BigDecimal answer) throws IOException {
        FileWriter fileWriter = new FileWriter("EXPORTED_EXPRESSIONS.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Double answerDouble = answer.doubleValue();

        System.out.println("Beginning Save...");

        printWriter.println();
        printWriter.println(inputExpression);
        printWriter.println(answerDouble);
        printWriter.println();

        System.out.println("Save Completed, closing...");

        fileWriter.close();
        bufferedWriter.close();
        printWriter.close();
    }
}
