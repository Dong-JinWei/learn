package demo.������;

public class Example05 {

	static String[] strs = {"aaa","bbb","ccc"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String str:strs) {
			str = "ddd";
			
		}
		System.out.println("foreachѭ���޸ĺ�����飺"+strs[0]+","+strs[1]+","+strs[2]);
		for (int i = 0; i<strs.length;i++) {
			strs[i] = "ddd";
		}
		System.out.println("��ͨforѭ���޸ĺ�����飺"+strs[0]+","+strs[1]+","+strs[2]);
			

	}

}
