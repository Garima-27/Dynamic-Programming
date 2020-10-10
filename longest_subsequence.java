import java.util.*;
public class longest_subsequence 
{
	public static void list(int a[],int lis[],int index)
	{
		ArrayList<Integer> ar=new ArrayList<Integer>();
		ar.add(a[index]);
		int j=index;
		for(int i=index-1;i>=0;i--)
		{
				if(a[i]<ar.get(ar.size()-1) && lis[i]==(lis[j]-1))
				{
					ar.add(a[i]);
					j=i;
				}
		}
		Collections.sort(ar);
		System.out.print(ar);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),max=1,index=0;
		int a[]=new int[n];
		int lis[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			lis[i]=1;
		}
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i] && lis[j]+1>lis[i])
					lis[i]=lis[j]+1;
			}
			if(max<lis[i])
			{
				max=lis[i];
				index=i;
			}
				
		}
		System.out.println("Length of longest increasing subsequence is "+max);
		list(a,lis,index);
	}
}
