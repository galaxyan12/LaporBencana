package com.kalbarprov.laporbencana.retrofit;

public class GetKabupaten {

    private int id;
    private int provinsi_id;
    private String status;
    private String kabupaten;
    private String koordinat_bujur;
    private String koordinat_lintang;
    private String ketinggian;
    private String keterangan;
    private String created_at;
    private String updated_at;

    public GetKabupaten(Integer id, Integer provinsi_id, String status, String kabupaten, String koordinat_bujur, String koordinat_lintang, String ketinggian, String keterangan, String created_at, String updated_at) {
        this.id = id;
        this.provinsi_id = provinsi_id;
        this.status = status;
        this.kabupaten = kabupaten;
        this.koordinat_bujur = koordinat_bujur;
        this.koordinat_lintang = koordinat_lintang;
        this.ketinggian = ketinggian;
        this.keterangan = keterangan;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public Integer getProvinsi_id() {
        return provinsi_id;
    }

    public String getStatus() {
        return status;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public String getKoordinat_bujur() {
        return koordinat_bujur;
    }

    public String getKoordinat_lintang() {
        return koordinat_lintang;
    }

    public String getKetinggian() {
        return ketinggian;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
