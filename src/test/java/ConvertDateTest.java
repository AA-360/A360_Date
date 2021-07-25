import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.ConvertDate;
import org.testng.annotations.Test;

public class ConvertDateTest {
    @Test
    public void teste(){
        ConvertDate a = new ConvertDate();
        StringValue date = a.action("date","dd/MM/yyyy","ddMMyyyy","01/07/2021");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}