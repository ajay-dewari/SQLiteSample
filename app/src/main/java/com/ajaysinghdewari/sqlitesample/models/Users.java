package com.ajaysinghdewari.sqlitesample.models;

/**
 * Created by justdial on 8/5/17.
 */

public class Users {

    private int id, age;
    private String name, _last_name;

    public Users() {
    }

    public Users(int _id, int _age, String _name, String _last_name) {
        this.id = _id;
        this.age = _age;
        this.name = _name;
        this._last_name = _last_name;
    }

    public Users(String _name, String _last_name, int age) {
        this.name = _name;
        this._last_name = _last_name;
        this.age=age;
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public int get_age() {
        return age;
    }

    public void set_age(int _age) {
        this.age = _age;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String _name) {
        this.name = _name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }








}
