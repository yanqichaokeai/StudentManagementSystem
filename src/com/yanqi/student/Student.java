package com.yanqi.student;

/**
 * 描述：学生类
 *
 * Alt+Insert（快捷键）-根据需要自动生成有（无）参构造方法以及get/set方法
 *
 * @author： 7lvbingniang
 * @date: 2020/10/29
 * CSDN-URL:sev7lvbingniang.blog.csdn.net
 * 博客园-URL：https://www.cnblogs.com/7sevlvbingniang/
 */
public class Student {
    private String sid;//学号
    private String name;//姓名
    private String age;//年龄
    private String address;//居住地

    /**
     * 无参构造方法
     */
    public Student() {
    }

    /**
     * 带参数的构造方法
     * @param sid
     * @param name
     * @param age
     * @param address
     */
    public Student(String sid, String name, String age, String address) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    /*
    * 以下为本类的get和set方法
    */

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
