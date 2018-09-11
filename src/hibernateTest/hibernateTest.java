package hibernateTest;

import hibernateTest.Module.CreditCardAccount;
import hibernateTest.Module.Domain;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by wliu on 28/01/16.
 */
public class hibernateTest {

    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernateTest/hibernateCfg/hibernate.cfg.xml");
//          cfg.addResource("Domain.hbm.xml");
//          or
//          cfg.configure(); //auto find hibernate.cfm.xml file
            SessionFactory factory = cfg.buildSessionFactory();
            Session s = factory.openSession();
            Transaction tx = s.beginTransaction();

          /*  Domain domainDetail = loadDomainById(2274399l, s);
            System.out.println(domainDetail.getDomain());
            domainDetail.getTechUser().setFirstName("John");
            s.save(domainDetail);*/

            List<Domain> domainDetails = findDomainCreatedBy2016(s);

            domainDetails.stream().limit(5).forEach(d -> System.out.println(d.getDomain()));


            /*CreditCardAccount c = findCreditCardAccountById(707202l,s);
            System.out.println(c.getCardDigits());
            System.out.println(c.getCardExpireMonth());
            System.out.println(c.getCardExpireYear());
            System.out.println(c.getGreenCode());
            System.out.println(c.getCreationDate());
            System.out.println(c.getCardOwner());
            System.out.println(c.getCardType());
*/

           /* String hql = "From Domain d where d.domainId = :domain_id";
            Query q = s.createQuery(hql);
            q.setParameter("domain_id",2969783l);
            Domain domainDetail = (Domain)q.list().get(0);
            System.out.println(domainDetail.getDomain());*/


           /* String updateHQL = "UPDATE Domain d SET d.domain = :domain_name where d.domainId = 2969783";
            Query q = s.createQuery(updateHQL);
            q.setParameter("domain_name", "teamfit.com.au");
            int result = q.executeUpdate();
            System.out.println(result);*/

            /*Domain d = findDomainByName(s,"smallbusinesstasmania.biz");
            System.out.println(d.getVirtualisationId());*/

            tx.commit();
            s.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Domain loadDomainById(long domainId,Session s) throws Exception{
        return s.load(Domain.class,domainId);
    }
    public static List<Domain> findDomainCreatedBy2016(Session s) {
        Query q = s.getNamedQuery("findDomainCraetedBy2016").setMaxResults(10);
        List <Domain> domainList = (List <Domain>) q.list();
        return domainList;
    }
    public static Domain findDomainByName(Session s,String domain) throws Exception{
        Query q = s.getNamedQuery("findDomainByDomainName");
        q.setString(0, domain);
        List <Domain> domainList = (List <Domain>) q.list();
        System.out.println("size:"+domainList.size());
        if(domainList.size() == 1)
            return domainList.get(0);
        else throw new Exception("domain not found or multiple domain found for " + domain);
    }
    public static CreditCardAccount findCreditCardAccountById(long billingAccountId, Session s) throws Exception{
        Query q = s.getNamedQuery("findCreditCardAccountById");
        q.setLong(0, billingAccountId);
        List <CreditCardAccount> creditCardAccountList = (List <CreditCardAccount>) q.list();
        if(creditCardAccountList.size() > 0 ) {
            return creditCardAccountList.get(0);
        }
        else throw new Exception("account not found for " + billingAccountId);

    }


}
