package org.systemdesign.explore;

public class UsingSetterGetterAndWithout {
    public static void main(String[] args) {
        UniversityUsingSetterGetter university = new UniversityUsingSetterGetter();
        university.setName("Binus University");
        university.showUniversity();
        UniversityWithoutUsingSetterGetter university2 = new UniversityWithoutUsingSetterGetter("Universitas Indonesia");
        university2.showUniversity();

    }

}


class UniversityUsingSetterGetter {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showUniversity() {
        System.out.println("University name is " + getName());
    }
}

class UniversityWithoutUsingSetterGetter {
    public String name;
    public UniversityWithoutUsingSetterGetter(String name) {
        this.name = name;
    }


    public void showUniversity() {
        System.out.println("University name is " + this.name);
    }
}