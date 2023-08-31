public class Calculate {
    
    public static double income(double pretaxAmount){
        double[] ON_MARGINAL = {0.1316, 0.1216, 0.1116, 0.0915, 0.0505, 0};
        double[] FED_MARGINAL = {0.33, 0.29, 0.26, 0.205, 0.15, 0};
        int[] ON_INTERVAL= {220000, 150000, 92454, 46226, 13229, 0};
        int[] FED_INTERVAL = {221708, 155625, 100392, 50197, 13229, 0};
        double prov_taxed = 0;
        double fed_taxed = 0;
        double CPP, EI;
        double tempprov, tempfed;
        tempprov = tempfed = pretaxAmount;

        for (int i = 0; i < ON_INTERVAL.length; i++){
            if (ON_INTERVAL[i] <= tempprov){
                if (FED_INTERVAL[i] <= tempfed){
                    int otherTempFed = (int) ((tempfed - FED_INTERVAL[i])*FED_MARGINAL[i]);
                    tempfed = FED_INTERVAL[i];
                    fed_taxed = fed_taxed + otherTempFed;
                    //System.out.println(otherTempFed);
                }   
                int otherTempProv = (int)((tempprov - ON_INTERVAL[i])*ON_MARGINAL[i]);
                //System.out.println((int)(tempprov - ON_INTERVAL[i]));
                tempprov = ON_INTERVAL[i];
                prov_taxed = prov_taxed + otherTempProv;
  

            }
            
        }
        CPP = Integer.min((int)(pretaxAmount), 64900)*0.057;
        EI = Integer.min((int)(pretaxAmount), 60300)*0.0158;
       
        double post = pretaxAmount - (prov_taxed + fed_taxed + EI + CPP);
        return post;

    }

    public static double reverse(double postTax){
        int[] FED_INTERVAL = {221708, 155625, 100392, 50197, 13229, 0};
        double[] ON_MARGINAL = {0.1316, 0.1216, 0.1116, 0.0915, 0.0505, 0};
        double[] FED_MARGINAL = {0.33, 0.29, 0.26, 0.205, 0.15, 0};
        int count;
        count = FED_INTERVAL.length - 1;
        for (int i = 0; i < FED_INTERVAL.length; i++){
            System.out.println(FED_INTERVAL[i] - postTax);
            System.out.println(income((double)(FED_INTERVAL[i])));
            if (income((double)(FED_INTERVAL[i])) < postTax){
                count = i;
                break;                
            }
        }
        double taxBreak = (double) (postTax - FED_INTERVAL[count])/(ON_MARGINAL[count] + FED_MARGINAL[count]);
        //System.out.println(taxBreak);
        //System.out.println(FED_INTERVAL[count]);
        return taxBreak + FED_INTERVAL[count];
    }
}

