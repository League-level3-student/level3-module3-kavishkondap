package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	StringBuilder b = new StringBuilder (str);
        return b.append (characters).toString();
    }
    
    public static String reverse(String str) {
    	StringBuilder b = new StringBuilder (str);
        return b.reverse().toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder b = new StringBuilder (str);
        return b.insert(index, newChar).toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder b = new StringBuilder (str);
        return b.delete(startIndex, endIndex).toString();
    }
}