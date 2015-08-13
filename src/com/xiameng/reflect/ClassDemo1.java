package com.xiameng.reflect;

public class ClassDemo1 {
	public static void main(String[] args) {
		//Foo的实例怎么表示呢
		Foo foo1=new Foo();
		//Foo这个类也是一个实例对象，Class类的实例对象，如何表示呢
		//任何一个类都是Class的实例对象，这个实例对象有三种表达方式一个Class对象代表着一份字节码，相同类型的对象得到的字节码对象是同一个
		
		
		//第一种表达方式-->实际在告诉我们任何一个类都有一个隐含的静态成员变量class（创建Class对象的方式一）
		Class c1=Foo.class;
		//第二种表达方式 已经知道该列类的对象通过getClass方法（创建Class对象的方式二）
		Class c2=foo1.getClass();
		
		//官网c1,c2表示了Foo类的类类型（class type）类也是对象，这个对象我们称为类类型
		/*
		 * 万事万物皆对象
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们称为该类的类类型（类信息）
		 */
		System.out.println(c1==c2); 
		
		//第三种表达方式
		Class c3=null;
		try {
			c3 = Class.forName("com.xiameng.reflect.Foo");  //动态加载类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2==c3);  
		
		//我们完全可以通过类的类类型创建该类的对象实例-->通过c1 or c2 or c3创建Foo的实例
		try {
			Foo foo=(Foo) c1.newInstance();
			foo.print(); 
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
class Foo{
	void print(){
		System.out.println("foo"); 
	}
}