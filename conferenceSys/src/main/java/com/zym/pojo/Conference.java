package com.zym.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conference {
    private int conId;
    private String conName;
    private String userId;
    private String conDescription;

    private Date conCreateTime;
    private Date conEndTime;
    private Date conTime;
    private String conLocation;
    private String conGuest;
    private String conHotel;
}
