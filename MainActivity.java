package com.example.kasir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableRow;
import android.widget.Spinner;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private EditText edtjumlahbel, edtharga, edtuangbay, edttotalbelanja, edtuangkembali, edtketerangan;
    private Button btntambah;
    private Button btnhapus;
    private Button btnexit;
    private Button btnproses;

    private Spinner edtnamabar;
//    private Spinner edtsabun;
//    private  Spinner edtshampo;
//    private Spinner edtcuciPiring;
//    private Spinner edtsabunCuci;
//    private Spinner edtbumbu;
//    private Spinner edtbumbuGlondong;
//    private  Spinner edtcaos;
//    private  Spinner edtkecap;
//    private  Spinner edtmie;
//    private  Spinner edtminuman;
//    private  Spinner edtsembako;
//    private  Spinner edtobat;
//    private  Spinner edtrokok;
//    private  Spinner edtpampers;


    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbay;

    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    ArrayList<String> barang = new ArrayList<>();
//    ArrayList<String> isabun = new ArrayList<>();
//    ArrayList<String> ishampo = new ArrayList<>();
//    ArrayList<String> ibumbu = new ArrayList<>();
//    ArrayList<String> iscuci = new ArrayList<>();
//    ArrayList<String> icuci = new ArrayList<>();
//    ArrayList<String> isembako = new ArrayList<>();
//    ArrayList<String> icaos = new ArrayList<>();
//    ArrayList<String> ikecap = new ArrayList<>();
//    ArrayList<String> iobat = new ArrayList<>();
//    ArrayList<String> irokok = new ArrayList<>();
//    ArrayList<String> ipampers = new ArrayList<>();
//    ArrayList<String> iglondong = new ArrayList<>();
//    ArrayList<String> iminuman = new ArrayList<>();
//    ArrayList<String> imie = new ArrayList<>();

    ArrayList<Integer> jumlah = new ArrayList<>();
    ArrayList<Integer> hrg = new ArrayList<>();
    ArrayList<Integer> ttl = new ArrayList<>();

    ArrayList<String> jagan = new ArrayList<>();

    public String menu_barang;

    private TextView textview;
    private Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Kedai Anza");

//        edtnamabar = (Spinner) findViewById(R.id.namabarang);
//        edtsabun = (Spinner) findViewById(R.id.sabun);
//        edtcuciPiring = (Spinner) findViewById(R.id.cuciPiring);
//        edtsabunCuci = (Spinner) findViewById(R.id.sabunCuci);
//        edtshampo = (Spinner) findViewById(R.id.shampo);
//        edtbumbu = (Spinner) findViewById(R.id.bumbu);
//        edtbumbuGlondong = (Spinner) findViewById(R.id.bumbuGlondong);
//        edtcaos = (Spinner) findViewById(R.id.caos);
//        edtkecap = (Spinner) findViewById(R.id.kecap);
//        edtmie = (Spinner) findViewById(R.id.mie);
//        edtminuman = (Spinner) findViewById(R.id.minuman);
//        edtobat = (Spinner) findViewById(R.id.obat);
//        edtpampers = (Spinner) findViewById(R.id.pamapers);
//        edtrokok = (Spinner) findViewById(R.id.rokok);
//        edtsembako = (Spinner) findViewById(R.id.sembako);

        edtjumlahbel = (EditText) findViewById(R.id.jumlahbeli);
        edtharga = (EditText) findViewById(R.id.harga);
        edtuangbay = (EditText) findViewById(R.id.uangbayar);
        edttotalbelanja = (EditText) findViewById(R.id.totalbelanja);
        edtuangkembali = (EditText) findViewById(R.id.uangkembali);
        edtketerangan = (EditText) findViewById(R.id.keterangan);

        btntambah = (Button) findViewById(R.id.tombolTambah);
        btnhapus = (Button) findViewById(R.id.tombol2);
        btnexit = (Button) findViewById(R.id.tombol3);
        btnproses = (Button) findViewById(R.id.tombolProses);

//        txtnamabar = (TextView) findViewById(R.id.namabarang);
        txtjumlahbel = (TextView) findViewById(R.id.jumlahbeli);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbay = (TextView) findViewById(R.id.uangbayar);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtketerangan = (TextView) findViewById(R.id.keterangan);

//        edtnamabar.setOnItemSelectedListener(new ItemSelectedListener());
//        edtsabun.setOnItemSelectedListener(new ItemSabun());
//        edtshampo.setOnItemSelectedListener(new ItemShampo());
//        edtcuciPiring.setOnItemSelectedListener(new ItemcuciPiring());
//        edtsabunCuci.setOnItemSelectedListener(new ItemSabunCuci());
//        edtbumbu.setOnItemSelectedListener(new ItemBumbu());
//        edtbumbuGlondong.setOnItemSelectedListener(new ItemBumbuGlondong());
//        edtsembako.setOnItemSelectedListener(new ItemSembako());
//        edtrokok.setOnItemSelectedListener(new ItemRokok());
//        edtmie.setOnItemSelectedListener(new ItemMie());
//        edtminuman.setOnItemSelectedListener(new ItemMinuman());
//        edtcaos.setOnItemSelectedListener(new ItemCaos());
//        edtkecap.setOnItemSelectedListener(new ItemKecap());
//        edtpampers.setOnItemSelectedListener(new ItemPampers());
//        edtobat.setOnItemSelectedListener(new ItemObat());

//        List<String> isabun = new ArrayList<>();
//        isabun.add(0, "Sabun");
//        isabun.add("Lifeboy");
//        isabun.add("Nuvo Small");
//        isabun.add("Nuvo Medium");
//        isabun.add("ZEN");
//        isabun.add("Shinzui");
//        isabun.add("GIV");
//        isabun.add("Detol");
//        isabun.add("Odol");
//        isabun.add("Rexona Women");
//        isabun.add("Rexona Men");
//        isabun.add("Garnier Renceng");
//        isabun.add("Fair & Lovely");
//        isabun.add("Kapur Barus");
//
//        ArrayAdapter<String> dataAdapter;
//        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, isabun);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        edtsabun.setAdapter(dataAdapter);

