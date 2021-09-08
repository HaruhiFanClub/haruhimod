# 使用 AHUtils 提供的 LootModifier

AHUtils 提供了一个 HLootInjector ，可以用来批量对战利品表进行注入。

HLootInjector 完全通过数据包的形式来配置，可以使用 `/reload` 指令进行热重载。

## 使用方法

1. 编写战利品修改器加载器
    - 编辑数据包中 `forge` 命名空间，`loot_modifiers` 路径下的 `global_loot_modifiers.json` 文件，您需要在此文件中添加的您的战利品修改器的命名空间 ID 。指定的命名空间 ID 指向数据包中的 `<namespace>:loot_modifiers/<path>`。详细信息参见 Forge 文档。

2. 编写战利品修改器

    - 在加载器中指定的修改器的对应位置添加修改器。一个空的修改器如下所示。

    ```json
    {
        "type": "ahutils:loot_injector",
        "conditions": [],
        "strict_parameter": true,
        "injectors": []
    }
    ```

    1. `"type": "ahutils:loot_injector"` 表示使用 HLootInjector 修改器。

    2. `conditions` 属性可以指定条件。若无条件，也必须保留此属性为空。

    3. `strict_parameter` 属性控制是否遵循注入源表的类型，可省略，默认为 `true`。实际效果如下：
        1. 若为 `true`，则直接使用注入源表的类型
        2. 若为 `false`，则忽略注入源表的类型，使用 `LootParameterSets.CHEST`。

        例如：注入源表的类型为 `minecraft:block`，设置此属性为 `true`，那么在非方块类型的掉落中，注入源表不会生效，且在 `/loot` 指令非 `mine` 来源情况下会报错。

    4. `injectors` 二维数组属性为注入操作的目标表和注入源表的关系。
        - 结构为 `[[<目标表>, <注入源表>]]`。列如 `["minecraft:blocks/stone", "minecraft:blocks/sand"]` 表示把沙子的战利品表插入到石头的战利品表中。
        - 同一个修改器中不能对一个目标注入多个表，若设置了多个对同一个表的注入，则仅最后一个可生效。可以使用多个修改器分别注入。例如设置 `[["minecraft:blocks/stone", "minecraft:blocks/sand"], ["minecraft:blocks/stone", "minecraft:blocks/red_sand"]]`,则仅红沙的注入可以生效。

## 示例

示例数据包的命名空间为 `my_project`。

在此示例中，将实现如下功能：

1. 将末地城箱子中的战利品添加到沙漠神殿的箱子中。
2. 将要塞图书馆箱子中的战利品添加到丛林神庙的箱子中。

### 实现步骤

1. 新建 `/data/forge/loot_modifiers/global_loot_modifiers.json` 文件，写入以下内容：

    ```json
    {
        "replace": false,
        "entries": ["my_project:temple_plus"]
    }
    ```

2. 新建 `/data/my_project/loot_modifiers/temple_plus.json` 文件，写入以下内容：

    ```json
    {
        "type": "ahutils:loot_injector",
        "conditions": [],
        "strict_parameter": false,
        "injectors": [
            [
                "minecraft:chests/desert_pyramid",
                "minecraft:chests/end_city_treasure"
            ],
            [
                "minecraft:chests/jungle_temple",
                "minecraft:chests/stronghold_library"
            ]
        ]
    }
    ```

3. 使用 `/reload` 指令重载数据包或重启服务端/客户端。
4. 寻找上述战利品箱子，或使用 `/loot` 指令验证是否注入成功。
