/**
 第18题：
 题目：n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。
 求出在这个圆圈中剩下的最后一个数字。

 */
public class No_18 {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addNums(5);
        linkedList.show();

        linkedList.countNum(2, 5);
        //数两个数字
        //0 1 2 3 4  原队列
        //1 2 1 2 1 叫号，数到2出
        //2   1   2 叫号
        //1 3 0 4  出列顺序
        //2 留在链表中的数字
    }
}
// 创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个 first 节点
    private Num first = new Num(-1);

    //添加数字到环形链表中 max 表示多少个 n - 1 个数字
    public void addNums(int max){
        if (max < 0){
            System.out.println("nums 不可以为负数");
            return;
        }
        Num curr = null; // 辅助指针
        for (int i = 0; i < max; i++) {
            Num num = new Num(i); // new一个节点
            //如果是第一个数字，让他的next指向自己，构成一个环
            if (i == 0){
                first = num; // first 指向第一个数字
                first.next = first; // 第一个数字的next 指向自己
                curr = first;
            } else {
                curr.next = num; // 将上个节点指向当前节点
                num.next = first; // 当前数组的next 指向 first。
                curr = num; // 辅助指针移动到当前节点的位置
            }
        }
    }
    // 遍历环形列表
    public void show(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        // 定义辅助指针
        Num curr = first;
        while (true){
            System.out.printf("当前数字是：%d\n", curr.no);
            if(curr.next == first){ // 下一个节点为first，结束循环
                break;
            }
            curr = curr.next; // 指针后移
        }
    }
    // 根据用户的输入，计算出链表的数字
    /**
     *
     * @param num 删除数字中见的间隔
     * @param max 链表中的节点个数
     */
    public void countNum(int num, int max){
        if (first == null || num < 0 || max < 0){
            System.out.println("参数有误，重新输入");
            return;
        }
        // 创建要给辅助指针，帮助完成小孩出圈
        Num helper = first;
        // 将辅助变量指向列表最后，也就是first之后。
        while (true){
            if (helper.next == first){ //如果helper的next是first，那么他就是链表最后。
                break;
            }
            helper = helper.next;
        }
        //first和helper指针同时移动m-1次后，删除
        while(true){
            if (helper == first){ // 当俩指针重叠，证明链表中只有一个元素
                break;
            }
            for(int i = 0; i < num - 1; i++){
                first = first.next;
                helper = helper.next;
            }
            System.out.printf("删除的数字是：%d\n", first.no);
            first = first.next; // first 后移
            helper.next = first; // helper 跳过删除的节点，指向first
        }
        System.out.printf("最后在圈中的数字是：%d\n", first.no);
    }
}

// 循环列表的节点
class Num{
    int no;
    Num next;

    public Num(int no){
        this.no = no;
    }

}