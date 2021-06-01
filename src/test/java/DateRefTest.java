import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.DateRef;
import org.testng.annotations.Test;

public class DateRefTest {
    @Test
    public void test(){
        DateRef a = new DateRef();
        StringValue date = a.action("dd-MM-yyyy hh:mm:ss","h",-1.0);
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}