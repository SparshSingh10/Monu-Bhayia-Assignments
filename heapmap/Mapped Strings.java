import java.util.*;
public class Main {
    public static void main(String[] args) {
     
	    Scanner sc = new Scanner(System.in);
     
	    String num1 = sc.next();
        HashMap<Integer, String> map = new HashMap<>();
     
	    for (int i=1;i<=26;i++) {
     
	        map.put(i,(char)(i+64)+"");
     
	    }
     
	    strings(num1,map,"");
    
	}

    private static void strings(String num1, HashMap<Integer, String> map, String ans) {
    
	    if (num1.length()==0) {
    
	        System.out.println(ans);
    
	        return;
    
	    }
        char ch = num1.charAt(0);
    
	    String s = map.get(ch-'0');
    
	    strings(num1.substring(1), 
		map, ans + s);
    
	    if (num1.length() >= 2) {
    
	        String str1 = num1.substring(0, 2);
            int n = Integer.parseInt(str1);
    
	        if (n <= 27) {
    
	            strings(num1.substring(2), map, ans + map.get(n));
    
	        }
    
	    }
    
	}
}

