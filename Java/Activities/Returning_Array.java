public class Returning_Array {


        public static void main(String[] args) {
            String[] carMake = returnArray();
            for(int i = 0; i<=carMake.length-1; i++){
                System.out.println( carMake[i] );
            }
        }

        //This method returns an Array of type String
        public static String[] returnArray() {
            String [] carArray = {"BMW","AUDI","TOYOTA","SUZUKI","HONDA"};
            return carArray;
        }

}
