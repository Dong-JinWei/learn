[toc]

# 数组

[2021/2/9]

## 数组的定义

- 数组是相同类型数据的有序集合。
- 数组描述的是相同类型的若干个数据，按照一定的先后次序排列组合而成。
- 其中每个数据称作数组的元素，每个数组元素可以通过一个下标来访问他们。

## 数组声明与创建

```java
//dataType[] arrayRefVar; 声明数组
int[] nums;
//dataType[] arrayRefVar = new dataType[arraySize]
nums = new int[5];  //创建一个数组

int[] nums2 = new int[10];

nums[0] = 1;
nums[1] = 2;
nums[2] = 3;
nums[3] = 4;

//arrays.length  获取数组长度

for (int i = 0; i < nums.lenth i+){
//计算数组所有元素之和
	sum = sum + nums[i];
}
```

## 三种初始化数组

- 静态初始化

  - int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

- 动态初始化

  - ```java
    int[] a = new int [2];
    a[0] = 1;
    a[1] = 1;
    ```

## 数组的四个基本特点

- 长度确定。数组一旦被创建，他送的大小就是不可以改变的。
- 元素必须是相同类型，不允许出现混合类型。
- 元素可以是任何数据类型。
- 数组对象保存在堆中。

## 数组边界

- 下标的合法区间：[0, length-1]，如果越界就会报错；
- ArrayIndexOutOfBoundsException：数组下标越界异常！

## 数组的使用

- 普通 for 循环遍历。
- for each 遍历
- 数组做方法入参
- 数组返回值

## 多维数组

- 多维数组可以看成数组的数组，比如二维数组就是一个特殊一维数组，其中每个元素都是一个一维数组。
- 二维数组

  ```java
    int a[][] = new int [2][5] //可以看成是一个2行5列的数组。
  ```

## Arrays 类

- 数组的工具类 java.util.Arrays
- 常用的数组操作

  - 打印数组

   ```java
    int[] intArray = { 1, 2, 3, 4, 5 };
    String intArrayString = Arrays.toString(intArray);
    // 直接打印,则会打印出引用对象的Hash值
    // [I@7150bd4d
    System.out.println(intArray);
    // [1, 2, 3, 4, 5]
    System.out.println(intArrayString);
   ```

  - 合并两个数组

  ```java
    int[] intArray = { 1, 2, 3, 4, 5 };
    int[] intArray2 = { 6, 7, 8, 9, 10 };
    // Apache Commons Lang 库
    int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);
  ```
  
  - 数组反转

  ```java

  int[] intArray = { 1, 2, 3, 4, 5 };
  ArrayUtils.reverse(intArray);
  //[5, 4, 3, 2, 1]
  System.out.println(Arrays.toString(intArray));

  ```

  - 移除元素

  ```java
    int[] intArray = { 1, 2, 3, 4, 5 };
    int[] removed = ArrayUtils.removeElement(intArray, 3);//创建新的数组
    System.out.println(Arrays.toString(removed));
  ```

## 冒泡排序

1. 比较数组中，两个相邻的元素，如果第一个第一个比第二个数大，我们就交换们的位置
2. 每次比较，都会产生一个较小或较大的数字
3. 下一轮可以少排一次
4. 依次循环，直到结束

```java
int (int i = 0; i < array.length-1; i++){
    for (int j = 0; j < array.length-1-i; j++){
        if (array[j + 1] < array[j]){
            temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
        }
    }
}
```

## 稀疏数组

- 个数组中大部分元素为 0，或者为同一值的数组时，可以使用稀疏数组来保存该数组。
- 稀疏数组的处理方式是：
  - 记录数组一共有几行几列，有多少个不同的值
  - 把具有不同值的元素和行列值记录在一个小规模的数组中，从而缩小程序的规模

```java
package com.dong.Arraydemo;

public class demo01 {
	public static void main(String[] atgs) {
		int[][] array1 = new int [11][11];
		array1[1][2] = 1;
		array1[2][3] = 2;
		//输出原始数组
		System.out.println("输出原始数组：");

		for (int[] ints : array1) {
			for(int anInt : ints) {
				System.out.print(anInt+"\t");
			}
			System.out.println();
		}

		//专为稀疏数组保存

		System.out.println("===================");
		//1.获取有效值的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (array1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("有效值的个数：" + sum);


		//2.创建一个稀疏数组的数组
		int[][] array2 = new int [sum+1][3];

		array2[0][0] = 11;
		array2[0][1] = 11;
		array2[0][2] = sum;

	int count = 0;
	for (int i = 0; i < array1.length; i++) {
		for (int j = 0; j < array1[i].length; j++) {
			if (array1[i][j] != 0) {
				count++;
				array2[count][0] = i;
				array2[count][1] = j;
				array2[count][2] = array1[i][j];
			}
		}
	}
	//输出稀疏数组
	System.out.println("稀疏数组：");

	for (int i = 0; i < array2.length; i++) {
		System.out.println(array2[i][0] + "\t"
				+ array2[i][1] + "\t"
				+ array2[i][2] + "\t");
	}
	System.out.println("===================");

	//稀疏数组还原
	//1.读取稀疏数组
	int[][] array3 = new int[array2[0][0]][array2[0][1]];

	//2.给其中的元素还原他的值
	for (int i = 1; i < array2.length; i++) {
		array3[array2[i][0]][array2[i][1]] = array2[i][2];
	}

	//3.打印
	System.out.println("输出还原数组：");

	for (int[] ints : array3) {
		for(int anInt : ints) {
			System.out.print(anInt+"\t");
		}
		System.out.println();
	}


  }

}
```
