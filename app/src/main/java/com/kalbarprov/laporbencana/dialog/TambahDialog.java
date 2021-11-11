package com.kalbarprov.laporbencana.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.kalbarprov.laporbencana.LoginActivity;
import com.kalbarprov.laporbencana.R;
import com.kalbarprov.laporbencana.retrofit.Kabupaten;

import java.util.ArrayList;
import java.util.List;

public class TambahDialog extends AppCompatDialogFragment {

    private EditText editKoordinat, editPelapor, editInfoKorban,
            editSebabBencana, editBantuan, editResponInstansi,
            editLokasiPengungsian, editRincianPengungsian, editPermintaanBantuan;

    private Spinner kabupaten;
    private RecyclerView.Adapter adKabupaten;
    public List<Kabupaten> kabupatenList = new ArrayList<>();
    Context ApplicationContext = LoginActivity.getAppContext();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_tambah, null);

        builder.setView(view)
                .setTitle("Lapor Bencana")
                .setNegativeButton("Batal", (dialog, i) -> {

                })
                .setPositiveButton("Lapor", (dialog, i) -> {

                });

        editKoordinat = view.findViewById(R.id.edit_koordinat);
        editPelapor = view.findViewById(R.id.edit_pelapor);
        editInfoKorban = view.findViewById(R.id.edit_infoKorban);
        editSebabBencana = view.findViewById(R.id.edit_sebabBencana);
        editBantuan = view.findViewById(R.id.edit_bantuan);
        editResponInstansi = view.findViewById(R.id.edit_responInstansi);
        editLokasiPengungsian = view.findViewById(R.id.edit_lokasiPengungsian);
        editRincianPengungsian = view.findViewById(R.id.edit_rincianPengungsian);
        editPermintaanBantuan = view.findViewById(R.id.edit_permintaanBantuan);
        return builder.create();
    }
}
