class Email {
    String emailAddr;

    public Email() {
        this.emailAddr = "shindeyash@gmail.com";
    }

    public Email(String emailAddr) {
        this.emailAddr = emailAddr;
    }
}

class emailCheckCons {

    public static void main(String args[]) {

        Email e1 = new Email();
        System.out.println("Email: " + e1.emailAddr);
        validateEmail(e1.emailAddr);

        Email e2 = new Email("shindeyash12@gmail.com");
        System.out.println("Email: " + e2.emailAddr);
        validateEmail(e2.emailAddr);
    }

    private static void validateEmail(String emailAddr) {
        int emaillen = emailAddr.length();

        if (emailAddr.charAt(0) == '@' || emailAddr.charAt(emaillen - 1) == '@' || 
            emailAddr.charAt(0) == '.' || emailAddr.charAt(emaillen - 1) == '.') {
            System.out.println("Invalid Email Address");
        } 
        else if (emailAddr.indexOf('@') == -1 || emailAddr.indexOf('@') != emailAddr.lastIndexOf('@')) {
            System.out.println("Invalid Email Address");
        } 
        else if (emailAddr.indexOf('@') != -1 && emailAddr.substring(emailAddr.indexOf('@')).indexOf('.') == -1) {
            System.out.println("Invalid Email Address");
        } 
        else {
            System.out.println("Valid Email Address");
        }
    }
}
