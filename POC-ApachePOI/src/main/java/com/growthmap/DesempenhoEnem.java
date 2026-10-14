package com.growthmap;

public class DesempenhoEnem {
    private String municipio;
    private String uf;
    private Double notaRedacao;
    private Double notaCn;
    private Double notaCh;
    private Double notaLc;
    private Double notaMt;
    private Integer tpLingua;

    public DesempenhoEnem() {
    }

    public DesempenhoEnem(String municipio, String uf, Double notaRedacao, Double notaCn, Double notaCh, Double notaLc, Double notaMt, Integer tpLingua) {
        this.municipio = municipio;
        this.uf = uf;
        this.notaRedacao = notaRedacao;
        this.notaCn = notaCn;
        this.notaCh = notaCh;
        this.notaLc = notaLc;
        this.notaMt = notaMt;
        this.tpLingua = tpLingua;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Double getNotaRedacao() {
        return notaRedacao;
    }

    public void setNotaRedacao(Double notaRedacao) {
        this.notaRedacao = notaRedacao;
    }

    public Double getNotaCn() {
        return notaCn;
    }

    public void setNotaCn(Double notaCn) {
        this.notaCn = notaCn;
    }

    public Double getNotaCh() {
        return notaCh;
    }

    public void setNotaCh(Double notaCh) {
        this.notaCh = notaCh;
    }

    public Double getNotaLc() {
        return notaLc;
    }

    public void setNotaLc(Double notaLc) {
        this.notaLc = notaLc;
    }

    public Double getNotaMt() {
        return notaMt;
    }

    public void setNotaMt(Double notaMt) {
        this.notaMt = notaMt;
    }

    public Integer getTpLingua() {
        return tpLingua;
    }

    public void setTpLingua(Integer tpLingua) {
        this.tpLingua = tpLingua;
    }

    @Override
    public String toString() {
        return "DesempenhoEnem{" +
                "municipio='" + municipio + '\'' +
                ", uf='" + uf + '\'' +
                ", notaRedacao=" + notaRedacao +
                ", notaCn=" + notaCn +
                ", notaCh=" + notaCh +
                ", notaLc=" + notaLc +
                ", notaMt=" + notaMt +
                ", tpLingua=" + tpLingua +
                '}';
    }
}
