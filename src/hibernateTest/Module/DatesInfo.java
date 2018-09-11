package hibernateTest.Module;

import hibernateTest.hibernateTest;

import java.util.Date;

/**
 * Created by wliu on 4/02/16.
 */
public class DatesInfo {
    private Date created;
    private Date modified;
    private Date expire;

    private Date cancelled;

    private Date suspended;

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public Date getExpire() {
        return expire;
    }

    public Date getCancelled() {
        return cancelled;
    }

    public Date getSuspended() {
        return suspended;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public void setCancelled(Date cancelled) {
        this.cancelled = cancelled;
    }

    public void setSuspended(Date suspended) {
        this.suspended = suspended;
    }
}
