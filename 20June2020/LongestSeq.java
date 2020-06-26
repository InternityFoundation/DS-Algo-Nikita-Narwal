import java.util.Scanner;

public class LongestSeq
{
  int LCS( char[] n1, char[] n2, int m, int n )
  {
    int seq[][] = new int[m+1][n+1];
    for (int i=0; i<=m; i++)
    {
      for (int j=0; j<=n; j++)
      {
        if (i == 0 || j == 0)
            seq[i][j] = 0;
        else if (n1[i-1] == n2[j-1])
            seq[i][j] = seq[i-1][j-1] + 1;
        else
            seq[i][j] = max(seq[i-1][j], seq[i][j-1]);
      }
    }
  return seq[m][n];
  }
  int max(int a, int b)
  {
    return (a > b)? a : b;
  }

  public static void main(String[] args)
  {
	LongestSeq l1 = new LongestSeq();
	Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    char[] n1=s1.toCharArray();
    char[] n2=s2.toCharArray();
    int m = n1.length;
    int n = n2.length;

    System.out.println(l1.LCS( n1, n2, m, n ));
    sc.close();
  }

}
