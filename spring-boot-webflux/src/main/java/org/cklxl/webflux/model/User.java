package org.cklxl.webflux.model;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 15:19
 */
public class User {
    private Long id;
    private String name;
    private String gender;
    private Integer age;

    public User() {
    }

    public User(Long id, String name, String gender, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
