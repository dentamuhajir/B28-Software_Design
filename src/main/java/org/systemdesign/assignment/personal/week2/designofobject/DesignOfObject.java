package org.systemdesign.assignment.personal.week2.designofobject;

public class DesignOfObject {
    public static void main(String[] args) {
        User user = new User("Denta","Muhajir");
        Email email = new Email(user, "Ini adalah body emailnya");
        System.out.println(email.showEmail());
    }
}

class Email {
    private final String Signature = "Regards";
    private String str = "";

    // ubah constructEmail dengan construct harus sesuai aturan yaotu sama dengan nama class
    // karna constructor tidak bisa mengamb alikan nilai maka kita define str sebagai properti private
//    public String constructEmail(User recipient, String body) {
//        String str = "";
//        str += getNiceUserName(recipient);
//        str += "\n";
//        str += body;
//        str += "\n";
//        str += Signature;
//        return str;
//    }

    public Email(User recipient, String body) {
        this.str += getNiceUserName(recipient);
        this.str += "\n";
        this.str += body;
        this.str += "\n";
        this.str += Signature;
    }

    private String getNiceUserName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }

    public String showEmail() {
        return this.str;
    }
}

class User {

    // ubah variable agar lebih umum dipakai
//    private String first;
//    private String last;

//    public User(String first, String last) {
//        this.first = first;
//        this.last = last;
//    }

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // mengganti fungsi ini dengan get

//    public String firstName() {
//        return first;
//    }
//
//    public String lastName() {
//        return last;
//    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}


