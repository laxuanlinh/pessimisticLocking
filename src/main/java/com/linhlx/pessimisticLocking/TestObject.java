package com.linhlx.pessimisticLocking;

import javax.persistence.*;

@Entity
@Table(name = "test_object")
public class TestObject {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public TestObject() {
    }

    @Column(name = "status")
    private String status;

    public TestObject(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

