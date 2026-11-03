package com.example.diancai.data

/** 本地示例菜单数据，接入真实后台时替换为接口返回即可 */
object MenuData {

    val categories = listOf(
        Category("hot", "热菜"),
        Category("cold", "凉菜"),
        Category("staple", "主食"),
        Category("soup", "汤品"),
        Category("drink", "饮品"),
    )

    val dishes = listOf(
        Dish(1, "宫保鸡丁", "鸡丁、花生、干辣椒，微辣", 38.0, "hot", "🍗"),
        Dish(2, "鱼香肉丝", "猪肉丝、木耳、胡萝卜", 32.0, "hot", "🥘"),
        Dish(3, "麻婆豆腐", "嫩豆腐、牛肉末，麻辣鲜香", 26.0, "hot", "🌶️"),
        Dish(4, "红烧肉", "五花肉，肥而不腻", 45.0, "hot", "🍖"),
        Dish(5, "蒜蓉西兰花", "清爽解腻", 22.0, "hot", "🥦"),

        Dish(6, "口水鸡", "凉拌鸡丝，麻辣爽口", 28.0, "cold", "🐔"),
        Dish(7, "皮蛋豆腐", "内酯豆腐配皮蛋", 18.0, "cold", "🥚"),
        Dish(8, "凉拌黄瓜", "蒜香脆爽", 12.0, "cold", "🥒"),

        Dish(9, "米饭", "东北珍珠米", 3.0, "staple", "🍚"),
        Dish(10, "蛋炒饭", "粒粒分明", 15.0, "staple", "🍛"),
        Dish(11, "手工水饺", "猪肉白菜，12 只", 20.0, "staple", "🥟"),

        Dish(12, "番茄鸡蛋汤", "酸甜开胃", 16.0, "soup", "🍲"),
        Dish(13, "紫菜蛋花汤", "清淡爽口", 14.0, "soup", "🥣"),

        Dish(14, "酸梅汤", "解腻冰饮", 8.0, "drink", "🥤"),
        Dish(15, "鲜榨橙汁", "现榨无添加", 15.0, "drink", "🍊"),
        Dish(16, "可乐", "冰镇", 6.0, "drink", "🥤"),
    )

    fun dishesOf(categoryId: String): List<Dish> =
        dishes.filter { it.categoryId == categoryId }

    fun byId(id: Int): Dish? = dishes.firstOrNull { it.id == id }
}
