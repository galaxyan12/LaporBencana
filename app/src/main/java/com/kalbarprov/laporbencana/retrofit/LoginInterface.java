package com.kalbarprov.laporbencana.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> userLogin(@Field("email") String email,
                               @Field("password") String password);

    @FormUrlEncoded
    @POST("laporan/create")
    Call<LaporanResponse> postingLaporan(@Header("Authorization") String token,
                                         @Field("bencana_id") Integer bencana_id,
                                         @Field("desa_id") Integer desa_id,
                                         @Field("koordinat") String koordinat,
                                         @Field("korban_kk") String korban_kk,
                                         @Field("korban_orang") String korban_orang,
                                         @Field("sebab_bencana") String sebab_bencana,
                                         @Field("bantuan_diperlukan") String bantuan_diperlukan,
                                         @Field("respon_instansi") String respon_instansi,
                                         @Field("lokasi_pengungsian") String lokasi_pengungsian,
                                         @Field("pengungsi_kk") String pengungsi_kk,
                                         @Field("pengungsi_orang") String pengungsi_orang,
                                         @Field("permintaan_bantuan") String permintaan_bantuan);

    @POST("laporan/create")
    Call<LaporanResponse> postLaporan(@Header("Authorization") String token, @Body LaporanRequest laporanRequest);

    @GET("laporan")
    Call<LaporanModel> getLaporanData(@Header("Authorization") String token);

    @GET("get_kabupaten/1")
    Call<KabupatenModel> getKabupatenData(@Header("Authorization") String token);

    @GET("get_kecamatan/1")
    Call<KecamatanModel> getKecamatanData(@Header("Authorization") String token);

    @GET("get_kelurahan/1")
    Call<DesaModel> getDesaData(@Header("Authorization") String token);

}
