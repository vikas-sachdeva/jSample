package jsample;

import jsample.annotation.processor.AnnotationProcessor;
import jsample.annotation.user.AnnotationUser;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationProcessor.parseAnnotation(AnnotationUser.class);
    }
}
