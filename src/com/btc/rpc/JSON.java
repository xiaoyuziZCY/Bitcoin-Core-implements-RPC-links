package com.btc.rpc;

import com.alibaba.fastjson.JSONObject;

public class JSON {
public static void main(String[] args){
    System.out.println("hello world");
    Student student = new Student();
    student.id="1001";
    student.name="小鱼子";
    student.sex="male";
    student.age=19;
    String stuJson= JSONObject.toJSON(student).toString();
    System.out.println(stuJson);
    Student stu1 = JSONObject.parseObject(stuJson,Student.class);
    System.out.println(stu1.getName());

}
    static class Student{
    private  String id;
    private String name;
    private String sex;
    private  int age;
    public String getId(){return id;}

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
        public String getName(){
        return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public void  setId(String id){this.id=id;}
    }
    static class Teacher{
    String name;
    int salary;
    }
}
