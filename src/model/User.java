package model;

public abstract class User {
    protected static int id = 0;
    protected String name;
    protected String email;
    protected String address;
    protected String phoneNumber;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }



    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "model.User: " + this.name + "\nEmail: " + email;
    }

    public  abstract void showDataUser();
}
