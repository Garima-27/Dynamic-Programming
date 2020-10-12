import java.util.*;
import java.math.*;
public class longestCommonSubsequence 
{
	public static int length_sub(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int l[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
					l[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					l[i][j]=l[i-1][j-1]+1;
				else
					l[i][j]=Math.max(l[i-1][j], l[i][j-1]);
			}
		}
		print(s1,s2,l);
		return l[m][n];
	}
	public static void print(String s1,String s2,int l[][])
	{
		int m=s1.length();
		int n=s2.length();
		int i=m;
		StringBuilder ans=new StringBuilder();
			for(int j=n;j>0 && i>0;)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					ans=ans.append(s1.charAt(i-1));
					i--;
					j--;
				}
					
				else
				{
					if(l[i-1][j]>l[i][j-1])
						i--;
					else
						j--;
				}
			}
		System.out.println("Subsequence is "+ans.reverse());
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println("Length of longest common subsequence is "+length_sub(s1,s2));
		
	}
}
