import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int t = sc.nextInt();
        Pair[] arr = new Pair[t];
        for (int i = 0; i < t; i++) {
            String name = sc.next();
            int salary = sc.nextInt();
            arr[i] = new Pair(name, salary);
        }
        game(arr, x);
    }
	public static void game(Pair[] arr, int x){
		ArrayList<Pair>list =new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			if(arr[i].salary<x){
				continue;
			}
			list.add(arr[i]);
		}
		Collections.sort(list,new Comparator<Pair>(){
			// @Override
			public int compare(Pair o1,Pair o2){
				return o1.name.compareTo(o2.name);
			}
		});
		  Collections.sort(list, new Comparator<Pair>() {
				// @Override
			public int compare(Pair o1,Pair o2){
				return o2.salary-o1.salary;
			}
		});
		for(int i=0;i<list.size();i++){
			Pair p=list.get(i);
			System.out.println(p.name+" "+p.salary);
		}
	}
	static class Pair{
		String name;
		int salary;
		public Pair(){

		}
		public Pair(String name,int salary){
			this.name=name;
			this.salary=salary;
		}
	}
}
