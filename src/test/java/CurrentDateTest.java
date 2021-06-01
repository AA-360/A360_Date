import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.samples.commands.basic.CurrentDate;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationanywhere.botcommand.data.impl.StringValue;

import java.util.HashMap;
import java.util.Map;

public class CurrentDateTest {
    @Test
    public void teste(){
        CurrentDate a = new CurrentDate();
        StringValue date = a.action("dd/MM/yyyy hh:mm:ss");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}