//        edtsabun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
//                if(parent.getItemAtPosition(position).equals("Sabun")){
//                } else {
//                    String item  = parent.getItemAtPosition(position).toString();
////                    Toast.makeText(parent.getContext(), "Pilih : " + item, Toast.LENGTH_SHORT).show();
//                    jagan.add(item);
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
        textview = findViewById(R.id.testView);

        barang.add("---<SABUN>---");
        barang.add("Lifeboy");
        barang.add("Nuvo Small");
        barang.add("Nuvo Medium");
        barang.add("ZEN");
        barang.add("Shinzui");
        barang.add("GIV");
        barang.add("Detol");
        barang.add("Odol");
        barang.add("Rexona Women");
        barang.add("Rexona Men");
        barang.add("Garnier Renceng");
        barang.add("Fair & Lovely");
        barang.add("Kapur Barus");

        barang.add("---<SHAMPO>---");
        barang.add("Pantine Kondisioner");
        barang.add("Sunslik Kondisioner");
        barang.add("Zinc aneka macam");
        barang.add("Lifeboy aneka macam");
        barang.add("Head & Shoulder");
        barang.add("Pantine aneka macam");
        barang.add("Dove aneka macam");
        barang.add("Cleare aneka macam");
        barang.add("KIT");

        barang.add("---<SABUN CUCI PIRING>---");
        barang.add("Sunlight Small");
        barang.add("Sunlight Medium");
        barang.add("Mama Lemon Small");
        barang.add("Mama Lemon Medium");
        barang.add("Ekonomi Small");
        barang.add("Ekonomi Medium");
        barang.add("Ekonomi Big");

        barang.add("---<SABUN CUCI>---");
        barang.add("Rinso Bubuk");
        barang.add("Rinso Cair");
        barang.add("Soklin Liquid");
        barang.add("Soklin Bubuk Small");
        barang.add("Soklin Bubuk Medium");
        barang.add("Soklin Antiseptik");
        barang.add("Daia");
        barang.add("Jazz1");
        barang.add("Molto");
        barang.add("Downie");
        barang.add("Wipol");
        barang.add("Soklin Lantai");
        barang.add("Rapika");
        barang.add("Kispray Gold");
        barang.add("Kispray Biasa");

        barang.add("---<BUMBU>---");
        barang.add("Racik Nasi Goreng Ekstra Pedas");
        barang.add("Racik Nasi Goreng Biasa");
        barang.add("Racik Tempe");
        barang.add("Racik Ayam");
        barang.add("Racik Ikan");
        barang.add("Racik Sayur Asem");
        barang.add("Racik Sayur Sop");
        barang.add("Racik Sayur Lodeh");
        barang.add("Racik Kangkung");
        barang.add("Sajiku Tepung");
        barang.add("Saori Saus Tiram");
        barang.add("Desaku Sambel Goreng");
        barang.add("Desaku Balado");
        barang.add("Desaku Kari");
        barang.add("Desaku Ketumbar Bubuk");
        barang.add("Dapur Kita Ketumbar Bubuk");
        barang.add("Dapur Kita Balado");
        barang.add("Dapur Kita Jinten Bubuk");
        barang.add("Dapur Kita Bawang Putih Bubuk");
        barang.add("Dapur Kita Kayu Manis Bubuk");
        barang.add("Dapur Kita Kencur Bubuk");
        barang.add("Dapur Kita Kunyit");
        barang.add("Berlian Pala Bubuk");
        barang.add("Daisy Lada Bubuk");
        barang.add("Ladaku Merica Bubuk");
        barang.add("Uleg Sambel Terasi");
        barang.add("Bon Cabe");
        barang.add("Aida");
        barang.add("Mama Suka Kuah Bakso");
        barang.add("Terasi ABC");

        barang.add("---<BUMBU GLONDONG>---");
        barang.add("Gula Jawa Renceng");
        barang.add("Asem Renceng");
        barang.add("Bawang Putih Renceng");
        barang.add("Kemiri Renceng");
        barang.add("Merica Renceng");

        barang.add("---<CAOS>---");
        barang.add("ABC Small");
        barang.add("ABC Medium");
        barang.add("ABC Big");
        barang.add("Indofood Small");

        barang.add("---<KECAP>---");
        barang.add("Bango Medium");
        barang.add("Bango Big");
        barang.add("Sedap Small");
        barang.add("Sedap Big");
        barang.add("ABC Small");
        barang.add("ABC Big");

        barang.add("---<MIE INSTAN>---");
        barang.add("Sedap Goreng");
        barang.add("Sedap Ayam Limau");
        barang.add("Sedap Korea");
        barang.add("Sedap Kari");
        barang.add("Sedap Ayam Bawang");
        barang.add("Sedap Soto");
        barang.add("Sedap Bakso");
        barang.add("Sedap Singapure");
        barang.add("Indomie Goreng");
        barang.add("Indomie Rendang");
        barang.add("Indomie Ayam Geprek");
        barang.add("Indomie Aceh ");
        barang.add("Indomie Ayam Bawang Spesial");
        barang.add("Indomie Soto Banjar");
        barang.add("Indomie Seblak Jeletot");
        barang.add("Supermie Ayam Bawang");
        barang.add("Sarimi Ayam Bawang");
        barang.add("Sukses Ayam Kecap");
        barang.add("Sukses Ayam Kremes");
        barang.add("Sukses Soto");
        barang.add("Sukses Kari");
        barang.add("Sukses Ayam Bawang");

        barang.add("---<MINUMAN>---");
        barang.add("Lemineral 600ml");
        barang.add("Lemineral 330ml");
        barang.add("Susu Milku");
        barang.add("Susu kotak");
        barang.add("Larutan Botol");
        barang.add("Larutan Kaleng");
        barang.add("Ager-ager Walet");
        barang.add("Nutrijel");

        barang.add("---<SEMBAKO>---");
        barang.add("Beras 1 Kg");
        barang.add("Beras 1/2 Kg");
        barang.add("Beras 1/4 Kg");
        barang.add("Beras 3/4 Kg");
        barang.add("Gula 1 Kg");
        barang.add("Gula 1/2 Kg");
        barang.add("Gula 1/4 Kg");
        barang.add("Tepung Beras (Glepongan) 1 Kg");
        barang.add("Tepung Beras (Glepongan) 1/2 Kg");
        barang.add("Tepung Beras (Glepongan) 1/4 Kg");
        barang.add("Tepung Beras (Glepongan) 1 Ons");
        barang.add("Tepung Aci 1 Kg");
        barang.add("Tepung Aci 1/2 Kg");
        barang.add("Tepung Aci 1/4 Kg");
        barang.add("Tepung Aci 1 Ons");
        barang.add("Tepung Padi");
        barang.add("Tepung Trigu 1 Kg");
        barang.add("Tepung Trigu 1/2 Kg");
        barang.add("Tepung Trigu 1/4 Kg");
        barang.add("Tepung Trigu 1 Ons");
        barang.add("Telor 1 Butir");
        barang.add("Telor 1 Kg");
        barang.add("Telor 1/2 Kg");
        barang.add("Telor 1/4 Kg");
        barang.add("Minyak Goreng Renceng");
        barang.add("Minyak Goreng 1 Kg");
        barang.add("Minyak Goreng 1/2 Kg");
        barang.add("Minyak Goreng 1/4 Kg");
        barang.add("Sari Kecut");

        barang.add("---<ROKOK>---");
        barang.add("Sampoerna Mild");
        barang.add("Surya 16");
        barang.add("Surya 12");
        barang.add("Surya Isi 6 Batang");
        barang.add("Surya Isi 8");
        barang.add("Filter");
        barang.add("FIlter 1/2");
        barang.add("Signature");
        barang.add("Signature 1/2");
        barang.add("Pro Mild Merah");
        barang.add("Gudang Garam Merah");
        barang.add("Dji Sam Soe");
        barang.add("Rokok 1 Batang");

        barang.add("---<OBAT>---");
        barang.add("Bodrex Biasa");
        barang.add("Bodrex Biasa 1 Biji");
        barang.add("Bodrex Biasa 2 Biji");
        barang.add("Bodrex Biasa 3 Biji");
        barang.add("Bodrexin");
        barang.add("Bodrex PE");
        barang.add("Bodrex Migran");
        barang.add("Bodrex Extra");
        barang.add("Oskadon Sakit Kepala");
        barang.add("Oskadon SP");
        barang.add("Paramex Biasa");
        barang.add("Mixagrip Flu & Batuk");
        barang.add("Konidin");
        barang.add("Naspro");
        barang.add("Pilkita");
        barang.add("Supertetra");
        barang.add("Neo Rheumacyl");
        barang.add("Entrostop");
        barang.add("Fatigon");
        barang.add("Promax");
        barang.add("Diapet");
        barang.add("Sanmol");
        barang.add("Puyer 16");
        barang.add("Puyer 19");
        barang.add("Antimo");
        barang.add("Tolak Angin");
        barang.add("Tolak Angin Anak");
        barang.add("Tolak Linu");
        barang.add("Komik");
        barang.add("Madu Rasa");
        barang.add("Minyak Kayu Putih Small");
        barang.add("Kapas");
        barang.add("Tisu");
        barang.add("Talek");
        barang.add("Masker");
        barang.add("Ultra Flu");

        barang.add("---<PAMPERS>---");
        barang.add("Pampers XXL");
        barang.add("Pampers XL");
        barang.add("Pampers L");
        barang.add("Pampers M");
        barang.add("Charm Night");
        barang.add("Charm Biasa");

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog
                dialog=new Dialog(MainActivity.this);

                // set custom dialog
                dialog.setContentView(R.layout.dialog_searchable_spinner);

                // set custom height and width
                dialog.getWindow().setLayout(650,800);

                // set transparent background
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // show dialog
                dialog.show();

                // Initialize and assign variable
                EditText editText=dialog.findViewById(R.id.edit_text);
                ListView listView=dialog.findViewById(R.id.list_view);

                // Initialize array adapter
                ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, barang);

                // set adapter
                listView.setAdapter(adapter);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // when item selected from list
                        // set selected item on textView
                        textview.setText(adapter.getItem(position));

                        // Dismiss dialog
                        dialog.dismiss();

                        menu_barang = (String) adapter.getItem(position);
                        barang.add(adapter.getItem(position));

                    switch(menu_barang){
                        // SABUN
                        case "Lifeboy":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Nuvo Small":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Nuvo Medium":
                            edtharga.setText(String.valueOf("4500"));
                            break;
                        case "ZEN":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Shinzui":
                            edtharga.setText(String.valueOf("5000"));
                            break;
                        case "GIV":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Detol":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Odol":
                            edtharga.setText(String.valueOf("5000"));
                            break;
                        case "Rexona Women":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Rexona Men":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Garnier Renceng":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Fair & Lovely":
                            edtharga.setText(String.valueOf("4500"));
                            break;
                        case "Kapur Barus":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Sikat Gigi":
                            edtharga.setText(String.valueOf("3500"));
                            break;

                        //SHAMPO
                        case "Pantine Kondisioner":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Sunslik Kondisioner":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Zinc aneka macam":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Lifeboy aneka macam":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Head & Shoulder":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Pantine aneka macam":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Dove aneka macam":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Cleare aneka macam":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "KIT":
                            edtharga.setText(String.valueOf("2000"));
                            break;

                        //SABUN CUCI PIRING
                        case "Sunlight Small":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Sunlight Medium":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Mama Lemon Small":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Mama Lemon Medium":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Ekonomi Small":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Ekonomi Medium":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Ekonomi Big":
                            edtharga.setText(String.valueOf("5000"));
                            break;

                        //SABUN CUCI
                        case "Rinso Bubuk":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Rinso Cair":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Soklin Liquid":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Soklin Bubuk Small":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Soklin Bubuk Medium":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Soklin Antiseptik":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Daia":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Jazz1":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Molto":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Downie":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Wipol":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Soklin Lantai":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Rapika":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Kispray Gold":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Kispray Biasa":
                            edtharga.setText(String.valueOf("500"));
                            break;

                        // BUMBU
                        case "Racik Nasi Goreng Ekstra Pedas":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Nasi Goreng Biasa":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Tempe":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Ayam":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Ikan":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Sayur Asem":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Sayur Sop":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Sayur Lodeh":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Racik Kangkung":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Sajiku Tepung":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Saori Saus Tiram":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Desaku Sambel Goreng":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Desaku Balado":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Desaku Kari":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Desaku Ketumbar Bubuk":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Dapur Kita Ketumbar Bubuk":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Dapur Kita Balado":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Dapur Kita Jinten Bubuk":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Dapur Kita Bawang Putih Bubuk":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Dapur Kita Kayu Manis Bubuk":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Dapur Kita Kencur Bubuk":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Dapur Kita Kunyit":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Berlian Pala Bubuk":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Daisy Lada Bubuk":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Ladaku Merica Bubuk":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Uleg Sambel Terasi":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Bon Cabe":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Aida":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Mama Suka Kuah Bakso":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Terasi ABC":
                            edtharga.setText(String.valueOf("500"));
                            break;

                        //BUMBU GLONDING
                        case "Gula Jawa Renceng":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Asem Renceng":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Bawang Putih Renceng":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Kemiri Renceng":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Merica Renceng":
                            edtharga.setText(String.valueOf("500"));
                            break;

                        //CAOS
                        case "ABC Kecil":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "ABC Medium":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "ABC Besar":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Indofood Small":
                            edtharga.setText(String.valueOf("1000"));
                            break;

                        //KECAP
                        case "Bango Medium":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Bango Big":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sedap Small":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Sedap Big":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "ABC Small":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "ABC Big":
                            edtharga.setText(String.valueOf("2000"));
                            break;

                        //MIE INSTAN
                        case "Sedap Goreng":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Sedap Ayam Limau":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Sedap Korea":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Sedap Kari":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sedap Ayam Bawang":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sedap Soto":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sedap Bakso":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sedap Singapure":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Indomie Goreng":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Indomie Rendang":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Indomie Ayam Geprek":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Indomie Aceh":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Indomie Ayam Bawang Spesial":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Indomie Soto Banjar":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Indomie Seblak Jeletot":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Supermie Ayam Bawang":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sarimi Ayam Bawang":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Sukses Ayam Kecap":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Sukses Ayam Kremes":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Sukses Ayam Bawang":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Sukses Soto":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Sukses Kari":
                            edtharga.setText(String.valueOf("4000"));
                            break;

                        //MINUMAN
                        case "Lemineral 600ml":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Lemineral 330ml":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Susu Milku":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Susu Kotak":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Larutan Botol":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Larutan Kaleng":
                            edtharga.setText(String.valueOf("7000"));
                            break;
                        case "Ager-ager Walet":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Nutrijel":
                            edtharga.setText(String.valueOf("4000"));
                            break;

                        //SEMBAKO
                        case "Beras 1 Kg":
                            edtharga.setText(String.valueOf("11000"));
                            break;
                        case "Beras 1/2 Kg":
                            edtharga.setText(String.valueOf("5500"));
                            break;
                        case "Beras 3/4 Kg":
                            edtharga.setText(String.valueOf("85000"));
                            break;
                        case "Gula 1 Kg":
                            edtharga.setText(String.valueOf("15000"));
                            break;
                        case "Gula 1/2 Kg":
                            edtharga.setText(String.valueOf("7500"));
                            break;
                        case "Gula 1/4 Kg":
                            edtharga.setText(String.valueOf("4000"));
                            break;
                        case "Gula Renceng":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Tepung Beras (Glepongan) 1 Kg":
                            edtharga.setText(String.valueOf("12000"));
                            break;
                        case "Tepung Beras (Glepongan) 1/2 Kg":
                            edtharga.setText(String.valueOf("6000"));
                            break;
                        case "Tepung Beras (Glepongan) 1/4 Kg":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Tepung Beras (Glepongan) 1 Ons":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Tepung Aci 1 Kg":
                            edtharga.setText(String.valueOf("12000"));
                            break;
                        case "Tepung Aci 1/2 Kg":
                            edtharga.setText(String.valueOf("6000"));
                            break;
                        case "Tepung Aci 1/4 Kg":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Tepung Aci 1 Ons":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Tepung Padi":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Tepung Trigu 1 Kg":
                            edtharga.setText(String.valueOf("12000"));
                            break;
                        case "Tepung Trigu 1/2 Kg":
                            edtharga.setText(String.valueOf("6000"));
                            break;
                        case "Tepung Trigu 1/4 Kg":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Tepung Trigu 1 Ons":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Telor 1 Butir":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Telor 1 Kg":
                            edtharga.setText(String.valueOf("30000"));
                            break;
                        case "Telor 1/2 Kg":
                            edtharga.setText(String.valueOf("15000"));
                            break;
                        case "Telor 1/4 Kg":
                            edtharga.setText(String.valueOf("7500"));
                            break;
                        case "Minyak Goreng Renceng":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Minyak Goreng 1 Kg":
                            edtharga.setText(String.valueOf("14000"));
                            break;
                        case "Minyak Goreng 1/2 Kg":
                            edtharga.setText(String.valueOf("7000"));
                            break;
                        case "Minyak Goreng 1/4 Kg":
                            edtharga.setText(String.valueOf("4500"));
                            break;
                        case "Sari Kecut":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Garam Daun":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Teh Biru":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Teh Kuning 1":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Teh Kuning 3":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Teh Celup Kotak":
                            edtharga.setText(String.valueOf("10000"));
                            break;
                        case "Teh Celup Renceng":
                            edtharga.setText(String.valueOf("2000"));
                            break;

                        //ROKOK
                        case "Sampoerna Mild":
                            edtharga.setText(String.valueOf("28000"));
                            break;
                        case "Surya 16":
                            edtharga.setText(String.valueOf("29000"));
                            break;
                        case "Surya 12":
                            edtharga.setText(String.valueOf("23000"));
                            break;
                        case "Surya Isi 6 Batang":
                            edtharga.setText(String.valueOf("12000"));
                            break;
                        case "Surya Isi 8":
                            edtharga.setText(String.valueOf("15000"));
                            break;
                        case "Filter":
                            edtharga.setText(String.valueOf("23000"));
                            break;
                        case "FIlter 1/2":
                            edtharga.setText(String.valueOf("12000"));
                            break;
                        case "Signature":
                            edtharga.setText(String.valueOf("21000"));
                            break;
                        case "Signature 1/2":
                            edtharga.setText(String.valueOf("11000"));
                            break;
                        case "Pro Mild Merah":
                            edtharga.setText(String.valueOf("25000"));
                            break;
                        case "Gudang Garam Merah":
                            edtharga.setText(String.valueOf("15000"));
                            break;
                        case "Dji Sam Soe":
                            edtharga.setText(String.valueOf("21000"));
                            break;
                        case "Rokok 1 Batang":
                            edtharga.setText(String.valueOf("2000"));
                            break;

                        //OBAT
                        case "Bodrex Biasa 1 Biji":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Bodrex Biasa 2 Biji":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Bodrex Biasa 3 Biji":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Bodrexin":
                            edtharga.setText(String.valueOf("500"));
                            break;
                        case "Bodrex PE":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Bodrex Migran":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Bodrex Extra":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Panadol":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Oskadon Sakit Kepala":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Oskadon SP":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Paramex Biasa":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Mixagrip Flu & Batuk":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Konidin":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Naspro":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Pilkita":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Supertetra":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Neo Rheumacyl":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Entrostop":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Fatigon":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Promax":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Amoxilin":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Pil Dumex":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Diapet":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Sanmol":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Puyer 16":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Puyer 19":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Antimo":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Tolak Angin":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Tolak Angin Anak":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Tolak Linu":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Komik":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Madu Rasa":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Minyak Kayu Putih Small":
                            edtharga.setText(String.valueOf("7000"));
                            break;
                        case "Kapas":
                            edtharga.setText(String.valueOf("5500"));
                            break;
                        case "Tisu":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Talek":
                            edtharga.setText(String.valueOf("8500"));
                            break;
                        case "Masker":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Ultra Flu":
                            edtharga.setText(String.valueOf("1000"));
                            break;
                        case "Koyo Cabe":
                            edtharga.setText(String.valueOf("1500"));
                            break;
                        case "Koyo Handsaplash":
                            edtharga.setText(String.valueOf("2000"));
                            break;
                        case "Koyo Salonpas":
                            edtharga.setText(String.valueOf("1000"));
                            break;

                        //PAMPERS
                        case "Pampers XXL":
                            edtharga.setText(String.valueOf("3500"));
                            break;
                        case "Pampers XL":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Pampers L":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Pampers M":
                            edtharga.setText(String.valueOf("2500"));
                            break;
                        case "Charm Night":
                            edtharga.setText(String.valueOf("3000"));
                            break;
                        case "Charm Biasa":
                            edtharga.setText(String.valueOf("500"));
                            break;
                    }
                }
                });
            }
        });

