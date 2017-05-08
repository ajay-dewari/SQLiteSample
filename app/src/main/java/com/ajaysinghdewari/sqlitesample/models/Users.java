package com.ajaysinghdewari.sqlitesample.models;

/**
 * Created by justdial on 8/5/17.
 */

public class Users {

    private int _id, _age;
    private String _name, _last_name;

    public Users() {
    }

    public Users(int _id, int _age, String _name, String _last_name) {
        this._id = _id;
        this._age = _age;
        this._name = _name;
        this._last_name = _last_name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }








}
