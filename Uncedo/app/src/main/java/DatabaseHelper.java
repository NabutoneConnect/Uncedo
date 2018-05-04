import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lamalis on 4/11/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";

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


    private static final String DATABASE_NAME = "patientcompliant.db";
    private static final int DATABASE_VERSION = 1;


    //SQL STATEMENT OF THE PATIENT TABLE CREATION
    private static final String SQL_CREATE_TABLE_PATIENT = "CREATE TABLE"+TABLE_PATIENTS +"("
            +COLUMN_PAT_ID_NUM + "INTERGER PRIMARY KEY,"
            +COLUMN_PAT_NAME + "TEXT NOT NULL,"
            +COLUMN_PAT_SURNAME + "TEXT NOT NULL,"
            +COLUMN_PAT_ADDRESS + "TEXT NOT NULL,"
            +COLUMN_PAT_HOSPITAL + "TEXT NOT NULL,"
            +COLUMN_PAT_CITY + "TEXT NOT NULL,"
            +COLUMN_PAT_MANICIPALITY + "TEXT NOT NULL,"
            +COLUMN_PAT_EMAIL + "TEXT NOT NULL,"
            +COLUMN_PAT_TEL + "TEXT NOT NULL,"+");";

    //SQL STATEMENT OF THE COMPLAINT TABLE CREATION
    private static final String SQL_CREATE_TABLE_COMPALAINT = "CREATE TABLE"+TABLE_COMPLAINT +"("
            +COLUMN_COM_ID + "INTERGER PRIMARY KEY AUTOINCREMENT,"
            +COLUMN_COM_DATE_LAUNCHED + "TEXT NOT NULL,"
            +COLUMN_COM_DATE_OCCURED + "TEXT NOT NULL,"
            +COLUMN_COM_PRO_CATEGORY + "TEXT NOT NULL,"
            +COLUMN_COM_ILLNESS_CATEGOTY + "TEXT NOT NULL,"
            +COLUMN_COM_PROBLEM_DISCRIPTION + "TEXT NOT NULL,"
            +COLUMN_COM_STATUS + "TEXT NOT NULL,"
            +COLUMN_COM_PROGRESS_REPORT + "TEXT NOT NULL,"
            +COLUMN_COM_COMMUNICATION_ALTERNATIVE + "TEXT NOT NULL,"
            +COLUMN_COM_PATIENT_ID + "INTERGER NOT NULL,"+");";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_PATIENT);
        db.execSQL(SQL_CREATE_TABLE_COMPALAINT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(TAG,
                "Upgrading the database from version" + oldVersion + "to" + newVersion);
        //Clear the data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPLAINT);

        //recreate the tables
        onCreate(db);
    }
    // we now need to insert data into the database
    public boolean insertData(String id,String name,String surname,String address,String hospital,String city,String municipality,String email,String telno ){

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


}
