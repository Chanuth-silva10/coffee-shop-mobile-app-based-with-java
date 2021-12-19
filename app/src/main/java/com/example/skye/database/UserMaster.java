package com.example.skye.database;

import android.provider.BaseColumns;

public class UserMaster {
    public UserMaster() {
    }

    public static class  UserT implements BaseColumns {
        public static final String TABLE_NAME = "User";
        public static final String COLUMN_UserCode = "UserID";
        public static final String COLUMN_Uemail = "UserEmail";
        public static final String COLUMN_Upassword = "UserPassword";


    }
}
