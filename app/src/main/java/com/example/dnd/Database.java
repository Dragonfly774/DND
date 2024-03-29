package com.example.dnd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {
    // Данные базы данных и таблиц
    private static final String DATABASE_NAME = "Characters.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "MyData";

    // Название столбцов
    private static final String COLUMN_ID = "_id";
//    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_NAME = "Name";

    // Номера столбцов
    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_DATE = 1;
    private static final int NUM_COLUMN_TITLE = 2;


    Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_DATE + " LONG, " +
                COLUMN_NAME + " STRING); ";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}