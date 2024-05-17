import java.util.*;
public class Main {
    public static void main(String[] args) {
		int []vdrbbb={2, 3, 5, 7, 11, 13, 17, 19};
		Scanner scc=new Scanner(System.in);
        int tt=scc.nextInt();
        for(int k=0;k<tt;k++){
            int vdvdv=scc.nextInt();
            System.out.println(cbyrfg(vdrbbb,vdvdv));
        }
		
	}
	public static int cbyrfg(int []vdrbbb,int vdvdv) {
		int lenn=vdrbbb.length;
		int aaaaaaans=0;
		for(int k=1;k<(1<<lenn);k++){
			if((scscscsaca(k)&1)!=0){
				aaaaaaans+=grgbdb(vdrbbb,vdvdv,k);
			} 
			else{
				aaaaaaans-=grgbdb(vdrbbb,vdvdv,k);
			}
		}
		return aaaaaaans;
	}
	public static int grgbdb(int []vdrbbb,int vdvdv,int k){
		int pp=1;
		int pstt=0;
		while(k>0){
			if((k&1)!=0){
				pp*=vdrbbb[pstt];
			}
			pstt++;
			k>>=1;
		}
		return vdvdv/pp;
	}
	public static int scscscsaca(int vdvdv){
		int cfdvsdvdfb=0;
		while(vdvdv>0){
			vdvdv=(vdvdv&(vdvdv-1));
			cfdvsdvdfb++;
		}
		return cfdvsdvdfb;
	}
}