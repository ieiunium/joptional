package org.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pojo {

    private SubPojo subPojo;
    private SubPojo[] subPojos;
    private List<SubPojo> subPojoList;
}
