class Database {

    static int connectionCount = 0;
    static final int MAX_CONNECTIONS = 10;
    String databaseName;

    static {
        System.out.println("Database system initialized...");
        System.out.println("Maximum Connections Allowed: " + MAX_CONNECTIONS);
    }

    public Database(String databaseName) {
        this.databaseName = databaseName;
        connectionCount++;
    }

    public static void displayTotalConnections() {
        System.out.println("Total Connections: " + connectionCount);
    }

    public void connect() {

        if (connectionCount <= MAX_CONNECTIONS) {
            System.out.println(databaseName + " connected successfully.");
        } else {
            System.out.println("Connection limit exceeded!");
        }
    }

    
    public final void close() {
        System.out.println(databaseName + " connection closed.");
    }

    public static void main(String[] args) {

        System.out.println("Max connections allowed: " + Database.MAX_CONNECTIONS);

        Database db1 = new Database("MySQL");
        Database.displayTotalConnections();
        db1.connect();
        db1.close();

        System.out.println();

        Database db2 = new Database("PostgreSQL");
        Database.displayTotalConnections();
        db2.connect();
        db2.close();

        
    }
}