/*
���ĵĹ���
ʱ�����ƣ�1000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�3
����
��һ�����ĵĹ�������N�����У���N�����м�ֻ��N-1��·�����N�������������������ڣ�Tom�ڵ�S�ų��У������Ÿù���ͼ������֪������Լ�Ҫȥ�ι۵�T�ų��У����뾭����ǰһ�������Ǽ��ų��У������㲻���ظ���·����
����
��һ������һ������M��ʾ�������ݹ���M(1<=M<=5)��
ÿ��������ݵĵ�һ������һ��������N(1<=N<=100000)��һ��������S(1<=S<=100000)��N��ʾ���е��ܸ�����S��ʾ�ι������ڳ��еı��
����N-1�У�ÿ��������������a,b(1<=a,b<=N)����ʾ��a�ų��к͵�b�ų���֮����һ��·��ͨ��
���
ÿ�����������N�������������У���i������ʾ��S�ߵ�i�ų��У�����Ҫ��������һ�����еı�š�������i=Sʱ�������-1��
��������
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
�������
-1 1 10 10 9 8 3 1 1 8
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main
{
	private static List<Integer>[] tree;	// ��������ͼ
	private static boolean[] visited;	// visited[i]��ʾ����i�Ƿ��Ѿ�������
	private static int[] must; // must[i]��ʾ����i���б���Ҫ�����ĳ���

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // ������������
		while (M-- > 0)
		{
			// ��ʼ��
			int N = sc.nextInt(); // ��N������
			int S = sc.nextInt()-1; // �ι������ڳ��б��
			tree = new ArrayList [N];
			for (int i = 0; i < tree.length; i++)
			{
				tree[i] = new ArrayList<Integer>();
			}
			visited = new boolean [N];
			must = new int [N];
			must[S] = -1;
			// ����ͼ
			// tree[i]��ʾ���������i�����ĳ���
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
	
	// ��SΪ���������ȱ������г���
	public static void DFS(int s) {
		visited[s] = true;
		for (Integer next : tree[s]) // ���α��������s�����ĳ���
		{
			if (!visited[next])
			{
				must[next] = s + 1;	// �������next��ǰһ������Ϊ��ǰ����
				DFS(next);
			}
		}
	}
}