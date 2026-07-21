class Email {

    String emailAddr;

    public Email() {
        this.emailAddr = "shindeyash@gmail.com";
    }
}

class emailCheck {

    public static void main(String args[]) {

        Email e = new Email();
        System.out.println(e.emailAddr);

        int emaillen = e.emailAddr.length();

        if (e.emailAddr.charAt(0) == '@' || e.emailAddr.charAt(emaillen - 1) == '@' || 
            e.emailAddr.charAt(0) == '.' || e.emailAddr.charAt(emaillen - 1) == '.') {
            System.out.println("Invalid Email Address");
        } 
     
        else if (e.emailAddr.indexOf('@') == -1 || e.emailAddr.indexOf('@') != e.emailAddr.lastIndexOf('@')) {
            System.out.println("Invalid Email Address");
        } 
    
        else if (e.emailAddr.indexOf('@') != -1 && e.emailAddr.substring(e.emailAddr.indexOf('@')).indexOf('.') == -1) {
            System.out.println("Invalid Email Address");
        } 
        else {
            System.out.println("Valid Email Address");
        }
    }
}


