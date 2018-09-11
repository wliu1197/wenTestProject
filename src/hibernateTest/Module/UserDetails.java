package hibernateTest.Module;

import com.sun.istack.internal.NotNull;
import hibernateTest.hibernateTest;

import java.util.Date;

/**
 * Created by wliu on 4/02/16.
 */
public class UserDetails {

    private Long userId;
    private String greencode;
    private String jobTitle;
    private String organisation;
    private String title;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String postcode;
    @NotNull
    private String country;
    @NotNull
    private String phone;
    private String fax;
    private String mobile;
    private String email;
    private String secondaryEmail;
    private String url;
    private java.util.Date created;
    private java.util.Date modified;
    private boolean marketing;
    private boolean resellerClient;
    private String pdUserId;
    private Long accountId;

    public Long getUserId() {
        return userId;
    }

    public String getGreencode() {
        return greencode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getAddress4() {
        return address4;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public boolean isMarketing() {
        return marketing;
    }

    public boolean isResellerClient() {
        return resellerClient;
    }

    public String getPdUserId() {
        return pdUserId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setGreencode(String greencode) {
        this.greencode = greencode;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setMarketing(boolean marketing) {
        this.marketing = marketing;
    }

    public void setResellerClient(boolean resellerClient) {
        this.resellerClient = resellerClient;
    }

    public void setPdUserId(String pdUserId) {
        this.pdUserId = pdUserId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
