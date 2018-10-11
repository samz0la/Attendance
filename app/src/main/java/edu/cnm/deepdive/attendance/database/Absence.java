package edu.cnm.deepdive.attendance.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(
    tableName = "absence",
    foreignKeys = {
        @ForeignKey(
            entity = Student.class,
            parentColumns = "student_id",
            childColumns = "student_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = {"start", "end"}),
        @Index(value = {"student_id", "start"}, unique = true),
        @Index( value = {"student_id", "start", "end"})
    }
)

public class Absence {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "absence_id")
  private long id;

  @ColumnInfo(name = "student_id", index = true)
  private long studentId;

  @NonNull
  private Date start = new Date();

  private Date end;

  private boolean excused;

  public void setId(long id) {
    this.id = id;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  @NonNull
  public Date getStart() {
    return start;
  }

  public void setStart(@NonNull Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public boolean isExcused() {
    return excused;
  }

  public void setExcused(boolean excused) {
    this.excused = excused;
  }
}
