public class Calculate {
    
    public static double income(double pretaxAmount){
        double[] ON_MARGINAL = {0.1316, 0.1216, 0.1116, 0.0915, 0.0505};
        double[] FED_MARGINAL = {0.33, 0.29, 0.26, 0.205, 0.15};
        int[] ON_INTERVAL= {220000, 150000, 92454, 46226, 0};
        int[] FED_INTERVAL = {221708, 155625, 100392, 50197, 0};
        double prov_taxed = 0;
        double fed_taxed = 0; 
        double FREE = 13229;
        
        //int indexnm = 0;
        /*
         * Separate the while loop into two loops, then calculate each accordingly. If you include in 
         * the same loop, it won't work. bc of the differential in when rates jump. You'll need to still calc
         * for the prev index in the array potentially.
         * 
         * while (indexnm < ON_MARGINAL.length){
            if (pretaxAmount >= FED_INTERVAL[indexnm]){
                prov_taxed = prov_taxed + (pretaxAmount - ON_INTERVAL[indexnm])*ON_MARGINAL[indexnm];
                fed_taxed = prov_taxed + (pretaxAmount - FED_INTERVAL[indexnm])*FED_MARGINAL[indexnm];
                //post = post + (pretaxAmount - ON_INTERVAL[indexnm])*(1 - ON_MARGINAL[indexnm]);
                //pretaxAmount = pretaxAmount - (pretaxAmount - ON_INTERVAL[indexnm]);
                //System.out.println(post);
                //System.out.println(pretaxAmount);
            } else if (pretaxAmount >= ON_INTERVAL[indexnm]){
                prov_taxed = prov_taxed + (pretaxAmount - ON_INTERVAL[indexnm])*ON_MARGINAL[indexnm];
            }
            indexnm++;
            }
         */
        
        double tempprov, tempfed;
        tempprov = tempfed = pretaxAmount;
        
        for (int i = 0; i < ON_MARGINAL.length; i++){
            if (tempprov <= FREE){
                tempprov = tempprov + 0;
            }
            else if (FREE < tempprov && tempprov <= ON_INTERVAL[3]){
                prov_taxed = prov_taxed + (tempprov - FREE)*ON_MARGINAL[i];
            }
            else if (tempprov >= ON_INTERVAL[i]){
                System.out.println(tempprov);
                System.out.println(prov_taxed);
                prov_taxed = prov_taxed + (tempprov - ON_INTERVAL[i])*ON_MARGINAL[i];
                tempprov = ON_INTERVAL[i];
            }
        }
        System.out.println(prov_taxed);
        for (int k = 0; k < FED_INTERVAL.length; k++){
            if (tempfed <= FREE){
                tempfed = tempfed + 0;
            }
            else if (FREE < tempfed && tempfed <= FED_INTERVAL[3]){
                fed_taxed = fed_taxed + (tempfed - FREE)*FED_MARGINAL[k];
            }
        
            else if (tempfed >= FED_INTERVAL[k]){
                fed_taxed = fed_taxed + (tempfed - FED_INTERVAL[k])*FED_MARGINAL[k];
                tempfed = FED_INTERVAL[k];
            }
        }
        //System.out.println(prov_taxed);
        //System.out.println(fed_taxed);


        double post = pretaxAmount - (prov_taxed + fed_taxed);
        return post;

    }
}
