package hibernateTest.Module;

/**
 * Created by wliu on 8/02/16.
 */
public class CreditCardAccount extends BillingAccount{
    private String cardDigits;
    private long  cardExpireMonth;
    private long  cardExpireYear;
    private String cardType;
    private String cardOwner;
    private String tempcardDigits;
    private Boolean  crypt;
    private String bin;
    private String obscured;

    public String getCardDigits() {
        return cardDigits;
    }

    public long getCardExpireMonth() {
        return cardExpireMonth;
    }

    public long getCardExpireYear() {
        return cardExpireYear;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public String getTempcardDigits() {
        return tempcardDigits;
    }

    public boolean isCrypt() {
        return crypt;
    }

    public String getBin() {
        return bin;
    }

    public String getObscured() {
        return obscured;
    }

    public void setCardDigits(String cardDigits) {
        this.cardDigits = cardDigits;
    }

    public void setCardExpireMonth(long cardExpireMonth) {
        this.cardExpireMonth = cardExpireMonth;
    }

    public void setCardExpireYear(long cardExpireYear) {
        this.cardExpireYear = cardExpireYear;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public void setTempcardDigits(String tempcardDigits) {
        this.tempcardDigits = tempcardDigits;
    }

    public void setCrypt(Boolean crypt) {
        if(crypt == null ) {
            this.crypt = false;
        }else{
            this.crypt = crypt;
        }

    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void setObscured(String obscured) {
        this.obscured = obscured;
    }
}