//memberikan action pada tombol tambah

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String namabarang = edtnamabar.getSelectedItem().toString().trim();
//                String sabun = edtsabun.getSelectedItem().toString().trim();
//                String shampo = edtshampo.getSelectedItem().toString().trim();
//                String cuciPiring = edtcuciPiring.getSelectedItem().toString().trim();
//                String sabunCuci = edtsabunCuci.getSelectedItem().toString().trim();
//                String bumbu = edtbumbu.getSelectedItem().toString().trim();
//                String bumbuGlondong = edtbumbuGlondong.getSelectedItem().toString().trim();
//                String sembako = edtsembako.getSelectedItem().toString().trim();
//                String minuman = edtminuman.getSelectedItem().toString().trim();
//                String rokok = edtrokok.getSelectedItem().toString().trim();
//                String caos = edtcaos.getSelectedItem().toString().trim();
//                String kecap = edtkecap.getSelectedItem().toString().trim();
//                String obat = edtobat.getSelectedItem().toString().trim();
//                String mie = edtmie.getSelectedItem().toString().trim();
//                String pampers = edtpampers.getSelectedItem().toString().trim();

                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();

                if(jumlahbeli.equals("")){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Peringatan!!!");
                    alertDialog.setMessage("Harap isi Kuantitas Barang!!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {

                    int jb = Integer.parseInt(jumlahbeli);
                    int h = Integer.parseInt(harga);

                    int total = (jb * h);
                    int ttlHarga = 0;

//                    barang.add(namabarang);
//                    isabun.add(sabun);
//                    ishampo.add(shampo);
//                    barang.add(cuciPiring);
//                    barang.add(sabunCuci);
//                    barang.add(bumbu);
//                    barang.add(bumbuGlondong);
//                    barang.add(sembako);
//                    barang.add(rokok);
//                    barang.add(caos);
//                    barang.add(kecap);
//                    barang.add(obat);
//                    barang.add(pampers);
//                    barang.add(mie);
//                    barang.add(minuman);

                    jumlah.add(jb);
                    hrg.add(h);
                    ttl.add(total);

                    TableLayout tablelayoutid = (TableLayout)findViewById(R.id.tablelayoutid);
                    TableRow row = (TableRow)getLayoutInflater().inflate(R.layout.layout_row, null);
                    for(int i = 0; i < jumlah.size(); i++) {

                        ((TextView)row.findViewById(R.id.idnama)).setText(textview.getText());
                        ((TextView)row.findViewById(R.id.idnilai_a)).setText(String.valueOf(jumlah.get(i)));
                        ((TextView)row.findViewById(R.id.idnilai_b)).setText(String.valueOf(hrg.get(i)));
                        ((TextView)row.findViewById(R.id.idnilai_total)).setText(String.valueOf(ttl.get(i)));
                    }
                    tablelayoutid.addView(row);

                    for(int x = 0; x < ttl.size(); x++) {
                        ttlHarga = ttlHarga + ttl.get(x);
                    }

                    edttotalbelanja.setText(String.valueOf(ttlHarga));

//                    edtnamabar.setSelection(0);
//                    edtmie.setSelection(0);
//                    edtsabun.setSelection(0);
//                    edtcuciPiring.setSelection(0);
//                    edtsabunCuci.setSelection(0);
//                    edtbumbu.setSelection(0);
//                    edtshampo.setSelection(0);
//                    edtbumbuGlondong.setSelection(0);
//                    edtcaos.setSelection(0);
//                    edtkecap.setSelection(0);
//                    edtminuman.setSelection(0);
//                    edtrokok.setSelection(0);
//                    edtsembako.setSelection(0);
//                    edtpampers.setSelection(0);
//                    edtobat.setSelection(0);

                    edtharga.setText(" ");
                    edtuangbay.setText(" ");
                    edtjumlahbel.setText(" ");
                }
            }
        });

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                edtnamabar.setSelection(0);
//                edtmie.setSelection(0);
//                edtsabun.setSelection(0);
//                edtcuciPiring.setSelection(0);
//                edtsabunCuci.setSelection(0);
//                edtbumbu.setSelection(0);
//                edtshampo.setSelection(0);
//                edtbumbuGlondong.setSelection(0);
//                edtcaos.setSelection(0);
//                edtkecap.setSelection(0);
//                edtminuman.setSelection(0);
//                edtrokok.setSelection(0);
//                edtsembako.setSelection(0);
//                edtpampers.setSelection(0);
//                edtobat.setSelection(0);

                textview.
                txttotalbelanja.setText(" ");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText(" ");

                txtjumlahbel.setText(" ");
                txtketerangan.setText(" ");

                ttl.removeAll(ttl);
                barang.removeAll(barang);
                jumlah.removeAll(jumlah);
                hrg.removeAll(hrg);

                TableLayout tablelayoutid = (TableLayout)findViewById(R.id.tablelayoutid);
                TableRow row = (TableRow)getLayoutInflater().inflate(R.layout.layout_row, null);
                tablelayoutid.removeAllViews();

                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();

            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uangbayar = edtuangbay.getText().toString().trim();
                String tl_harga = edttotalbelanja.getText().toString().trim();

                if(ttl.size() == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Peringatan!!!");
                    alertDialog.setMessage("Daftar Belanja Masih Kosong!!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    edtuangbay.setText(" ");

                } else {

                    if (TextUtils.isEmpty(uangbayar)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Peringatan!!!");
                        alertDialog.setMessage("Harap isi Uang Bayar!!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
    //                    Toast.makeText(MainActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    } else {

                        int ub = Integer.parseInt(uangbayar);
                        int tl = Integer.parseInt(tl_harga);
                        int uangkembalian = (ub - tl);

                        if (ub < tl) {
                            edtketerangan.setText("Uang bayar kurang " + (formatRupiah(-uangkembalian)));
                            txtuangkembali.setText("0");
                        } else if (ub == tl) {
                            txtketerangan.setText("Uang Pas");
                            txtuangkembali.setText("0");
                        } else {
                            edtketerangan.setText("Tunggu Kembalian");
                            edtuangkembali.setText(String.valueOf(formatRupiah(uangkembalian)));
                        }

//                        edtnamabar.setSelection(0);
//                        edtmie.setSelection(0);
//                        edtsabun.setSelection(0);
//                        edtcuciPiring.setSelection(0);
//                        edtsabunCuci.setSelection(0);
//                        edtbumbu.setSelection(0);
//                        edtshampo.setSelection(0);
//                        edtbumbuGlondong.setSelection(0);
//                        edtcaos.setSelection(0);
//                        edtkecap.setSelection(0);
//                        edtminuman.setSelection(0);
//                        edtrokok.setSelection(0);
//                        edtsembako.setSelection(0);
//                        edtpampers.setSelection(0);
//                        edtobat.setSelection(0);

                        edtharga.setText(" ");
                        edtuangbay.setText(" ");
                        edtjumlahbel.setText(" ");

                    }
                }
            }
        });

        }

