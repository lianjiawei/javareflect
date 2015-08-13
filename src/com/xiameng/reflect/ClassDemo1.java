package com.xiameng.reflect;

public class ClassDemo1 {
	public static void main(String[] args) {
		//Foo��ʵ����ô��ʾ��
		Foo foo1=new Foo();
		//Foo�����Ҳ��һ��ʵ������Class���ʵ��������α�ʾ��
		//�κ�һ���඼��Class��ʵ���������ʵ�����������ֱ�﷽ʽһ��Class���������һ���ֽ��룬��ͬ���͵Ķ���õ����ֽ��������ͬһ��
		
		
		//��һ�ֱ�﷽ʽ-->ʵ���ڸ��������κ�һ���඼��һ�������ľ�̬��Ա����class������Class����ķ�ʽһ��
		Class c1=Foo.class;
		//�ڶ��ֱ�﷽ʽ �Ѿ�֪��������Ķ���ͨ��getClass����������Class����ķ�ʽ����
		Class c2=foo1.getClass();
		
		//����c1,c2��ʾ��Foo��������ͣ�class type����Ҳ�Ƕ�������������ǳ�Ϊ������
		/*
		 * ��������Զ���
		 * ��Ҳ�Ƕ�����Class���ʵ������
		 * ����������ǳ�Ϊ����������ͣ�����Ϣ��
		 */
		System.out.println(c1==c2); 
		
		//�����ֱ�﷽ʽ
		Class c3=null;
		try {
			c3 = Class.forName("com.xiameng.reflect.Foo");  //��̬������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2==c3);  
		
		//������ȫ����ͨ����������ʹ�������Ķ���ʵ��-->ͨ��c1 or c2 or c3����Foo��ʵ��
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