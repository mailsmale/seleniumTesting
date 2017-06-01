/**
 * Created by Astrarium on 5/31/2017.
 */
public class InnerClassesTest {

    public static void main(String[] args) {
        InnerClassesTest i1 = new InnerClassesTest();
        Inner_1 inner_1 = i1.getInner_1();
        Inner_1.Inner_2 inner_2 = inner_1.getInner_2();
        InnerClassesTest i2 = inner_2.getParent();
    }
    Inner_1 getInner_1(){
        return new Inner_1();
    }
    private class Inner_1 {
        private Inner_1(){

        }
        public Inner_2 getInner_2(){
            return new Inner_2();
        }
        private class Inner_2 {
            public InnerClassesTest getParent(){
                return InnerClassesTest.this;
            }
        }
    }

}

