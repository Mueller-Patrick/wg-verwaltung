import java.util.Date;

public class DemoBean {

    public String username = "username";
    public int kontoguthaben = 100;
    public String vorname = "Max";
    public String nachname = "Mustermann";
    Date date;
    public String todo;

    public DemoBean(){
        date = new Date();
         todo = "Wisch raus du Alpaka!;Nico;"+date.toString()+";";
    }
}
