package com.framgia.marvel01.data;//package com.framgia.marvel01.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levutantuan on 3/16/17.
 */
public class MarvelSqlite extends SQLiteOpenHelper {
    private static final String COMMAND_CREATE_DB = "Drop table if exist";
    private static final String DATABASE_NAME = "FavoritesMarvel.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_MARVEL_FAVORITES = "tb_favorites";
    public static final String COMLUMN_ID = "id";
    public static final String COMLUMN_NAME = "name";
    public static final String COMLUMN_MODIFIED = "modified";
    public static final String COMLUMN_DESCRIPTION = "description";
    public static final String COMLUMN_TITLE = "title";
    public static final String COMLUMN_THUMBNAIL = "thumbnail";
    public static final String COMMAND_CREATE_TABLE =
        "CREATE TABLE " + TABLE_MARVEL_FAVORITES + "(" + COMLUMN_ID + " TEXT, " + COMLUMN_NAME +
            " TEXT, " + COMLUMN_MODIFIED + " TEXT, " + COMLUMN_DESCRIPTION + " TEXT, " +
            COMLUMN_THUMBNAIL + " TEXT, " + COMLUMN_TITLE + " TEXT)";

    public MarvelSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMAND_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(COMMAND_CREATE_DB + TABLE_MARVEL_FAVORITES);
    }

    public List<Marvel> getAllFavorite() {
        List<Marvel> marvelList = new ArrayList<Marvel>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_MARVEL_FAVORITES, null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                marvelList.add(new Marvel(cursor));
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return marvelList;
    }

    public void insertFavorites(Marvel newfavorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MarvelSqlite.COMLUMN_ID, newfavorite.getId());
        contentValues.put(MarvelSqlite.COMLUMN_NAME, newfavorite.getName());
        contentValues.put(MarvelSqlite.COMLUMN_MODIFIED, newfavorite.getModified());
        contentValues.put(MarvelSqlite.COMLUMN_DESCRIPTION, newfavorite.getDescription());
        contentValues.put(MarvelSqlite.COMLUMN_THUMBNAIL, newfavorite.getTitle());
        contentValues.put(MarvelSqlite.COMLUMN_TITLE, newfavorite.getTitle());
        db.insert(TABLE_MARVEL_FAVORITES, null, contentValues);
        db.close();
    }
}