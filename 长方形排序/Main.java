/*
一种排序
时间限制：3000 ms  |  内存限制：65535 KB
难度：3
描述
现在有很多长方形，每一个长方形都有一个编号，这个编号可以重复；还知道这个长方形的宽和长，编号、长、宽都是整数；现在要求按照一下方式排序（默认排序规则都是从小到大）；

1.按照编号从小到大排序

2.对于编号相等的长方形，按照长方形的长排序；

3.如果编号和长都相同，按照长方形的宽排序；

4.如果编号、长、宽都相同，就只保留一个长方形用于排序,删除多余的长方形；最后排好序按照指定格式显示所有的长方形；
输入
第一行有一个整数 0<n<10000,表示接下来有n组测试数据；
每一组第一行有一个整数 0<m<1000，表示有m个长方形；
接下来的m行，每一行有三个数 ，第一个数表示长方形的编号，

第二个和第三个数值大的表示长，数值小的表示宽，相等
说明这是一个正方形（数据约定长宽与编号都小于10000）；
输出
顺序输出每组数据的所有符合条件的长方形的 编号 长 宽
样例输入
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
样例输出
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