package cepgio;

import com.memetix.mst.MicrosoftAPI;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import javassist.*;
import javassist.bytecode.ClassFile;

import java.lang.reflect.Field;

/**
 * Created by im going to use this on 3/10/2016.
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        /*CtField idField = null;
        try {
            ClassPool cp = ClassPool.getDefault();
            //CtClass ctClass = cp.makeClass("test.Snake");
            CtClass ctClass = cp.get("cepgio.TestClass");
            ClassFile classFile = ctClass.getClassFile();
            classFile.setVersionToJava5();
            idField = new CtField(ClassPool.getDefault().get("java.lang.Integer"), "id", ctClass);
            //idField.getFieldInfo().addAttribute(attribute);
            ctClass.addField(idField);
            Class TestClass = ctClass.toClass();
            //Object newInstance = snakeClass.newInstance();
            TestClass newInstance = new TestClass();
            //Field field  = snakeClass.getDeclaredField("id");
            Field field  = TestClass.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(newInstance, 123);
            System.out.println(field.get(newInstance));
            System.out.println(newInstance.c);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        final String text = "My text";

        Translate.setHttpReferrer("http://localhost:8080");

        com.memetix.mst.language.Language from = com.memetix.mst.language.Language.ENGLISH ;
        com.memetix.mst.language.Language to =  com.memetix.mst.language.Language.RUSSIAN;
        MicrosoftAPI.setKey("LYqTSiUq8al1BbRJsBjG0nODBZC2ZVOP7YRfCTkQGsI");
        final String translatedText = Translate.execute(text, Language.AUTO_DETECT, Language.CZECH);
        System.out.println(translatedText);

    }
}
