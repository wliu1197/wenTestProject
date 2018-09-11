import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

public class o365SetUp {
    public static String query = "\n";
    public static String fileName = "O365-result.txt";
    public static int domainProductStartId = 2665274;
    public static int domain_serviceStartId = 8960000;
    public static int domain_service_params_StartId = 35337810;
    public static TreeMap<String,String> productCodeIdMap = new TreeMap<String, String>();

    public static void main(String [] args) throws FileNotFoundException {

        productCodeIdMap.put("O365-BPREM-1","115865");
        productCodeIdMap.put("O365-BPREM-2","115866");
        productCodeIdMap.put("O365-BPREM-3","115867");
        productCodeIdMap.put("O365-BPREM-4","115868");
        productCodeIdMap.put("O365-BPREM-5","115869");
        productCodeIdMap.put("O365-BPREM-6","115870");
        productCodeIdMap.put("O365-BPREM-7","115871");
        productCodeIdMap.put("O365-BPREM-8","115872");
        productCodeIdMap.put("O365-BPREM-9","115873");
        productCodeIdMap.put("O365-BPREM-10","115874");

        productCodeIdMap.put("O365-BESSEN-1","115875");
        productCodeIdMap.put("O365-BESSEN-2","115876");
        productCodeIdMap.put("O365-BESSEN-3","115877");
        productCodeIdMap.put("O365-BESSEN-4","115878");
        productCodeIdMap.put("O365-BESSEN-5","115879");
        productCodeIdMap.put("O365-BESSEN-6","115880");
        productCodeIdMap.put("O365-BESSEN-7","115881");
        productCodeIdMap.put("O365-BESSEN-8","115882");
        productCodeIdMap.put("O365-BESSEN-9","115883");
        productCodeIdMap.put("O365-BESSEN-10","115884");

        productCodeIdMap.put("O365-SMPLE-1","115885");
        productCodeIdMap.put("O365-SMPLE-2","115886");
        productCodeIdMap.put("O365-SMPLE-3","115887");
        productCodeIdMap.put("O365-SMPLE-4","115888");
        productCodeIdMap.put("O365-SMPLE-5","115889");
        productCodeIdMap.put("O365-SMPLE-6","115890");
        productCodeIdMap.put("O365-SMPLE-7","115891");
        productCodeIdMap.put("O365-SMPLE-8","115892");
        productCodeIdMap.put("O365-SMPLE-9","115893");
        productCodeIdMap.put("O365-SMPLE-10","115894");

        Iterator it = productCodeIdMap.entrySet().iterator();
        while(it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();
            String numberOflicense = pair.getKey().toString().split("-")[pair.getKey().toString().split("-").length-1];
            int serviceId = 0;
            if(pair.getKey().toString().contains("BPREM")) {
                serviceId = 101114;
            }else if(pair.getKey().toString().contains("BESSEN")) {
                serviceId = 101115;
            }else {
                serviceId = 101116;
            }
            int serviceParamId = 210039;
            if(pair.getKey().toString().contains("BPREM")) {
                serviceParamId = 210039;
            }else if(pair.getKey().toString().contains("BESSEN")) {
                serviceParamId = 210040;
            }else {
                serviceParamId = 210041;
            }

            try {
                Scanner in = new Scanner(new FileReader(pair.getKey() + ".txt"));
                String ids = in.next();
                LinkedList<String> domainIdList = new LinkedList<String>(Arrays.asList(ids.split(",")));
                query += "--"+pair.getKey()+" domain products set up" +"\n";
                for (String Id : domainIdList) {
                    query += "insert into domain_product (domain_product_id,domain_id,product_id)" +
                            "values (" + domainProductStartId + "," + Id + ","+ pair.getValue()+");" + "\n";

                    query += "insert into domain_service(domain_service_id,domain_id,service_id,remote_servicename,product_id,active)" +
                             "values (" + domain_serviceStartId + "," + Id + ","+serviceId +",'OFFICE365'," + pair.getValue() + ",true);" + "\n";

                    query += "insert into domain_service_params (domain_service_param_id,domain_service_id,domain_id,param_value,service_param_id)" +
                             "values (" + domain_service_params_StartId+","+domain_serviceStartId+","+Id+","+numberOflicense+ ","+serviceParamId+");" +"\n";
                    domainProductStartId++;
                    domain_serviceStartId++;
                    domain_service_params_StartId++;
                }

            }catch(FileNotFoundException e) {
                System.out.println("no file found for " + pair.getKey() + ".txt");
                continue;
            }catch (Exception e) {
                continue;
            }

        }
        PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName), true));
        writer.println(query);
        writer.close();



    }
    public static void ignoreName() {
        HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
            public boolean verify(String hostname,
                                  javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("stage-public.provisioning-api.melbourneit.com.au")) {
                    return true;
                }
                return false;
            }
        });
    }
}
