public class Activity5 {
    public static void main(String []args) {

        String title = "New Novel Name";
        Book newNovel = new myBook();
        newNovel.setTitle(title);

        System.out.println("The title is: " + newNovel.getTitle());
    }
}

abstract class Book {
    String bookTitle;
    abstract void setTitle(String bookTitle);

    String getTitle() {
        return bookTitle;
    }

}

class myBook extends Book {
    public void setTitle(String s) {
        bookTitle = s;
        }

        }