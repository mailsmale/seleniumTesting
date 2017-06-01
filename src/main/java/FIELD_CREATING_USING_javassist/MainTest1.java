package FIELD_CREATING_USING_javassist;

import javassist.*;
import javassist.bytecode.ClassFile;

import java.lang.reflect.Field;

/**
 * Created by im going to use this on 3/10/2016.
 */
public class MainTest1 {
    public static void main(String[] args)  {
        CtField idField = null;
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
            MainTest1 newInstance = new MainTest1();
            //Field field  = snakeClass.getDeclaredField("id");
            Field field  = MainTest1.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(newInstance, 123);
            System.out.println(field.get(newInstance));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
