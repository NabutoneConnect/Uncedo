package com.example.lamalis.uncedo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lamalis on 4/11/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //public static final String TAG = "DBHelper";


    private static final String DATABASE_NAME = "patientCompliant.db";
    private static final int DATABASE_VERSION = 1;

    //coluns of the Patient table
    public static final String TABLE_PATIENTS = "patients";
    public static final String COLUMN_PAT_ID_NUM = "id_no";
    public static final String COLUMN_PAT_NAME = "name";
    public static final String COLUMN_PAT_SURNAME = "surname";
    public static final String COLUMN_PAT_ADDRESS = "address";
    public static final String COLUMN_PAT_HOSPITAL = "hospital";
    public static final String COLUMN_PAT_CITY = "city";
    public static final String COLUMN_PAT_MANICIPALITY = "manicipality";
    public static final String COLUMN_PAT_EMAIL = "email_add";
    public static final String COLUMN_PAT_TEL = "tel_num";


    //coluns of the complaint table
    public static final String TABLE_COMPLAINT = "complaint";
    public static final String COLUMN_COM_ID = "id_no";
    public static final String COLUMN_COM_DATE_LAUNCHED = "date_launched";
    public static final String COLUMN_COM_DATE_OCCURED = "date_occurred";
    public static final String COLUMN_COM_PRO_CATEGORY = "pro_categoty";
    public static final String COLUMN_COM_ILLNESS_CATEGOTY = "illness_category";
    public static final String COLUMN_COM_PROBLEM_DISCRIPTION= "problem_discription";
    public static final String COLUMN_COM_STATUS = "status";
    public static final String COLUMN_COM_PROGRESS_REPORT = "progress_report";
    public static final String COLUMN_COM_COMMUNICATION_ALTERNATIVE = "communication_alternative";
    public static final String COLUMN_COM_PATIENT_ID = "patient_id";





    //SQL STATEMENT OF THE PATIENT TABLE CREATION
    private static final String SQL_CREATE_TABLE_PATIENT = "create table " + TABLE_PATIENTS +"(id_no INTERGER PRIMARY KEY, " +
            "name TEXT NOT NULL, " +
            "surname TEXT NOT NULL, " +
            "address TEXT NOT NULL," +
            "hospital TEXT NOT NULL," +
            "city TEXT NOT NULL," +
            "manicipality TEXT NOT NULL," +
            "email_add TEXT NOT NULL," +
            "tel_num TEXT NOT NULL)";

    //SQL STATEMENT OF THE COMPLAINT TABLE CREATION
  //  private static final String SQL_CREATE_TABLE_COMPALAINT = "create table " + TABLE_COMPLAINT +"(id_no INTERGER PRIMARY KEY AUTOINCREMENT," +
        //    "date_launched TEXT," +
        //    "date_occurred TEXT," +
        //    "pro_categoty TEXT," +
         //   "illness_category TEXT," +
         //   "problem_discription TEXT," +
         //   "status TEXT," +
         //   "progress_report TEXT," +
        //    "communication_alternative TEXT," +
        //    "patient_id INTERGER )";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        //SQL STATEMENT OF THE PATIENT TABLE CREATION
        db.execSQL(SQL_CREATE_TABLE_PATIENT);
        //SQL STATEMENT OF THE COMPLAINT TABLE CREATION
       // db.execSQL(SQL_CREATE_TABLE_COMPALAINT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      //  Log.w(TAG,
             //   "Upgrading the database from version" + oldVersion + "to" + newVersion);
        //Clear the data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
      //  db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPLAINT);

        //recreate the tables
        onCreate(db);
    }
    // we now need to insert data into the database
    public boolean insertData(String id,String name,String surname,
                              String address,String hospital,
                              String city,String municipality,String email,String telno ){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_PAT_ID_NUM,id);
        contentValues.put(COLUMN_PAT_NAME,name);
        contentValues.put(COLUMN_PAT_SURNAME,surname);
        contentValues.put(COLUMN_PAT_ADDRESS,address);
        contentValues.put(COLUMN_PAT_HOSPITAL,hospital);
        contentValues.put(COLUMN_PAT_CITY,city);
        contentValues.put(COLUMN_PAT_MANICIPALITY,municipality);
        contentValues.put(COLUMN_PAT_EMAIL,email);
        contentValues.put(COLUMN_PAT_TEL,telno);

        // inserting values
        long result = db.insert(TABLE_PATIENTS,null , contentValues);
        if(result == -1 )
            return false;
        else
            return true;


    }

    //To view the patient registered information // you select every single thing from the database
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from " +TABLE_PATIENTS,null);
        return res;
    }





}
