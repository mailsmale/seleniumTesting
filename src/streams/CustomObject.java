/**
 * Created by im going to use this on 3/20/2016.
 */
public class CustomObject {
    String name;
    public int a;
    public CustomObject(){
        this.a = 3;
    }
    public CustomObject(String name){
        this.name = name;
        this.a = 3;
    }
    public CustomObject soutName(){
        System.out.println(this.name.substring(0));
        return this;
    }

    public CustomObject setName(String name){
        this.name = name;
        return this;
    }

    public String getName(){
        System.out.println(this.name);
        return this.name;
    }

    public static String getCOName(CustomObject o){
        return o.getName();
    }

}
