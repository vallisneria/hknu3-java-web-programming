package ch03_03_01;

class Books {
    String title;
    String author;
}

public class BooksTestDrive {
    public static void main(String[] args) {
        Books[] myBooks = new Books[3];

        // 추가한 부분
        for (int i = 0; i < myBooks.length; i++) {
            myBooks[i] = new Books();
        }
        // 여기까지

        int x = 0;
        myBooks[0].title = "The Grapes of Java";
        myBooks[1].title = "The Java Gatsby";
        myBooks[2].title = "The Java Cookbook";
        myBooks[0].author = "Bob";
        myBooks[1].author = "Sue";
        myBooks[2].author = "Ian";

        while (x < 3) {
            System.out.print(myBooks[x].title);
            System.out.print(" by ");
            System.out.println(myBooks[x].author);
            x = x + 1;
        }
    }
}
