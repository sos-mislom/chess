package Chess;

import java.util.ArrayList;

abstract class Test {
    private ArrayList<Boolean> field = new ArrayList<Boolean>();
    private ArrayList<Piece> sub_field = new ArrayList<>();
    public  Test(){
        this.field = field;
    }
    public void test_sout(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.field.add(this.field.add(this.sub_field.add(null)));
            }

        }
        System.out.println(this.field);
    }

}