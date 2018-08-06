package com.example.tuancan.dto;


import com.example.tuancan.model.DeliveringMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveringHistory {


    private Integer UnitId;
    /*公司name*/
    private String UnitName;

    private List<DeliveringMaster> deliveringMasters;
}
