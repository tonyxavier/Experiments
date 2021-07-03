package lab.design.designpatterns.behavioural.observer;

public class Subscriber {

    String userId;

    public void push(News news) {

        System.out.println("Sending the news:" + news.getContent() + " for user:" + userId);

    }


}
