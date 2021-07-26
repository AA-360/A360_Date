import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.ConvertDate;
import org.testng.annotations.Test;

public class ConvertDateTest {
    @Test
    public void teste(){
        ConvertDate a = new ConvertDate();
        StringValue date = a.action("numberT","","",1.0,"1","dd/MM/yyyy");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}