package lab.java.annotations;

import java.lang.annotation.Annotation;
//import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Transformer{
    String type() default "Excel";
}

@Transformer
public class AnnotationTest {

    private Annotation an;

    @Transformer
    public static void transformerMethod(){

        System.out.println("tranforming...");

    }

    public static void main(String[] args) {
        AnnotationTest test = new AnnotationTest();

        try{
            Class<?> cls = test.getClass();
            Transformer trans = cls.getAnnotation(Transformer.class);
            System.out.println(trans.type());

            Method method = cls.getMethod("transformerMethod");
            Transformer an = method.getAnnotation(Transformer.class);
            System.out.println(an);
            System.out.println(an.annotationType());
            System.out.println(an.type());


        }catch(NoSuchMethodException nsme){
            nsme.printStackTrace();
        }


    }



}
