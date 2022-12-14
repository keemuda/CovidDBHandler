/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviddbhandler;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chayodom
 */
@Entity
@Table(name = "COVIDWEEK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Covidweek.findAll", query = "SELECT c FROM Covidweek c"),
    @NamedQuery(name = "Covidweek.findBySeq", query = "SELECT c FROM Covidweek c WHERE c.seq = :seq"),
    @NamedQuery(name = "Covidweek.findByCovidyear", query = "SELECT c FROM Covidweek c WHERE c.covidyear = :covidyear"),
    @NamedQuery(name = "Covidweek.findByWeeknum", query = "SELECT c FROM Covidweek c WHERE c.weeknum = :weeknum"),
    @NamedQuery(name = "Covidweek.findByNewCase", query = "SELECT c FROM Covidweek c WHERE c.newCase = :newCase"),
    @NamedQuery(name = "Covidweek.findByTotalCase", query = "SELECT c FROM Covidweek c WHERE c.totalCase = :totalCase"),
    @NamedQuery(name = "Covidweek.findByNewCaseExcludeabroad", query = "SELECT c FROM Covidweek c WHERE c.newCaseExcludeabroad = :newCaseExcludeabroad"),
    @NamedQuery(name = "Covidweek.findByTotalCaseExcludeabroad", query = "SELECT c FROM Covidweek c WHERE c.totalCaseExcludeabroad = :totalCaseExcludeabroad"),
    @NamedQuery(name = "Covidweek.findByNewRecovered", query = "SELECT c FROM Covidweek c WHERE c.newRecovered = :newRecovered"),
    @NamedQuery(name = "Covidweek.findByTotalRecovered", query = "SELECT c FROM Covidweek c WHERE c.totalRecovered = :totalRecovered"),
    @NamedQuery(name = "Covidweek.findByNewDeath", query = "SELECT c FROM Covidweek c WHERE c.newDeath = :newDeath"),
    @NamedQuery(name = "Covidweek.findByTotalDeath", query = "SELECT c FROM Covidweek c WHERE c.totalDeath = :totalDeath"),
    @NamedQuery(name = "Covidweek.findByCaseForeign", query = "SELECT c FROM Covidweek c WHERE c.caseForeign = :caseForeign"),
    @NamedQuery(name = "Covidweek.findByCasePrison", query = "SELECT c FROM Covidweek c WHERE c.casePrison = :casePrison"),
    @NamedQuery(name = "Covidweek.findByCaseWalkin", query = "SELECT c FROM Covidweek c WHERE c.caseWalkin = :caseWalkin"),
    @NamedQuery(name = "Covidweek.findByCaseNewPrev", query = "SELECT c FROM Covidweek c WHERE c.caseNewPrev = :caseNewPrev"),
    @NamedQuery(name = "Covidweek.findByCaseNewDiff", query = "SELECT c FROM Covidweek c WHERE c.caseNewDiff = :caseNewDiff"),
    @NamedQuery(name = "Covidweek.findByDeathNewPrev", query = "SELECT c FROM Covidweek c WHERE c.deathNewPrev = :deathNewPrev"),
    @NamedQuery(name = "Covidweek.findByDeathNewDiff", query = "SELECT c FROM Covidweek c WHERE c.deathNewDiff = :deathNewDiff"),
    @NamedQuery(name = "Covidweek.findByUpdateDate", query = "SELECT c FROM Covidweek c WHERE c.updateDate = :updateDate")})
