abstract class LibraryItem{

    static final int incrementId = 0;
    private String title;
    private String author;
    private int year;
    public boolean isAvailable;
    private int totalItems;

    public LibraryItem(String title, String author, int year, boolean isAvailable, int incrementId){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
        this.incrementId++;
    }

    static int totalItems = 0;
    static int totalIssued = 0;

    abstract int getDueDate();
    
    public int issueItem(String item){

        
    }

}




class LibraryManagemnt{

    public static void main(String[] args){


    }
}