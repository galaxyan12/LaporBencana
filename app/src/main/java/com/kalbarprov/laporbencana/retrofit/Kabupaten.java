package com.kalbarprov.laporbencana.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kabupaten {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("provinsi_id")
    @Expose
    private Integer provinsiId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("kabupaten")
    @Expose
    private String kabupaten;
    @SerializedName("kabupaten_id")
    @Expose
    private Integer kabupatenId;
    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;
    @SerializedName("koordinat_bujur")
    @Expose
    private String koordinatBujur;
    @SerializedName("koordinat_lintang")
    @Expose
    private String koordinatLintang;
    @SerializedName("ketinggian")
    @Expose
    private String ketinggian;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinsiId() {
        return provinsiId;
    }

    public void setProvinsiId(Integer provinsiId) {
        this.provinsiId = provinsiId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKoordinatBujur() {
        return koordinatBujur;
    }

    public void setKoordinatBujur(String koordinatBujur) {
        this.koordinatBujur = koordinatBujur;
    }

    public String getKoordinatLintang() {
        return koordinatLintang;
    }

    public void setKoordinatLintang(String koordinatLintang) {
        this.koordinatLintang = koordinatLintang;
    }

    public String getKetinggian() {
        return ketinggian;
    }

    public void setKetinggian(String ketinggian) {
        this.ketinggian = ketinggian;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
