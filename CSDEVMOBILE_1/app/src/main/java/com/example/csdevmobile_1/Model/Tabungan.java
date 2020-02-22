package com.example.csdevmobile_1.Model;

public class Tabungan {
    private String username;
    private Long saldo;
    private Long hutang;
    private Long piutang;
    private String satuan;

    public Tabungan(){

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Long getHutang() {
        return hutang;
    }

    public void setHutang(Long hutang) {
        this.hutang = hutang;
    }

    public Long getPiutang() {
        return piutang;
    }

    public void setPiutang(Long piutang) {
        this.piutang = piutang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
