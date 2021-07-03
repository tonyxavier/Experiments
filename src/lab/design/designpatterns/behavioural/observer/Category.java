package lab.design.designpatterns.behavioural.observer;

public class Category {

    private String categoryName;


    public boolean equals(Category c2) {

        if (this.categoryName.equals(c2.categoryName))
            return true;
        else
            return false;


    }


}
