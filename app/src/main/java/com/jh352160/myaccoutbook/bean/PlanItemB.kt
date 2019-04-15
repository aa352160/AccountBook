package com.jh352160.myaccoutbook.bean

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by jh352160 on 2019/4/12.
 */

@Entity
class PlanItemB{
    @Id var id = 0L
    var typeId = 0L
    var spendMoney = ""
    var remark = ""
    var createTime = 0L
}
