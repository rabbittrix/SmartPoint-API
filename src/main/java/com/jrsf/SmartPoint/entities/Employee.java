package com.jrsf.SmartPoint.entities;

import com.jrsf.SmartPoint.enums.ProfileEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String password;
    private String nif;
    private BigDecimal hourValue;
    private Float qtdHourWorkDay;
    private Float qtdHourLunch;
    private ProfileEnum profile;
    private Date dateCreate;
    private Date dateUpdate;
    private Company company;
    private List<Accounting> accountings;

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "nif", nullable = false)
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Column(name = "Hour_Value", nullable = true)
    public BigDecimal getHourValue() {
        return hourValue;
    }

    @Transient
    public Optional<BigDecimal> getHourValueOpt(){
        return Optional.ofNullable(hourValue);
    }

    public void setHourValue(BigDecimal hourValue) {
        this.hourValue = hourValue;
    }

    @Column(name = "Qtd_Hour_Work_Day", nullable = true)
    public Float getQtdHourWorkDay() {
        return qtdHourWorkDay;
    }

    @Transient
    public Optional<Float> getQtdHourWorkDayOpt(){
        return Optional.ofNullable(qtdHourWorkDay);
    }

    public void setQtdHourWorkDay(Float qtdHourWorkDay) {
        this.qtdHourWorkDay = qtdHourWorkDay;
    }

    @Column(name = "Qtd_Hour_Lunch", nullable = true)
    public Float getQtdHourLunch() {
        return qtdHourLunch;
    }

    @Transient
    public Optional<Float> getQtdHourLunchOpt(){
        return Optional.ofNullable(qtdHourLunch);
    }

    public void setQtdHourLunch(Float qtdHourLunch) {
        this.qtdHourLunch = qtdHourLunch;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }

    @Column(name = "Date_Create", nullable = false)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Column(name = "Date_Update", nullable = false)
    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Company getCompany(){
        return company;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Accounting> getAccountings() {
        return accountings;
    }

    public void setAccountings(List<Accounting> accountings) {
        this.accountings = accountings;
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nif='" + nif + '\'' +
                ", hourValue=" + hourValue +
                ", qtdHourWorkDay=" + qtdHourWorkDay +
                ", qtdHourLunch=" + qtdHourLunch +
                ", profile=" + profile +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                ", company=" + company +
                '}';
    }
}
