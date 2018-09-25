package com.guava.cache;

import com.google.common.base.MoreObjects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author WH1707008
 * @date 2018/8/6 15:53
 * Description: 接口LoadingCache提供了一个非常强大的基于内存的LoadingCache<K，V>。
 * 在缓存中自动加载值 LoadingCache<K,V>
 */
public class LoadingCacheTest {
    private static Employee getFromDataBase(String empId) {
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map database = new HashMap();
        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);
        System.out.println("Database hit for" + empId);
        return (Employee) database.get(empId);
    }

    public static void main(String[] args) {
        //create a cache for employees based on their employee id
        LoadingCache employeeCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(30, TimeUnit.MINUTES)
                .build( new CacheLoader<String,Employee>() {// build the cacheloader
                            @Override
                            public Employee load(String empId){
                                return getFromDataBase(empId);
                            }
                        }
                );

        try {
            //on first invocation, cache will be populated with corresponding
            //employee record
            System.out.println("Invocation #1");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));
            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}

class Employee {
    String name;
    String dept;
    String empID;

    public Employee(String name, String dept, String empId) {
        this.name = name;
        this.dept = dept;
        this.empID = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Employee.class)
                .add("Name", name)
                .add("Department", dept)
                .add("Emp Id", empID).toString();
    }
}
