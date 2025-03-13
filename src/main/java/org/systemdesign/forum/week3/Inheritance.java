package org.systemdesign.forum.week3;

public class Inheritance {
    public static void main(String[] args) {
        University university = new University();
        Faculty faculty = new Faculty();
        university.setName("Binus University");
        faculty.setName("Computer Science");
        university.showInfoUniversity();
        faculty.showInfoFaculty();
    }
}

class University {
    private String name;

    public void showInfoUniversity() {
        System.out.println("The University name is " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Faculty extends  University {
    private String name;

    public void showInfoFaculty() {
        System.out.println("The Faculty name is " + this.name);
    }

    @Override
    public void showInfoUniversity() {
        System.out.println("The University name");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}