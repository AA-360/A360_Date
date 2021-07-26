import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.ConvertDate;
import org.testng.annotations.Test;

public class ConvertDateTest {
    @Test
    public void teste(){
        ConvertDate a = new ConvertDate();
        StringValue date = a.action("today",null,null,null,null,"dd/MM/yyyy");
        //StringValue date = a.action("today","01/01/2020",null,"dd/MM/yyyy");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}