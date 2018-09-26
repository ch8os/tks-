package com.tks.resource.common.entity.dept;

import com.tks.resource.common.entity.BDeptInfo;
import lombok.Data;

@Data
public class DeptParam {
    private BDeptInfo deptInfo;
    private int pageSize;
    private int pageNum;
}
