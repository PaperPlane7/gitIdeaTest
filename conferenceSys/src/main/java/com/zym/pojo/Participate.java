package com.zym.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participate {
    private int conId;
    private String userId;
    private String Name;
    private String Sex;
    private String IdNum;
    private String Tel;
    private String Company;
    private boolean Room;
}
