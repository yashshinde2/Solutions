class Book{

    String title;
    String author;
    int pages;

    public Book(String title, String author, int pages){

        this.title = title;
        this.author = author;
        this.pages = pages;

    }

    public Book(Book b2){

        this.title = b2.title;
        this.author = b2.author;
        this.pages = b2.pages;

    }

    public void displayBookInfo(){

        System.out.println("Title of book is :" + title);
        System.out.println("Author of book is :" + author);
        System.out.println("Pages of book are :" + pages );

    }

    public static void main(String[] args){

        Book b1 = new Book("Chhava", "Shivaji Sawant", 1100);
        b1.displayBookInfo();

        Book b2 = new Book(b1);
        b2.displayBookInfo();

        b2.title = "Chhava 2";
        b2.displayBookInfo();

    }

}