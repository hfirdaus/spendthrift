package com.hf.spendthrifty;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Hadiya on 2017-12-28.
 */

public class Converter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date)
    {
        return date == null ? null : date.getTime();
    }
}