//    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtnamabar.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtnamabar.getSelectedItem()))) {
//            } else {
////                Toast.makeText(parent.getContext(),
////                        "Anda telah memilih : " + parent.getItemAtPosition(pos).toString(),
////                        Toast.LENGTH_LONG).show();
//
//                menu_barang = (String) edtnamabar.getSelectedItem();
//
//                switch(menu_barang){
//                    // SABUN
//                    case "Lifeboy":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Nuvo Small":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Nuvo Medium":
//                        edtharga.setText(String.valueOf("4500"));
//                        break;
//                    case "ZEN":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Shinzui":
//                        edtharga.setText(String.valueOf("5000"));
//                        break;
//                    case "GIV":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Detol":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Odol":
//                        edtharga.setText(String.valueOf("5000"));
//                        break;
//                    case "Rexona Women":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Rexona Men":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Garnier Renceng":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Fair & Lovely":
//                        edtharga.setText(String.valueOf("4500"));
//                        break;
//                    case "Kapur Barus":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Sikat Gigi":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//
//                    //SHAMPO
//                    case "Pantine Kondisioner":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Sunslik Kondisioner":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Zinc aneka macam":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Lifeboy aneka macam":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Head & Shoulder":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Pantine aneka macam":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dove aneka macam":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Cleare aneka macam":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "KIT":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//
//                    //SABUN CUCI PIRING
//                    case "Sunlight Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Sunlight Medium":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Mama Lemon Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Mama Lemon Medium":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Ekonomi Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Ekonomi Medium":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Ekonomi Big":
//                        edtharga.setText(String.valueOf("5000"));
//                        break;
//
//                    //SABUN CUCI
//                    case "Rinso Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Rinso Cair":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Soklin Liquid":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Soklin Bubuk Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Soklin Bubuk Medium":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Soklin Antiseptik":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Daia":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Jazz1":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Molto":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Downie":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Wipol":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Soklin Lantai":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Rapika":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Kispray Gold":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Kispray Biasa":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//
//                    // BUMBU
//                    case "Racik Nasi Goreng Ekstra Pedas":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Nasi Goreng Biasa":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Tempe":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Ayam":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Ikan":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Sayur Asem":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Sayur Sop":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Sayur Lodeh":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Kangkung":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Sajiku Tepung":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Saori Saus Tiram":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Desaku Sambel Goreng":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Desaku Balado":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Desaku Kari":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Desaku Ketumbar Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Ketumbar Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dapur Kita Balado":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dapur Kita Jinten Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dapur Kita Bawang Putih Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Kayu Manis Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Kencur Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Kunyit":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Berlian Pala Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Daisy Lada Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Ladaku Merica Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Uleg Sambel Terasi":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Bon Cabe":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Aida":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Mama Suka Kuah Bakso":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Terasi ABC":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//
//                    //BUMBU GLONDING
//                    case "Gula Jawa Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Asem Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Bawang Putih Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Kemiri Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Merica Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//
//                    //CAOS
//                    case "ABC Kecil":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "ABC Medium":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "ABC Besar":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indofood Small":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//
//                    //KECAP
//                    case "Bango Medium":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bango Big":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Sedap Big":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "ABC Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "ABC Big":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//
//                    //MIE INSTAN
//                    case "Sedap Goreng":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Sedap Ayam Limau":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Sedap Korea":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Sedap Kari":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Ayam Bawang":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Soto":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Bakso":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Singapure":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indomie Goreng":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Rendang":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Ayam Geprek":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Aceh":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Ayam Bawang Spesial":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indomie Soto Banjar":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indomie Seblak Jeletot":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Supermie Ayam Bawang":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sarimi Ayam Bawang":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sukses Ayam Kecap":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Ayam Kremes":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Ayam Bawang":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Soto":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Kari":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//
//                    //MINUMAN
//                    case "Lemineral 600ml":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Lemineral 330ml":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Susu Milku":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Susu Kotak":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Larutan Botol":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Larutan Kaleng":
//                        edtharga.setText(String.valueOf("7000"));
//                        break;
//                    case "Ager-ager Walet":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Nutrijel":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//
//                    //SEMBAKO
//                    case "Beras 1 Kg":
//                        edtharga.setText(String.valueOf("11000"));
//                        break;
//                    case "Beras 1/2 Kg":
//                        edtharga.setText(String.valueOf("5500"));
//                        break;
//                    case "Beras 3/4 Kg":
//                        edtharga.setText(String.valueOf("85000"));
//                        break;
//                    case "Gula 1 Kg":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Gula 1/2 Kg":
//                        edtharga.setText(String.valueOf("7500"));
//                        break;
//                    case "Gula 1/4 Kg":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Gula Renceng":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1 Kg":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1/2 Kg":
//                        edtharga.setText(String.valueOf("6000"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1/4 Kg":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1 Ons":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Tepung Aci 1 Kg":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Tepung Aci 1/2 Kg":
//                        edtharga.setText(String.valueOf("6000"));
//                        break;
//                    case "Tepung Aci 1/4 Kg":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Aci 1 Ons":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Tepung Padi":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Trigu 1 Kg":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Tepung Trigu 1/2 Kg":
//                        edtharga.setText(String.valueOf("6000"));
//                        break;
//                    case "Tepung Trigu 1/4 Kg":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Trigu 1 Ons":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Telor 1 Butir":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Telor 1 Kg":
//                        edtharga.setText(String.valueOf("30000"));
//                        break;
//                    case "Telor 1/2 Kg":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Telor 1/4 Kg":
//                        edtharga.setText(String.valueOf("7500"));
//                        break;
//                    case "Minyak Goreng Renceng":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Minyak Goreng 1 Kg":
//                        edtharga.setText(String.valueOf("14000"));
//                        break;
//                    case "Minyak Goreng 1/2 Kg":
//                        edtharga.setText(String.valueOf("7000"));
//                        break;
//                    case "Minyak Goreng 1/4 Kg":
//                        edtharga.setText(String.valueOf("4500"));
//                        break;
//                    case "Sari Kecut":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Garam Daun":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Teh Biru":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Teh Kuning 1":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Teh Kuning 3":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Teh Celup Kotak":
//                        edtharga.setText(String.valueOf("10000"));
//                        break;
//                    case "Teh Celup Renceng":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//
//                    //ROKOK
//                    case "Sampoerna Mild":
//                        edtharga.setText(String.valueOf("28000"));
//                        break;
//                    case "Surya 16":
//                        edtharga.setText(String.valueOf("29000"));
//                        break;
//                    case "Surya 12":
//                        edtharga.setText(String.valueOf("23000"));
//                        break;
//                    case "Surya Isi 6 Batang":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Surya Isi 8":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Filter":
//                        edtharga.setText(String.valueOf("23000"));
//                        break;
//                    case "FIlter 1/2":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Signature":
//                        edtharga.setText(String.valueOf("21000"));
//                        break;
//                    case "Signature 1/2":
//                        edtharga.setText(String.valueOf("11000"));
//                        break;
//                    case "Pro Mild Merah":
//                        edtharga.setText(String.valueOf("25000"));
//                        break;
//                    case "Gudang Garam Merah":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Dji Sam Soe":
//                        edtharga.setText(String.valueOf("21000"));
//                        break;
//                    case "Rokok 1 Batang":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//
//                    //OBAT
//                    case "Bodrex Biasa 1 Biji":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bodrex Biasa 2 Biji":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Bodrex Biasa 3 Biji":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Bodrexin":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Bodrex PE":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bodrex Migran":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bodrex Extra":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Panadol":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Oskadon Sakit Kepala":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Oskadon SP":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Paramex Biasa":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Mixagrip Flu & Batuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Konidin":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Naspro":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Pilkita":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Supertetra":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Neo Rheumacyl":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Entrostop":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Fatigon":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Promax":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Amoxilin":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Pil Dumex":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Diapet":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Sanmol":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Puyer 16":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Puyer 19":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Antimo":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Tolak Angin":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Tolak Angin Anak":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Tolak Linu":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Komik":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Madu Rasa":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Minyak Kayu Putih Small":
//                        edtharga.setText(String.valueOf("7000"));
//                        break;
//                    case "Kapas":
//                        edtharga.setText(String.valueOf("5500"));
//                        break;
//                    case "Tisu":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Talek":
//                        edtharga.setText(String.valueOf("8500"));
//                        break;
//                    case "Masker":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Ultra Flu":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Koyo Cabe":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Koyo Handsaplash":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Koyo Salonpas":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//
//                    //PAMPERS
//                    case "Pampers XXL":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Pampers XL":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Pampers L":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Pampers M":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Charm Night":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Charm Biasa":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }

    private String formatRupiah(Integer number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }


