import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.ConvertDate;
import com.automationanywhere.botcommand.samples.commands.basic.WorkingDays;
import com.automationanywhere.botcommand.samples.commands.utils.Uteis;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConvertDateTest {

    @Test
    public void mesa2(){
        WorkingDays a = new WorkingDays();

        List<Value> holidays = new ArrayList<>();
        //List<Date> DtFeriados = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        holidays.add(new StringValue("2021-09-03"));
        holidays.add(new StringValue("2021-09-06"));

        Value dat = a.action("date","2021-09-01","yyyy-MM-dd",2.0,true,false,true,holidays,"yyyy,MM,dd");
        System.out.println("date:" + dat);


    }

    public void mesa(){
        List<String> feriados = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        feriados.add("2021-09-05");
        feriados.add("2021-09-05");

        Date date1 = Uteis.StringToDate("2021-09-02","yyyy-MM-dd");
        cal.setTime(date1);

        Integer days = 11;

        while(days>0){
            cal.add(Calendar.DATE,1);
            int dayOfWeek  = cal.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == 7 || dayOfWeek == 1){
                continue;
            }
            days --;
        }

        String strDate = Uteis.DateToString(cal.getTime(),"yyyy-MM-dd");
        System.out.println("date:" + strDate);

    }


    public void teste(){
        ConvertDate a = new ConvertDate();
        String out = "EE";
        StringValue date = a.action("today",null,null,null,null,out);
        //StringValue date = a.action("today","01/01/2020",null,"dd/MM/yyyy");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}