class RemDup{
    
    public static boolean[] map = new boolean[26];

    public static void removeDup(String str, int idx, String newStr){

        if(idx == str.length()){

            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a']){

            removeDup(str, idx+1, newStr);
        }
        else{

            newStr += currChar;
            map[currChar - 'a'] = true;
            removeDup(str, idx+1, newStr);
        }
    }
    public static void main(String[] args){

        String str = "abbcdaa";
        removeDup(str, 0, "");

    }
}