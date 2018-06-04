package org.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPojo {

    private SubSubPojo subSubPojo;
    private SubSubPojo[] subSubPojos;
    private List<SubSubPojo> subSubPojoList;
}
