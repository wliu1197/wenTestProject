package hibernateTest.Module;

/**
 * Created by wliu on 28/01/16.
 */
public class Domain {
    private Long domainId;

    private String domain;

    private String suspensionReason;

    private String suspendedBy;

    private Long virtualisationId;

    //for .edu.au
    private String eligibilityType;

    // for DIT reseller.
    private String categoryTag;


    private String acquiredTag;

    private DatesInfo datesInfo;

    private boolean autoRenew = false;
    private boolean autoRenewWholesale = false;

    private UserDetails techUser;

    public UserDetails getTechUser() {
        return techUser;
    }

    public Long getDomainId() {
        return domainId;
    }

    public String getDomain() {
        return domain;
    }

    public String getSuspensionReason() {
        return suspensionReason;
    }

    public String getSuspendedBy() {
        return suspendedBy;
    }

    public Long getVirtualisationId() {
        return virtualisationId;
    }

    public String getEligibilityType() {
        return eligibilityType;
    }

    public DatesInfo getDatesInfo() {
        return datesInfo;
    }

    public String getCategoryTag() {
        return categoryTag;
    }

    public String getAcquiredTag() {
        return acquiredTag;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public boolean isAutoRenewWholesale() {
        return autoRenewWholesale;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setSuspensionReason(String suspensionReason) {
        this.suspensionReason = suspensionReason;
    }

    public void setSuspendedBy(String suspendedBy) {
        this.suspendedBy = suspendedBy;
    }

    public void setVirtualisationId(Long virtualisationId) {
        this.virtualisationId = virtualisationId;
    }

    public void setEligibilityType(String eligibilityType) {
        this.eligibilityType = eligibilityType;
    }

    public void setCategoryTag(String categoryTag) {
        this.categoryTag = categoryTag;
    }

    public void setAcquiredTag(String acquiredTag) {
        this.acquiredTag = acquiredTag;
    }

    public void setAutoRenew(boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

    public void setAutoRenewWholesale(boolean autoRenewWholesale) {
        this.autoRenewWholesale = autoRenewWholesale;
    }

    public void setTechUser(UserDetails techUser) {
        this.techUser = techUser;
    }

    public void setDatesInfo(DatesInfo datesInfo) {
        this.datesInfo = datesInfo;
    }
}
