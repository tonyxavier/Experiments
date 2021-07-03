package lab.rest.core;


import lab.rest.impl.Post;

public class PosterFactory {


    public static Poster getInstance(){

        return  new Post();

    }


}
