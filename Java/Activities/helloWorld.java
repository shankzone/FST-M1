import java.util.Locale;

public class helloWorld {


    public static void main(String[] args) {
        String myname = "Shashank";
        System.out.println(myname.toLowerCase(Locale.ROOT));

        String txt = "This phrase uses the phrase 'phrase' a lot!";
        System.out.println(txt.indexOf("phrase")); // Outputs 5


        String firstName = "John ";
        String lastName = "Doe";
        System.out.println(firstName.concat(lastName)); // Outputs "John Doe"




    }


}
