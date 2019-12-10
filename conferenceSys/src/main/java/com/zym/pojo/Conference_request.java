package com.zym.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conference_request {
    private int conId;
    private boolean cName;
    private boolean cSex;
    private boolean cIdNum;
    private boolean cTel;
    private boolean cCompany;
    private boolean cRoom;
}
