/*
�ó����е�С��
ʱ�����ƣ�1000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�4
����
С��ʮ�ִ���������ʮ���ó����м��㡣�����С��һ������5���������̸���1-5���ֵ����ȫ���У��������Ϊ����������5��������ѡ������������������ȫ���У���ô��ʹ��ˣ���ͬ���ĺ��ó���������Ҫ��дһ����������֤�ó����е�С�����׶Բ��ԡ�
����
��һ����������N��1<N<10����ʾ������������ݣ�
ÿ��������ݵ�һ���������� n m (1<n<9,0<m<=n)
���
��1-n��ѡȡm���ַ�����ȫ���У����ֵ���ȫ�����,ÿ������ռһ�У�ÿ�����ݼ䲻��ֽ硣������
��������
2
3 1
4 2
�������
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
	// ʹ�û��ݽ���ȫ����
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