public class Covidweek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEQ")
    private Integer seq;
    @Column(name = "COVIDYEAR")
    private Integer covidyear;
    @Column(name = "WEEKNUM")
    private Integer weeknum;
    @Column(name = "NEW_CASE")
    private Integer newCase;
    @Column(name = "TOTAL_CASE")
    private Integer totalCase;
    @Column(name = "NEW_CASE_EXCLUDEABROAD")
    private Integer newCaseExcludeabroad;
    @Column(name = "TOTAL_CASE_EXCLUDEABROAD")
    private Integer totalCaseExcludeabroad;
    @Column(name = "NEW_RECOVERED")
    private Integer newRecovered;
    @Column(name = "TOTAL_RECOVERED")
    private Integer totalRecovered;
    @Column(name = "NEW_DEATH")
    private Integer newDeath;
    @Column(name = "TOTAL_DEATH")
    private Integer totalDeath;
    @Column(name = "CASE_FOREIGN")
    private Integer caseForeign;
    @Column(name = "CASE_PRISON")
    private Integer casePrison;
    @Column(name = "CASE_WALKIN")
    private Integer caseWalkin;
    @Column(name = "CASE_NEW_PREV")
    private Integer caseNewPrev;
    @Column(name = "CASE_NEW_DIFF")
    private Integer caseNewDiff;
    @Column(name = "DEATH_NEW_PREV")
    private Integer deathNewPrev;
    @Column(name = "DEATH_NEW_DIFF")
    private Integer deathNewDiff;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Covidweek() {
    }
    
    public Covidweek( Integer covidyear, Integer weeknum, Integer newCase, Integer totalCase, Integer newCaseExcludeabroad, Integer totalCaseExcludeabroad, Integer newRecovered, Integer totalRecovered, Integer newDeath, Integer totalDeath, Integer caseForeign, Integer casePrison, Integer caseWalkin, Integer caseNewPrev, Integer caseNewDiff, Integer deathNewPrev, Integer deathNewDiff, Date updateDate) {
       
        this.covidyear = covidyear;
        this.weeknum = weeknum;
        this.newCase = newCase;
        this.totalCase = totalCase;
        this.newCaseExcludeabroad = newCaseExcludeabroad;
        this.totalCaseExcludeabroad = totalCaseExcludeabroad;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
        this.newDeath = newDeath;
        this.totalDeath = totalDeath;
        this.caseForeign = caseForeign;
        this.casePrison = casePrison;
        this.caseWalkin = caseWalkin;
        this.caseNewPrev = caseNewPrev;
        this.caseNewDiff = caseNewDiff;
        this.deathNewPrev = deathNewPrev;
        this.deathNewDiff = deathNewDiff;
        this.updateDate = updateDate;
    }

    public Covidweek(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getCovidyear() {
        return covidyear;
    }

    public void setCovidyear(Integer covidyear) {
        this.covidyear = covidyear;
    }

    public Integer getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Integer weeknum) {
        this.weeknum = weeknum;
    }

    public Integer getNewCase() {
        return newCase;
    }

    public void setNewCase(Integer newCase) {
        this.newCase = newCase;
    }

    public Integer getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(Integer totalCase) {
        this.totalCase = totalCase;
    }

    public Integer getNewCaseExcludeabroad() {
        return newCaseExcludeabroad;
    }

    public void setNewCaseExcludeabroad(Integer newCaseExcludeabroad) {
        this.newCaseExcludeabroad = newCaseExcludeabroad;
    }

    public Integer getTotalCaseExcludeabroad() {
        return totalCaseExcludeabroad;
    }

    public void setTotalCaseExcludeabroad(Integer totalCaseExcludeabroad) {
        this.totalCaseExcludeabroad = totalCaseExcludeabroad;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Integer getNewDeath() {
        return newDeath;
    }

    public void setNewDeath(Integer newDeath) {
        this.newDeath = newDeath;
    }

    public Integer getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(Integer totalDeath) {
        this.totalDeath = totalDeath;
    }

    public Integer getCaseForeign() {
        return caseForeign;
    }

    public void setCaseForeign(Integer caseForeign) {
        this.caseForeign = caseForeign;
    }

    public Integer getCasePrison() {
        return casePrison;
    }

    public void setCasePrison(Integer casePrison) {
        this.casePrison = casePrison;
    }

    public Integer getCaseWalkin() {
        return caseWalkin;
    }

    public void setCaseWalkin(Integer caseWalkin) {
        this.caseWalkin = caseWalkin;
    }

    public Integer getCaseNewPrev() {
        return caseNewPrev;
    }

    public void setCaseNewPrev(Integer caseNewPrev) {
        this.caseNewPrev = caseNewPrev;
    }

    public Integer getCaseNewDiff() {
        return caseNewDiff;
    }

    public void setCaseNewDiff(Integer caseNewDiff) {
        this.caseNewDiff = caseNewDiff;
    }

    public Integer getDeathNewPrev() {
        return deathNewPrev;
    }

    public void setDeathNewPrev(Integer deathNewPrev) {
        this.deathNewPrev = deathNewPrev;
    }

    public Integer getDeathNewDiff() {
        return deathNewDiff;
    }

    public void setDeathNewDiff(Integer deathNewDiff) {
        this.deathNewDiff = deathNewDiff;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seq != null ? seq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Covidweek)) {
            return false;
        }
        Covidweek other = (Covidweek) object;
        if ((this.seq == null && other.seq != null) || (this.seq != null && !this.seq.equals(other.seq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coviddbhandler.Covidweek[ seq=" + seq + " ]";
    }
    
}
