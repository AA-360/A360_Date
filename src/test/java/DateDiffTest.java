import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.samples.commands.basic.DateDiff;
import org.testng.annotations.Test;

public class DateDiffTest {
    @Test
    public void test(){
        DateDiff a = new DateDiff();
        NumberValue dif = a.action("dd-MM-yyyy","s","01-01-2020","02-01-2020");
        System.out.println("==================");
        System.out.println("Expected First Value: " + dif);
    }
}