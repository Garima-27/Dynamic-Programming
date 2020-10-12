import java.util.*;
public class edit_distance 
{
	public static int min_oper(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int min[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0)
					min[i][j]=j;
				else if(j==0)
					min[i][j]=i;
				else if(s2.charAt(i-1)==s1.charAt(j-1))
					min[i][j]=min[i-1][j-1];
				else
					min[i][j]=Math.min(Math.min(min[i-1][j], min[i-1][j-1]), min[i][j-1])+1;
			}
		}
		print(s1,s2,min);
		return min[n][m];
	}
	public static void print(String s1,String s2,int min[][])
	{
		int m=s1.length();
		int n=s2.length();
		int i=n;
		for(int j=m;j>0 && i>0;)
			{
				if(min[i][j]==min[i-1][j-1] && s1.charAt(j-1)==s2.charAt(i-1))
				{
					i--;
					j--;
				}
				else
				{
					if(min[i][j]==(min[i-1][j-1]+1))
					{
						System.out.println(s1.charAt(j-1)+" is replaced by "+s2.charAt(i-1));
						i--;
						j--;
					}
					else if(min[i][j]==(min[i-1][j]+1))
					{
						System.out.println(s2.charAt(i-1)+" is added");
						i--;
					}
					else if(min[i][j]==(min[i][j-1]+1))
					{
						System.out.println(s1.charAt(j-1)+" is deleted");
						j--;
					}
				}
					
			}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println("Minimum operations required "+min_oper(s1,s2));
	}
}
