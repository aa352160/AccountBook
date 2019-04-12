package com.jh352160.myaccoutbook.bean

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by jh352160 on 2019/4/8.
 */

@Entity
class PlanTypeB{
    @Id var id = 0L
    var name = ""
    var dailyMoney = ""
}
