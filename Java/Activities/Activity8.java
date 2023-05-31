class CustomException extends Exception {
    private String message = null;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {
    public static void main(String[] a){
        try {
            // Method call with correct input
            Activity8.exceptionTest("Printing check");
            // Method call with incorrect input
            Activity8.exceptionTest(null); // Exception is thrown here
            Activity8.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Message : " + mae.getMessage());
        }
    }

    static void exceptionTest(String s) throws CustomException {
        if(s == null) {
            throw new CustomException("String is null");
        } else {
            System.out.println(s);
        }
    }
}