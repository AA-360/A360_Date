import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.DateCalc;
import org.testng.annotations.Test;

public class DateRefTest {
    @Test
    public void test(){
        DateCalc a = new DateCalc();
        StringValue date = a.action("date","01/01/2021","DD/MM/yyyy","dd-MM-yyyy HH:mm:ss","d",-1.0);
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}