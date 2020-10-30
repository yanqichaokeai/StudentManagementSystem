package com.yanqi.student;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述：学生管理系统
 *
 * 实现思路：
 * 1.定义学生类
 * 2.编写显示主界面
 * 3.添加学生
 * 4.查看学生
 * 5.删除学生
 * 6.修改学生
 *
 * @author： 7lvbingniang
 * @date: 2020/10/29
 * CSDN-URL:sev7lvbingniang.blog.csdn.net
 * 博客园-URL：https://www.cnblogs.com/7sevlvbingniang/
 */
public class StudentManage {
    public static void main(String[] args) {

        /*
         实现思路：
         1.用输出语句完成主界面的编写
         2.用Scanner实现键盘录入数据
         3.用switch语句完成操作的选择
         4.用循环完成再次回到主界面
        */

        //创建集合对象，用于存储学生数据
        ArrayList<Student> arrayList = new ArrayList<Student>();

        while (true) {
            //输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");

            //Scanner实现键盘录入数据
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();

            //使用switch语句完成操作的选择
            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    addStudent(arrayList);//调用addStudent方法，实现添加学生
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(arrayList);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateStudent(arrayList);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findAllStudent(arrayList);//调用findAllStudent方法，实现查看所有学生
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //break;
                    System.exit(0);
            }
        }
    }

    //定义一个方法，用于添加学生信息
    public static void addStudent(ArrayList<Student> arrayList) {
        /*
         实现思路
         1.显示提示信息
         2.键盘录入学生对象需要的数据
         3.创建学生对象，将键盘录入的数据赋值给学生对象的成员变量
         4.将学生对象添加到集合中
         5.给出添加成功提示
         */


        //键盘录入学生对象所需要的数据，显示提示信息，提示要输入何种信息
        Scanner input = new Scanner(System.in);

        //为了让sid在循环外被访问到，所以把sid定义在循环外
        String sid;
        //为了让程序回到这里，使用while循环实现
        while(true){
            System.out.println("请输入学生学号：");
            sid = input.nextLine();

            boolean flag = isUsed(arrayList,sid);
            if (flag){//判断学号是否被占用
                System.out.println("你输入的学号已经被使用，请重新输入");
            }else{
                break;
            }
        }


        System.out.println("请输入学生姓名：");
        String name = input.nextLine();
        System.out.println("请输入学生年龄：");
        String age = input.nextLine();
        System.out.println("请输入学生居住地：");
        String address = input.nextLine();

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student student = new Student();
        student.setSid(sid);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);

        //将学生信息添加到集合中
        arrayList.add(student);

        //给出添加成功提示
        System.out.println("添加成功");
    }

    //定义一个方法，用于查看学生信息
    public static void findAllStudent(ArrayList<Student> arrayList) {
        /*
        实现思路：
        1.判断集合中是否有数据，如果有数据，显示学生信息，如果没有，显示提示信息
        2.显示表头信息
        3.将集合中的的数据取出，按照对应格式显示学生信息
         */

        //判断集合中是否有数据，如果没有，显示提示信息
        if (arrayList.size() == 0){
            System.out.println("无信息，请先添加学生信息！");
            //为了让程序不再继续执行，给出return
            return;
        }

        //如果集合中有数据，显示表头信息
        System.out.println("学号\t姓名\t年龄\t居住地");

        //将集合中的数据按照对应格式显示学生信息
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            System.out.println(student.getSid() + "\t\t" + student.getName() + "\t\t" + student.getAge() + "岁\t\t" + student.getAddress());
        }
    }

    //定义一个方法，用于删除学生信息
    public static void deleteStudent(ArrayList<Student> arrayList){
        /*
        实现思路：
        1.显示提示信息
        2.键盘录入要删除的学生学号
        3.判断还学生是否存在，存在，执行删除操作，不存在，提示不存在
        4.提示删除成功
         */

        //键盘录入要删除学生的学号，显示提示信息
        Scanner input = new Scanner(System.in);

        System.out.println("请输入你要删除的学生的学号：");
        String sid = input.nextLine();

        /*
        执行删除操作前，对学生学号是否存在进行判断
        如果不存在，显示提示信息
        如果存在，执行删除操作
         */
        int index = -1;//索引
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            if (student.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该信息不存在，请重新输入");
        }else{
            arrayList.remove(index);
            System.out.println("删除成功");
        }

    }

    //定义一个方法，用于修改学生信息
    public static void updateStudent(ArrayList<Student> arrayList){

        /*
        实现思路：
        1.显示提示信息
        2.键盘录入要修改的学生的学号
        3.判断该学生是否存在，如果不存在，执行操作，如果存在，输出提示信息
        4.遍历集合修改对应的学生信息
        5.提示修改成功
         */

        //显示提示信息,键盘录入要修改的学生学号
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String sid = input.nextLine();

        /*
        执行修改操作前，对学生学号是否存在进行判断
        如果不存在，显示提示信息
        如果存在，执行修改操作
         */
        int index = -1;//索引
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            if (student.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该信息不存在，请重新输入");
        }else{
            //键盘录入要修改的学生对象
            System.out.println("请输入学生新姓名：");
            String name = input.nextLine();
            System.out.println("请输入学生新年龄：");
            String age = input.nextLine();
            System.out.println("请输入学生新居住地：");
            String address = input.nextLine();

            //创建学生对象,传入新的学生信息
            Student student = new Student();

            student.setSid(sid);
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);

            //遍集合修改对应的学生信息
            for (int i = 0; i < arrayList.size(); i++) {
                Student student1 = arrayList.get(i);
                if (student1.getSid().equals(sid)){
                    arrayList.set(i,student);
                    break;
                }
            }
            System.out.println("修改成功");
        }
    }

    //定义一个方法，判断学号是否被使用
    public static boolean isUsed(ArrayList<Student> arrayList,String sid){
        /*
        实现思路：
        1.对学号是否被使用进行判断，如果学号和集合中的某位学生的学号相同返回true，不相同返回false
        2.在添加学生录入学号后调用该方法
         */

        //如果集合中的某一个学生学号相同，返回true;如果都不行同，返回false;
        boolean flag = false;

        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            if (student.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
