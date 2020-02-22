package com.example.csdevmobile_1.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

import com.example.csdevmobile_1.Model.Akun;

public class LocalDatabase extends SQLiteOpenHelper {
    private final static String DATABASENAME = "db_tabungan";
    private static final  int DATABASE_VERSION = 1;

    //TABEL AKUN
    private static final String TABEL_AKUN = "tabel_akun";
    private static final String NAMA = "nama";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    //TABEL TABUNGAN
    private static final String TABEL_TABUNGAN = "tabel_tabungan";
    private static final String USERNAME_TABUNGAN = "username";
    private static final String SALDO = "saldo";
    private static final String SATUAN = "satuan";
    private static final String UTANG = "utang";
    private static final String PIUTANG = "piutang";

    private String TBL_CREATE_AKUN = "create table " + TABEL_AKUN + "(" +
            USERNAME + " text primary key, " +
            NAMA + " text, " +
            PASSWORD + " text)";
    private String TBL_CREATE_TABUNGAN = "create table " + TABEL_TABUNGAN + "(" +
            USERNAME_TABUNGAN + " text primary key, " +
            SALDO + " real," +
            SATUAN + " text, " +
            UTANG + " real," +
            PIUTANG + " real)";

    public LocalDatabase(Context context) {
        super(context, DATABASENAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TBL_CREATE_AKUN);
        sqLiteDatabase.execSQL(TBL_CREATE_TABUNGAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABEL_AKUN);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABEL_TABUNGAN);
        onCreate(sqLiteDatabase);
    }
    public long insertAkun(Akun akun){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERNAME, akun.getUsername());
        values.put(PASSWORD, akun.getPassword());
        values.put(NAMA, akun.getNama());

        long kode_akun = db.insert(TABEL_AKUN, null, values);
        return kode_akun;
    }
    public Akun getAkun(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABEL_AKUN + " ta WHERE ta." + USERNAME + " = '" +
                username + "'";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Akun akun = new Akun();
        akun.setUsername((c.getString(c.getColumnIndex(USERNAME))));
        akun.setNama(c.getString(c.getColumnIndex(NAMA)));
        akun.setPassword(c.getString(c.getColumnIndex(PASSWORD)));

        return akun;
    }
}