//    public class ItemSabun implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtsabun.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtsabun.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtsabun.getSelectedItem();
//                switch(menu_barang){
//                    // SABUN
//                    case "Lifeboy":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Nuvo Small":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Nuvo Medium":
//                        edtharga.setText(String.valueOf("4500"));
//                        break;
//                    case "ZEN":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Shinzui":
//                        edtharga.setText(String.valueOf("5000"));
//                        break;
//                    case "GIV":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Detol":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Odol":
//                        edtharga.setText(String.valueOf("5000"));
//                        break;
//                    case "Rexona Women":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Rexona Men":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Garnier Renceng":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Fair & Lovely":
//                        edtharga.setText(String.valueOf("4500"));
//                        break;
//                    case "Kapur Barus":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Sikat Gigi":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }

//    public class ItemShampo implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtshampo.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtshampo.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtshampo.getSelectedItem();
//                switch(menu_barang){
//                    //SHAMPO
//                    case "Pantine Kondisioner":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Sunslik Kondisioner":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Zinc aneka macam":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Lifeboy aneka macam":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Head & Shoulder":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Pantine aneka macam":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dove aneka macam":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Cleare aneka macam":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "KIT":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//
//    public class ItemcuciPiring implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtcuciPiring.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtcuciPiring.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtcuciPiring.getSelectedItem();
//                switch(menu_barang){
//                    //SABUN CUCI PIRING
//                    case "Sunlight Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Sunlight Medium":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Mama Lemon Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Mama Lemon Medium":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Ekonomi Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Ekonomi Medium":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Ekonomi Big":
//                        edtharga.setText(String.valueOf("5000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemSabunCuci implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtsabunCuci.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtsabunCuci.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtsabunCuci.getSelectedItem();
//                switch(menu_barang){
//                    //SABUN CUCI
//                    case "Rinso Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Rinso Cair":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Soklin Liquid":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Soklin Bubuk Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Soklin Bubuk Medium":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Soklin Antiseptik":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Daia":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Jazz1":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Molto":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Downie":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Wipol":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Soklin Lantai":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Rapika":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Kispray Gold":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Kispray Biasa":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemBumbu implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtbumbu.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtbumbu.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtbumbu.getSelectedItem();
//                switch(menu_barang){
//                    // BUMBU
//                    case "Racik Nasi Goreng Ekstra Pedas":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Nasi Goreng Biasa":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Tempe":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Ayam":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Ikan":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Sayur Asem":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Sayur Sop":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Sayur Lodeh":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Racik Kangkung":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Sajiku Tepung":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Saori Saus Tiram":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Desaku Sambel Goreng":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Desaku Balado":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Desaku Kari":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Desaku Ketumbar Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Ketumbar Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dapur Kita Balado":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dapur Kita Jinten Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Dapur Kita Bawang Putih Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Kayu Manis Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Kencur Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Dapur Kita Kunyit":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Berlian Pala Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Daisy Lada Bubuk":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Ladaku Merica Bubuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Uleg Sambel Terasi":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Bon Cabe":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Aida":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Mama Suka Kuah Bakso":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Terasi ABC":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemBumbuGlondong implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtbumbuGlondong.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtbumbuGlondong.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtbumbuGlondong.getSelectedItem();
//                switch(menu_barang){
//                    //BUMBU GLONDING
//                    case "Gula Jawa Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Asem Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Bawang Putih Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Kemiri Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Merica Renceng":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemCaos implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtcaos.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtcaos.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtcaos.getSelectedItem();
//                switch(menu_barang){
//                    //CAOS
//                    case "ABC Kecil":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "ABC Medium":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "ABC Besar":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indofood Small":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemKecap implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtkecap.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtkecap.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtkecap.getSelectedItem();
//                switch(menu_barang){
//                    //KECAP
//                    case "Bango Medium":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bango Big":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Sedap Big":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "ABC Small":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "ABC Big":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemMie implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtmie.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtmie.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtmie.getSelectedItem();
//                switch(menu_barang){
//                    //MIE INSTAN
//                    case "Sedap Goreng":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Sedap Ayam Limau":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Sedap Korea":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Sedap Kari":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Ayam Bawang":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Soto":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Bakso":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sedap Singapure":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indomie Goreng":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Rendang":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Ayam Geprek":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Aceh":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Indomie Ayam Bawang Spesial":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indomie Soto Banjar":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Indomie Seblak Jeletot":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Supermie Ayam Bawang":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sarimi Ayam Bawang":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Sukses Ayam Kecap":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Ayam Kremes":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Ayam Bawang":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Soto":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Sukses Kari":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemMinuman implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtminuman.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtminuman.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtminuman.getSelectedItem();
//                switch(menu_barang){
//                    //MINUMAN
//                    case "Lemineral 600ml":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Lemineral 330ml":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Susu Milku":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Susu Kotak":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Larutan Botol":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Larutan Kaleng":
//                        edtharga.setText(String.valueOf("7000"));
//                        break;
//                    case "Ager-ager Walet":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Nutrijel":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemSembako implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtsembako.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtsembako.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtsembako.getSelectedItem();
//                switch(menu_barang){
//                    //SEMBAKO
//                    case "Beras 1 Kg":
//                        edtharga.setText(String.valueOf("11000"));
//                        break;
//                    case "Beras 1/2 Kg":
//                        edtharga.setText(String.valueOf("5500"));
//                        break;
//                    case "Beras 3/4 Kg":
//                        edtharga.setText(String.valueOf("85000"));
//                        break;
//                    case "Gula 1 Kg":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Gula 1/2 Kg":
//                        edtharga.setText(String.valueOf("7500"));
//                        break;
//                    case "Gula 1/4 Kg":
//                        edtharga.setText(String.valueOf("4000"));
//                        break;
//                    case "Gula Renceng":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1 Kg":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1/2 Kg":
//                        edtharga.setText(String.valueOf("6000"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1/4 Kg":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Beras (Glepongan) 1 Ons":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Tepung Aci 1 Kg":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Tepung Aci 1/2 Kg":
//                        edtharga.setText(String.valueOf("6000"));
//                        break;
//                    case "Tepung Aci 1/4 Kg":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Aci 1 Ons":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Tepung Padi":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Trigu 1 Kg":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Tepung Trigu 1/2 Kg":
//                        edtharga.setText(String.valueOf("6000"));
//                        break;
//                    case "Tepung Trigu 1/4 Kg":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Tepung Trigu 1 Ons":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Telor 1 Butir":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Telor 1 Kg":
//                        edtharga.setText(String.valueOf("30000"));
//                        break;
//                    case "Telor 1/2 Kg":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Telor 1/4 Kg":
//                        edtharga.setText(String.valueOf("7500"));
//                        break;
//                    case "Minyak Goreng Renceng":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Minyak Goreng 1 Kg":
//                        edtharga.setText(String.valueOf("14000"));
//                        break;
//                    case "Minyak Goreng 1/2 Kg":
//                        edtharga.setText(String.valueOf("7000"));
//                        break;
//                    case "Minyak Goreng 1/4 Kg":
//                        edtharga.setText(String.valueOf("4500"));
//                        break;
//                    case "Sari Kecut":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Garam Daun":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Teh Biru":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Teh Kuning 1":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Teh Kuning 3":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Teh Celup Kotak":
//                        edtharga.setText(String.valueOf("10000"));
//                        break;
//                    case "Teh Celup Renceng":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemRokok implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtrokok.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtrokok.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtrokok.getSelectedItem();
//                switch(menu_barang){
//                    //ROKOK
//                    case "Sampoerna Mild":
//                        edtharga.setText(String.valueOf("28000"));
//                        break;
//                    case "Surya 16":
//                        edtharga.setText(String.valueOf("29000"));
//                        break;
//                    case "Surya 12":
//                        edtharga.setText(String.valueOf("23000"));
//                        break;
//                    case "Surya Isi 6 Batang":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Surya Isi 8":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Filter":
//                        edtharga.setText(String.valueOf("23000"));
//                        break;
//                    case "FIlter 1/2":
//                        edtharga.setText(String.valueOf("12000"));
//                        break;
//                    case "Signature":
//                        edtharga.setText(String.valueOf("21000"));
//                        break;
//                    case "Signature 1/2":
//                        edtharga.setText(String.valueOf("11000"));
//                        break;
//                    case "Pro Mild Merah":
//                        edtharga.setText(String.valueOf("25000"));
//                        break;
//                    case "Gudang Garam Merah":
//                        edtharga.setText(String.valueOf("15000"));
//                        break;
//                    case "Dji Sam Soe":
//                        edtharga.setText(String.valueOf("21000"));
//                        break;
//                    case "Rokok 1 Batang":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemPampers implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtpampers.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtpampers.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtpampers.getSelectedItem();
//                switch(menu_barang){
//                    //PAMPERS
//                    case "Pampers XXL":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Pampers XL":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Pampers L":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Pampers M":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Charm Night":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Charm Biasa":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
//    public class ItemObat implements AdapterView.OnItemSelectedListener {
//        //get strings of first item
//        String firstItem = String.valueOf(edtobat.getSelectedItem());
//
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            if (firstItem.equals(String.valueOf(edtobat.getSelectedItem()))) {
//            } else {
//
//                menu_barang = (String) edtobat.getSelectedItem();
//                switch(menu_barang){
//                    //OBAT
//                    case "Bodrex Biasa 1 Biji":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bodrex Biasa 2 Biji":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Bodrex Biasa 3 Biji":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Bodrexin":
//                        edtharga.setText(String.valueOf("500"));
//                        break;
//                    case "Bodrex PE":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bodrex Migran":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Bodrex Extra":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Panadol":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Oskadon Sakit Kepala":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Oskadon SP":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Paramex Biasa":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Mixagrip Flu & Batuk":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Konidin":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Naspro":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Pilkita":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Supertetra":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Neo Rheumacyl":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Entrostop":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Fatigon":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Promax":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Amoxilin":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Pil Dumex":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Diapet":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Sanmol":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Puyer 16":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Puyer 19":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Antimo":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Tolak Angin":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Tolak Angin Anak":
//                        edtharga.setText(String.valueOf("2500"));
//                        break;
//                    case "Tolak Linu":
//                        edtharga.setText(String.valueOf("3500"));
//                        break;
//                    case "Komik":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Madu Rasa":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Minyak Kayu Putih Small":
//                        edtharga.setText(String.valueOf("7000"));
//                        break;
//                    case "Kapas":
//                        edtharga.setText(String.valueOf("5500"));
//                        break;
//                    case "Tisu":
//                        edtharga.setText(String.valueOf("3000"));
//                        break;
//                    case "Talek":
//                        edtharga.setText(String.valueOf("8500"));
//                        break;
//                    case "Masker":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Ultra Flu":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//                    case "Koyo Cabe":
//                        edtharga.setText(String.valueOf("1500"));
//                        break;
//                    case "Koyo Handsaplash":
//                        edtharga.setText(String.valueOf("2000"));
//                        break;
//                    case "Koyo Salonpas":
//                        edtharga.setText(String.valueOf("1000"));
//                        break;
//
//                }
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
}