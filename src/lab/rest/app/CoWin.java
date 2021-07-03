package lab.rest.app;

import lab.rest.core.Poster;
import lab.rest.core.PosterFactory;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CoWin {

    public static void main(String[] args)throws Exception {

        Poster rest = PosterFactory.getInstance();
        String endpoint = "https://cdn-api.co-vin.in/api";

        String[] districts={"306","307"};

        for (String district:districts) {

            String result = rest.get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id="+district+"&date=06-05-2021", null);

            if(slotAvailable(result)){
                makeSomeNoise();
                break;
            }

            Thread.sleep(1000);

        }
       // System.out.println(result);


    }


    private static boolean slotAvailable(String response){

        return true;
    }

    private static void makeSomeNoise(){

        String bip = "alarm.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }


}
