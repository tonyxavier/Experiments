package lab.design.designpatterns.behavioural.observer;

import java.util.ArrayList;

public class Feed {

    ArrayList<News> newsItems;


    public void addNewsItem(News news) {


        newsItems.add(news);

    }


}
