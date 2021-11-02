package com.kalbarprov.laporbencana;

public class DetailBencana {

    private String JenisBencana;
    private String Kabupaten;
    private String Kecamatan;
    private String Kelurahan;
    private String Koordinat;
    private String Pelapor;
    private String InfoKorban;
    private String SebabBencana;
    private String Bantuan;
    private String ResponInstansi;
    private String LokasiPengungsian;
    private String RincianPengungsian;
    private String PermintaanBantuan;

    public DetailBencana(String jenisBencana, String kabupaten, String kecamatan, String kelurahan, String koordinat, String pelapor, String infoKorban, String sebabBencana, String bantuan, String responInstansi, String lokasiPengungsian, String rincianPengungsian, String permintaanBantuan) {
        JenisBencana = jenisBencana;
        Kabupaten = kabupaten;
        Kecamatan = kecamatan;
        Kelurahan = kelurahan;
        Koordinat = koordinat;
        Pelapor = pelapor;
        InfoKorban = infoKorban;
        SebabBencana = sebabBencana;
        Bantuan = bantuan;
        ResponInstansi = responInstansi;
        LokasiPengungsian = lokasiPengungsian;
        RincianPengungsian = rincianPengungsian;
        PermintaanBantuan = permintaanBantuan;
    }

    public String getJenisBencana() {
        return JenisBencana;
    }

    public String getKabupaten() {
        return Kabupaten;
    }

    public String getKecamatan() {
        return Kecamatan;
    }

    public String getKelurahan() {
        return Kelurahan;
    }

    public String getKoordinat() {
        return Koordinat;
    }

    public String getPelapor() {
        return Pelapor;
    }

    public String getInfoKorban() {
        return InfoKorban;
    }

    public String getSebabBencana() {
        return SebabBencana;
    }

    public String getBantuan() {
        return Bantuan;
    }

    public String getResponInstansi() {
        return ResponInstansi;
    }

    public String getLokasiPengungsian() {
        return LokasiPengungsian;
    }

    public String getRincianPengungsian() {
        return RincianPengungsian;
    }

    public String getPermintaanBantuan() {
        return PermintaanBantuan;
    }
}
