
public class Tax {
    public static void main (String[] args){
        //System.out.println("it works");
        double postamount = Calculate.income(100000);
        System.out.println(postamount);
        System.out.println(46226*(1- (0.0505 + 0.15)) + 3971*(1 - (0.15 + 0.0915)) + 24803*(1-(0.205+0.0915)));
    }
}

