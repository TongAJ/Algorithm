package com.atguigu.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 模拟哈希表
 *
 * @author tongaijie
 * <p>
 * Create: 2020-10-28 14:53
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTbl hashTbl = new HashTbl(7);
        Employee employee1 = new Employee(13, "AJ");
        Employee employee2 = new Employee(6, "AJ");
        hashTbl.add(employee1);
        hashTbl.add(employee2);
        hashTbl.list();

        hashTbl.findEmployeeById(13);
        hashTbl.findEmployeeById(7);
        hashTbl.findEmployeeById(6);
    }
}

/**
 * 员工类
 */
class Employee {

    public Integer id;
    public String name;
    public Employee next;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 哈希链表
 */
class EmpLinkedList {
    /**
     * 头节点
     */
    private Employee head;

    /**
     * Description: 添加元素
     * Param: [employee]
     * return: void
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public void add(Employee employee) {
        if (head == null) {
            // 头节点为空，则直接添加
            head = employee;
            return;
        }
        Employee current = head;
        while (true) {
            if (current.next == null) {
                // 找到最后一个
                current.next = employee;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Description: 移除元素
     * Param: [employee]
     * return: void
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public void remove(Employee employee) {
        if (head == null) {
            return;
        }
        Employee current = head;
        while (true) {
            if (current.next.id.equals(employee.id)) {
                // 找到最后一个
                current.next = null;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Description: 展示链表里的元素
     * Param: []
     * return: void
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public void list(Integer number) {
        if (head == null) {
            System.out.println("第" + number + "条链表为空");
            return;
        }
        Employee current = head;
        System.out.print("第" + number + "条链表: ");
        while (true) {
            System.out.print(current + " ");
            if (current.next == null) {
                // 找到最后一个
                break;
            }
            current = current.next;
        }
    }

    /**
     * Description: 根据id寻找对应的节点
     * Param: [num, id]
     * return: com.atguigu.algorithm.hashmap.Employee
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public Map<String,Object> findEmployeeById(Integer id) {
        Map<String,Object> result = new HashMap<>();
        // 记录第几个节点
        int count = 0;
        if (head == null) {
            return null;
        }
        Employee current = head;
        Employee employee = null;
        while (true) {
            // 找到，打印并赋值result
            if (current.id.equals(id)) {
                employee = current;
                break;
            }
            // 已经到最后一个节点，但仍未找到
            if(current.next == null && !current.id.equals(id)){
                break;
            }
            // 寻找
            current = current.next;
            count++;
        }
        
        if(employee != null){
            result.put("count",count);
            result.put("employee",employee);
        }
        
        return result;
    }
}

/**
 * 哈希表
 */
class HashTbl {

    /**
     * 哈希表长度
     */
    private final Integer size;
    /**
     * 哈希表中的链表数组
     */
    private final EmpLinkedList[] empLinkedListArray;

    /**
     * Description: 构造函数
     * Param: [size]
     * return:
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public HashTbl(Integer size) {
        this.size = size;
        // 初始化链表数组
        empLinkedListArray = new EmpLinkedList[size];
        // 初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * Description: 新增节点，通过hash对象的id，判断插入哪个链表
     * Param: [employee]
     * return: void
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public void add(Employee employee) {
        Integer number = hash(employee.id);
        empLinkedListArray[number].add(employee);
    }

    /**
     * Description: 展示整个链表数组中的所有节点
     * Param: []
     * return: void
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
        System.out.println();
    }


    /**
     * Description: 根据id来查找节点
     * Param: [id]
     * return: com.atguigu.algorithm.hashmap.Employee
     * Author: tongaijie
     * Date: 2020/10/28
     */
    public Employee findEmployeeById(Integer id) {
        int num = hash(id);
        Map<String, Object> result = empLinkedListArray[num].findEmployeeById(id);
        if (result == null) {
            System.out.println("并没有找到id为"+id+"对应的节点");
            return null;
        } else {
            int count = (Integer)result.get("count");
            Employee employee = (Employee) result.get("employee");
            System.out.println("第"+num+"条链表中的第"+count+"个元素："+employee);
            return employee;
        }
    }

    /**
     * Description: hash最简单的一种实现方式：和一个固定值进行取模
     * Param: [id]
     * return: java.lang.Integer
     * Author: tongaijie
     * Date: 2020/10/28
     */
    private Integer hash(Integer id) {
        return id % size;
    }
}

