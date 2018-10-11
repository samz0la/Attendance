package edu.cnm.deepdive.attendance.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface AbsenceDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    long insert(Absence absence);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    List<Long> insert(Absence... absences);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    List<Long> insert(List<Absence> absences);

    @Query("SELECT * FROM absence ORDER BY start ASC")  //TODO need to update
    List<Student> select();

    @Query("SELECT * FROM students " //TODO need to update
        + "WHERE last_name LIKE :pattern OR first_name LIKE :pattern OR display_name LIKE :pattern "
        + "ORDER BY last_name ASC, first_name ASC")
    List<Student> select(String pattern);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int update(Absence absence);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int update(Absence... absences);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int update(List<Absence> absences);

    @Delete
    int delete(Absence absence);

    @Delete
    int delete(Absence... absences);

    @Delete
    int delete(List<Absence> absences);


  }

