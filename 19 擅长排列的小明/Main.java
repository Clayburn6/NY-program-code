/*
擅长排列的小明
时间限制：1000 ms  |  内存限制：65535 KB
难度：4
描述
小明十分聪明，而且十分擅长排列计算。比如给小明一个数字5，他能立刻给出1-5按字典序的全排列，如果你想为难他，在这5个数字中选出几个数字让他继续全排列，那么你就错了，他同样的很擅长。现在需要你写一个程序来验证擅长排列的小明到底对不对。
输入
第一行输入整数N（1<N<10）表示多少组测试数据，
每组测试数据第一行两个整数 n m (1<n<9,0<m<=n)
输出
在1-n中选取m个字符进行全排列，按字典序全部输出,每种排列占一行，每组数据间不需分界。如样例
样例输入
2
3 1
4 2
样例输出
1
2
3
12
13
14
21
23
24
31
32
34
41
42
43
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			permutation("", n, m);
		}
		sc.close();
	}
	// 使用回溯进行全排列
	public static void permutation(String str, int n, int m) {
		if (m == 0)
		{
			System.out.println(str);
		}
		else {
			for (int i = 1; i <= n; i++)
			{
				if (str.indexOf("" + i) < 0)
				{
					str += i;
					permutation(str, n, m-1);
					str = str.substring(0, str.length()-1);
				}
			}
		}
	}
}