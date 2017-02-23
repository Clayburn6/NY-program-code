/*
吝啬的国度
时间限制：1000 ms  |  内存限制：65535 KB
难度：3
描述
在一个吝啬的国度里有N个城市，这N个城市间只有N-1条路把这个N个城市连接起来。现在，Tom在第S号城市，他有张该国地图，他想知道如果自己要去参观第T号城市，必须经过的前一个城市是几号城市（假设你不走重复的路）。
输入
第一行输入一个整数M表示测试数据共有M(1<=M<=5)组
每组测试数据的第一行输入一个正整数N(1<=N<=100000)和一个正整数S(1<=S<=100000)，N表示城市的总个数，S表示参观者所在城市的编号
随后的N-1行，每行有两个正整数a,b(1<=a,b<=N)，表示第a号城市和第b号城市之间有一条路连通。
输出
每组测试数据输N个正整数，其中，第i个数表示从S走到i号城市，必须要经过的上一个城市的编号。（其中i=S时，请输出-1）
样例输入
1
10 1
1 9
1 8
8 10
10 3
8 6
1 2
10 4
9 5
3 7
样例输出
-1 1 10 10 9 8 3 1 1 8
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main
{
	private static List<Integer>[] tree;	// 用于生成图
	private static boolean[] visited;	// visited[i]表示城市i是否已经遍历过
	private static int[] must; // must[i]表示到达i城市必须要经过的城市

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 测试数据组数
		while (M-- > 0)
		{
			// 初始化
			int N = sc.nextInt(); // 有N个城市
			int S = sc.nextInt()-1; // 参观者所在城市编号
			tree = new ArrayList [N];
			for (int i = 0; i < tree.length; i++)
			{
				tree[i] = new ArrayList<Integer>();
			}
			visited = new boolean [N];
			must = new int [N];
			must[S] = -1;
			// 构造图
			// tree[i]表示所有与城市i相连的城市
			for (int i = 0; i < N-1; i++)
			{
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				tree[a].add(b);
				tree[b].add(a);
			}

			DFS(S);

			for(int i=0;i<must.length;i++){
                System.out.print(must[i]+" ");
            }
            System.out.println();
		}
		sc.close();
	}
	
	// 以S为起点深度优先遍历所有城市
	public static void DFS(int s) {
		visited[s] = true;
		for (Integer next : tree[s]) // 依次遍历与城市s相连的城市
		{
			if (!visited[next])
			{
				must[next] = s + 1;	// 到达城市next的前一个城市为当前城市
				DFS(next);
			}
		}
	}
}