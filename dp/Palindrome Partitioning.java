import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
   
            String s=sc.next();
            Integer pp[]=new Integer[s.length()];
   
            System.out.println(Partitioning(s,0,new ArrayList<>(),pp));
   
        }
   
    }
   
    public static int Partitioning(String qq,int i,List<String> ll,Integer pp[]){

        if(qq.length()==i){
            return -1;
   
        }
        if(pp[i]!=null)
		return pp[i];
   
        int aanns=Integer.MAX_VALUE;
        for (int cut = 1;i+ cut <= qq.length(); cut++) {
   
   
            String s=qq.substring(i,i+cut);
            if(isppl(s)){
   
                ll.add(s);
   
                aanns=Math.min(aanns,1+Partitioning(qq,i+cut,ll,pp));
   
                ll.remove(ll.size()-1);
            }
        }
   
        return pp[i]=aanns;
    }
    static boolean isppl(String s){
   
        int i=0,j=s.length()-1;
        while(i<j){
   
            if(s.charAt(i)!=s.charAt(j))
			return false;
   
            i++;j--;
   
   
        }
   
        return true;
   
    }
}