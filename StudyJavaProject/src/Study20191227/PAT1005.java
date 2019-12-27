package Study20191227;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
 
public class PAT1005 {
	/**
	 * 卡拉兹(Callatz)猜想：
	 *
	 * 对任何一个自然数n，如果它是偶数，那么把它砍掉一半；如果它是奇数，那么把(3n+1)砍掉一半。这样一直反复砍下去，最后一定在某一步得到n=1。当我们验证卡拉兹猜想的时候，为了避免重复计算，可以记录下递推过程中遇到的每一个数。例如对n=3进行验证的时候，我们需要计算3、5、8、4、2、1，则当我们对n=5、8、4、2进行验证的时候，就可以直接判定卡拉兹猜想的真伪，而不需要重复计算，因为这4个数已经在验证3的时候遇到过了，我们称5、8、4、2是被3“覆盖”的数。我们称一个数列中的某个数n为“关键数”，如果n不能被数列中的其他数字所覆盖。
	 *
	 *
	 * 现在给定一系列待验证的数字，我们只需要验证其中的几个关键数，就可以不必再重复验证余下的数字。你的任务就是找出这些关键数字，并按从大到小的顺序输出它们。
	 *
	 * 输入格式：每个测试输入包含1个测试用例，第1行给出一个正整数K(<100)，第2行给出K个互不相同的待验证的正整数n(1<n<=100)的值，数字间用空格隔开。
	 *
	 * 输出格式：每个测试用例的输出占一行，按从大到小的顺序输出关键数字。数字间用1个空格隔开，但一行中最后一个数字后没有空格。
	 *
	 * 输入样例：
	 * 6
	 * 3 5 6 7 8 11
	 * 输出样例：
	 * 7 6
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner scanner = new Scanner(System.in);
		int numSize=scanner.nextInt();
		ArrayDeque<Integer> newArrayDeque=new ArrayDeque<Integer>();
		ArrayDeque<Integer> closeArrayDeque=new ArrayDeque<Integer>();
		int i;
		while (scanner.hasNext()) {                      //读取键盘输入值
			for (i = 0; i < numSize; i++) {
				newArrayDeque.add(scanner.nextInt());
				
			}
			if (i>=numSize) {
				break;
			}
		}
		int temp;
		for (Integer integer : newArrayDeque) {        //将非关键数存入closeArrayDeque中
			temp=integer; 
			while (temp!=1) {
				if (temp%2==0) {
					temp=temp/2;
					if (newArrayDeque.contains(temp)) {
						closeArrayDeque.add(temp);
					}
					
				}else {
					temp=(temp*3+1)/2;
					if (newArrayDeque.contains(temp)) {
						closeArrayDeque.add(temp);
					}
				}
			}
		}
		SortedSet<Integer> sortedSet=new TreeSet<Integer>();  //sortedSet用于存放关键数
		for (Integer integer : newArrayDeque) {
			if (!closeArrayDeque.contains(integer)) {
				sortedSet.add(integer);
			}
		}
		//因为treeSet对数字，默认使用降序而最后输出要求升序
		//所以直接将元素顺序反过来就是升序
		int[] leftInt=new int[sortedSet.size()];
		int j=sortedSet.size()-1;
		for (Integer integer : sortedSet) {
			leftInt[j]=integer;
			j--;
		}
		for (int j2 = 0; j2 < leftInt.length; j2++) {        //按照从大到小的顺序输出关键数
			if (j2==leftInt.length-1) {
				System.out.println(leftInt[j2]);
			}else {
				System.out.print(leftInt[j2]+" ");
			}
			
		}
	}
 
}