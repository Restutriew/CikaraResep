package com.cikarastudio.cikararesep.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cikarastudio.cikararesep.Adapter.DataAdapter;
import com.cikarastudio.cikararesep.Adapter.DataKategoriAdapter;
import com.cikarastudio.cikararesep.Dialog.LoadingDialog;
import com.cikarastudio.cikararesep.Model.ModelDataKategori;
import com.cikarastudio.cikararesep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListResepActivity extends AppCompatActivity {

    private ArrayList<ModelDataKategori> dataKategoriList;
    RecyclerView recyclerViewKategori;
    DataKategoriAdapter dataKategoriAdapter;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resep);

        loadingDialog = new LoadingDialog(ListResepActivity.this);
        loadingDialog.startLoading();
        dataKategoriList = new ArrayList<>();
        recyclerViewKategori = findViewById(R.id.rv_listData);
        recyclerViewKategori.setHasFixedSize(true);

        load_dataKategori();

    }

    private void load_dataKategori() {
        String URL_READBOOKING = "https://kingdom.cikarastudio.com/webservice/kategori/kategoriresep";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_READBOOKING,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id").trim();
                                    String nama = object.getString("nama_kategori").trim();
                                    String icon = object.getString("icon_kategori").trim();


                                    dataKategoriList.add(new ModelDataKategori(id, nama, icon));
                                    recyclerViewKategori.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                    dataKategoriAdapter = new DataKategoriAdapter(getApplicationContext(), dataKategoriList);
                                    recyclerViewKategori.setAdapter(dataKategoriAdapter);
//                                    dataKategoriAdapter.setOnItemClickCallback(new DataKategoriAdapter.OnItemClickCallback() {
//                                        @Override
//                                        public void onItemClicked(ModelDataKategori data) {
////                                            Toast.makeText(ListResepActivity.this, "Data Ada! " +data.getId(), Toast.LENGTH_SHORT).show();
////                                            Intent detaildata = new Intent(ListResepActivity.this, DeskripsiActivity.class);
////                                            detaildata.putExtra(DeskripsiActivity.EXTRA_DATA, data);
////                                            startActivity(detaildata);
//                                        }
//                                    });
                                    loadingDialog.dissmissDialog();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            loadingDialog.dissmissDialog();
                            Toast.makeText(ListResepActivity.this, "Data Tidak Ada! Pesan Error: ", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loadingDialog.dissmissDialog();
                Toast.makeText(ListResepActivity.this, "Koneksi Gagal! Pesan Error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
        };
        RequestQueue requestQueue = Volley.newRequestQueue(ListResepActivity.this);
        requestQueue.add(stringRequest);
    }
}