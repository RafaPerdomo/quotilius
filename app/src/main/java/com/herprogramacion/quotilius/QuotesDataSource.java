package com.herprogramacion.quotilius;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Creado por Hermosa Programación
 */
public class QuotesDataSource {

    //Metainformación de la base de datos
    public static final String QUOTES_TABLE_NAME = "Quotes";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Quotes
    public static class ColumnQuotes{
        public static final String ID_QUOTES = BaseColumns._ID;
        public static final String BODY_QUOTES = "body";
        public static final String AUTHOR_QUOTES = "author";
    }

    //Script de Creación de la tabla Quotes
    public static final String CREATE_QUOTES_SCRIPT =
            "create table "+QUOTES_TABLE_NAME+"(" +
                    ColumnQuotes.ID_QUOTES+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnQuotes.BODY_QUOTES+" "+STRING_TYPE+" not null," +
                    ColumnQuotes.AUTHOR_QUOTES+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto
    public static final String INSERT_QUOTES_SCRIPT =
            "insert into "+QUOTES_TABLE_NAME+" values(" +
                    "null," +
                    "\"El ignorante afirma, el sabio duda y reflexiona\"," +
                    "\"Aristóteles\")," +
                    "(null," +
                    "\"Hay derrotas que tienen mas dignidad que la victoria\"," +
                    "\"Jorge Luis Borges\")," +
                    "(null," +
                    "\"Si buscas resultados distintos, no hagas siempre lo mismo\"," +
                    "\"Albert Einstein\")," +
                    "(null," +
                    "\"Donde mora la libertad, allí está mi patria\"," +
                    "\"Benjamin Franklin\")," +
                    "(null," +
                    "\"Ojo por ojo y todo el mundo acabará ciego\"," +
                    "\"Mahatma Gandhi\")";


    //Variables para manipulación de datos
    private QuotesReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public QuotesDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new QuotesReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void saveQuoteRow(String body,String author){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando body y author
        values.put(QuotesDataSource.ColumnQuotes.BODY_QUOTES,body);
        values.put(QuotesDataSource.ColumnQuotes.AUTHOR_QUOTES,author);

        //Insertando en la base de datos
        database.insert(QUOTES_TABLE_NAME,null,values);
    }

    public Cursor getAllQuotes(){
        //Seleccionamos todas las filas de la tabla Quotes
        return database.rawQuery(
                "select * from " + QUOTES_TABLE_NAME, null);
    }
}
