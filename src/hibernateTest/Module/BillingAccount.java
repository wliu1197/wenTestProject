package hibernateTest.Module;

import hibernateTest.hibernateTest;

import java.util.Date;

/**
 * Created by wliu on 8/02/16.
 */
public class BillingAccount {
    private long billingAccountId;
    private Date creationDate;
    private String greenCode;

    public long getBillingAccountId() {
        return billingAccountId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getGreenCode() {
        return greenCode;
    }

    public void setBillingAccountId(long billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setGreenCode(String greenCode) {
        this.greenCode = greenCode;
    }
}
