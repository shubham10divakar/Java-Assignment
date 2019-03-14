import java.util.*;
public class UpGrad {

	static String ar[],name[],cgpa[];
	static int token[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n,i;
		n=in.nextInt();
		ar=new String[n];
		name=new String[n];
		cgpa=new String[n];
		token=new int[n];
		in.nextLine();
		int ctr=0;
		for(i=0;i<n;i++)
		{
			ar[i]=in.nextLine();
			if(ar[i].equals("SERVED"))
			{
				name[i]="SERVED";
				cgpa[i]="-100";
				token[i]=-123;
				ctr++;
			}
			else
			{
				int p1=ar[i].indexOf(' ',6);
				name[i]=ar[i].substring(6,p1);
				//int p2=ar[i].indexOf(' ',p1);
				//System.out.println(p1+"--"+p2);
				cgpa[i]=ar[i].substring(p1+1);
				token[i]=getRandomNumberInRange(1,100);
			}
		}
		if(ctr==n-1)
		{
			System.out.println("EMPTY");
		}
		else
		{
			sort();
		}
		for(i=0;i<n;i++)
		{
			System.out.println(name[i]+"--"+cgpa[i]+"--"+token[i]);
		}
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	private static String[] sort() {
		int l=cgpa.length;
		int i,j,temp3;
		String temp;
		for(i=0;i<l;i++)
		{
			for(j=0;j<l-1-i;j++)
			{
				double n1=Double.parseDouble(cgpa[j]);
				double n2=Double.parseDouble(cgpa[j+1]);
				if(n1<n2)
				{
					temp=cgpa[j];
					cgpa[j]=cgpa[j+1];
					cgpa[j+1]=temp;
					
					temp=name[j];
					name[j]=name[j+1];
					name[j+1]=temp;
					
					temp3=token[j];
					token[j]=token[j+1];
					token[j+1]=temp3;
				}
				else if(n1==n2)
				{
					if(name[j].compareTo(name[j+1])<0)
					{
						temp=cgpa[j];
						cgpa[j]=cgpa[j+1];
						cgpa[j+1]=temp;
						
						temp=name[j];
						name[j]=name[j+1];
						name[j+1]=temp;
						
						temp3=token[j];
						token[j]=token[j+1];
						token[j+1]=temp3;
					}
					else if(name[j].compareTo(name[j+1])==0)
					{
						if(token[j]<token[j+1])
						{
							temp=cgpa[j];
							cgpa[j]=cgpa[j+1];
							cgpa[j+1]=temp;
							
							temp=name[j];
							name[j]=name[j+1];
							name[j+1]=temp;
							
							temp3=token[j];
							token[j]=token[j+1];
							token[j+1]=temp3;
						}
					}
				}
			}
		}
		return ar;
	}

}
