package org.sample.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Scott on 6/11/2015.
 */
@Entity
//@Table("sample_data")
public class SampleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @NotNull
    @Size(max=255)
    private String greeting;

    @Basic
    @NotNull
    @Size(max=40)
    @Column(name="\"usage\"")
    private String usage;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    private Date dateCreated;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Version
    @Column(insertable = false)
    private Date dateModified;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public Date getCreateDate() {
        return dateCreated;
    }

    public Date getModifiedDate() {
        return dateModified;
    }
}
