/*
һ������
ʱ�����ƣ�3000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�3
����
�����кܶ೤���Σ�ÿһ�������ζ���һ����ţ������ſ����ظ�����֪����������εĿ�ͳ�����š�������������������Ҫ����һ�·�ʽ����Ĭ����������Ǵ�С���󣩣�

1.���ձ�Ŵ�С��������

2.���ڱ����ȵĳ����Σ����ճ����εĳ�����

3.�����źͳ�����ͬ�����ճ����εĿ�����

4.�����š���������ͬ����ֻ����һ����������������,ɾ������ĳ����Σ�����ź�����ָ����ʽ��ʾ���еĳ����Σ�
����
��һ����һ������ 0<n<10000,��ʾ��������n��������ݣ�
ÿһ���һ����һ������ 0<m<1000����ʾ��m�������Σ�
��������m�У�ÿһ���������� ����һ������ʾ�����εı�ţ�

�ڶ����͵�������ֵ��ı�ʾ������ֵС�ı�ʾ�����
˵������һ�������Σ�����Լ���������Ŷ�С��10000����
���
˳�����ÿ�����ݵ����з��������ĳ����ε� ��� �� ��
��������
1
8
1 1 1
1 1 1
1 1 2
1 2 1
1 2 2
2 1 1
2 1 2
2 2 1
�������
1 1 1
1 2 1
1 2 2
2 1 1
2 2 1
*/
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main
{
	private static class Triangle implements Comparable<Triangle>
	{
		private int num;
		private int length;
		private int width;

		public Triangle(int num, int x, int y) {
			this.num = num;
			this.length = x >= y ? x : y;
			this.width = x < y ? x : y;
		}

		public int getNum() {
			return this.num;
		}
		public int getLength() {
			return this.length;
		}
		public int getWidth() {
			return this.width;
		}
		@Override
		public boolean equals(Object o) {
			Triangle tri = (Triangle) o;
			if (this.num == tri.getNum() && this.length == tri.getLength() && this.width == tri.getWidth())
			{
				return true;
			}
			else {
				return false;
			}
		}
		@Override
		public int compareTo(Triangle tri) {
			if (this.num < tri.getNum())
			{
				return -1;
			}
			else if (this.num > tri.getNum())
			{
				return 1;
			}
			else
			{
				if (this.length < tri.getLength())
				{
					return -1;
				}
				else if (this.length > tri.getLength())
				{
					return 1;
				}
				else
				{
					if (this.width < tri.getWidth())
					{
						return -1;
					}
					else if (this.width < tri.getWidth())
					{
						return -1;
					}
					else
					{
						return 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTest = sc.nextInt();
		while (numOfTest-- > 0)
		{
			int numOfData = sc.nextInt();
			Triangle[] triArray = new Triangle [numOfData];
			for (int i = 0; i < numOfData; i++)
			{
				triArray[i] = new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(triArray);
			triArray = deleteSame(triArray);
			show(triArray);
		}
		sc.close();
	}
	
	public static Triangle[] deleteSame(Triangle[] triArray) {
		int num = 0;
		for (int i = 1; i < triArray.length; i++)
		{
			if (triArray[i].equals(triArray[i-1]))
			{
				triArray[i-1] = null;
				num++;
			}
		}
		Triangle[] triTemp = new Triangle[triArray.length - num];
		int k = 0;
		for (int i = 0; i < triArray.length; i++)
		{
			if (triArray[i] != null)
			{
				triTemp[k++] = triArray[i];
			}
		}

		return triTemp;
	}

	public static void show(Triangle[] triArray) {
		for (int i = 0; i < triArray.length; i++)
		{
			System.out.println(triArray[i].getNum() + " " + triArray[i].getLength() +" "+ triArray[i].getWidth());
		}
	}
}