package com.jrsf.SmartPoint.entities;

import com.jrsf.SmartPoint.enums.TypesEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "accounting")
public class Accounting implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date date;
    private String description;
    private String Localization;
    private Date dateCreate;
    private Date dateUpdate;
    private TypesEnum type;
    private Employee employee;

    public Accounting() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "localization", nullable = false)
    public String getLocalization() {
        return Localization;
    }

    public void setLocalization(String localization) {
        Localization = localization;
    }

    @Column(name = "date_create", nullable = false)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Column(name = "date_update", nullable = false)
    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    public TypesEnum getType() {
        return type;
    }

    public void setType(TypesEnum type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @PreUpdate
    public void preUpdate(){
        dateUpdate = new Date();
    }

    @PrePersist
    public void prePersist(){
        final Date current = new Date();
        dateCreate = current;
        dateUpdate = current;
    }

    @Override
    public String toString() {
        return "Accounting{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", Localization='" + Localization + '\'' +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                ", type=" + type +
                ", employee=" + employee +
                '}';
    }
}
