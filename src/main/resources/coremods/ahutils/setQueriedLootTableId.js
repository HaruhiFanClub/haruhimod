function initializeCoreMod() {
    // ASMAPI = Java.type("net.minecraftforge.coremod.api.ASMAPI");
    Opcodes = Java.type("org.objectweb.asm.Opcodes");

    return {
        "LootContext#setQueriedLootTableId": {
            target: {
                type: "METHOD",
                class: "net.minecraft.loot.LootContext",
                methodName: "setQueriedLootTableId",
                methodDesc: "(Lnet/minecraft/util/ResourceLocation;)V",
            },
            transformer: function (methodNode) {
                // print(ASMAPI.methodNodeToString(methodNode));

                methodNode.instructions.clear();

                {
                    /* LocalVariableTable
                    Slot  Name                Signature
                    0     this                Lnet/minecraft/loot/LootContext;
                    1     queriedLootTableId  Lnet/minecraft/util/ResourceLocation;
                    */
                    methodNode.visitCode();
                    methodNode.visitVarInsn(Opcodes.ALOAD, 0);
                    methodNode.visitVarInsn(Opcodes.ALOAD, 1);
                    methodNode.visitFieldInsn(
                        Opcodes.PUTFIELD,
                        "net/minecraft/loot/LootContext",
                        "queriedLootTableId",
                        "Lnet/minecraft/util/ResourceLocation;"
                    );
                    methodNode.visitInsn(Opcodes.RETURN);
                    methodNode.visitMaxs(2, 1);
                    methodNode.visitEnd();
                }

                // print(ASMAPI.methodNodeToString(methodNode));
                return methodNode;
            },
        },
    };
}

//! Original method
/*
    public void setQueriedLootTableId(ResourceLocation queriedLootTableId) {
        if (this.queriedLootTableId == null && queriedLootTableId != null) this.queriedLootTableId = queriedLootTableId;
    }

*   ========== ByteCode ==========   *

    L0
        LINENUMBER 110 L0
        ALOAD 0
        GETFIELD net/minecraft/loot/LootContext.queriedLootTableId : Lnet/minecraft/util/ResourceLocation;
        IFNONNULL L1
        ALOAD 1
        IFNULL L1
        ALOAD 0
        ALOAD 1
        PUTFIELD net/minecraft/loot/LootContext.queriedLootTableId : Lnet/minecraft/util/ResourceLocation;
    L1
        LINENUMBER 111 L1
    FRAME SAME
        RETURN
    L2
        LOCALVARIABLE this Lnet/minecraft/loot/LootContext; L0 L2 0
        LOCALVARIABLE queriedLootTableId Lnet/minecraft/util/ResourceLocation; L0 L2 1
        MAXSTACK = 2
        MAXLOCALS = 2
*/

//! Transformed method
/*
--  public void setQueriedLootTableId(ResourceLocation queriedLootTableId) {
--      if (this.queriedLootTableId == null && queriedLootTableId != null) this.queriedLootTableId = queriedLootTableId;
--  }

~+  public void setQueriedLootTableId(ResourceLocation queriedLootTableId) {
~+      this.queriedLootTableId = queriedLootTableId;
~+  }

*   ========== ByteCode ==========   *

--  L0
--      LINENUMBER 110 L0
--      ALOAD 0
--      GETFIELD net/minecraft/loot/LootContext.queriedLootTableId : Lnet/minecraft/util/ResourceLocation;
--      IFNONNULL L1
--      ALOAD 1
--      IFNULL L1
--      ALOAD 0
--      ALOAD 1
--      PUTFIELD net/minecraft/loot/LootContext.queriedLootTableId : Lnet/minecraft/util/ResourceLocation;
--  L1
--      LINENUMBER 111 L1
--  FRAME SAME
--      RETURN
--  L2
--      LOCALVARIABLE this Lnet/minecraft/loot/LootContext; L0 L2 0
--      LOCALVARIABLE queriedLootTableId Lnet/minecraft/util/ResourceLocation; L0 L2 1
--      MAXSTACK = 2
--      MAXLOCALS = 2

~+  ALOAD 0
~+  ALOAD 1
~+  PUTFIELD net/minecraft/loot/LootContext.queriedLootTableId : Lnet/minecraft/util/ResourceLocation;
~+  RETURN
~+  LOCALVARIABLE this Lnet/minecraft/loot/LootContext; L0 L1 0
~+  LOCALVARIABLE queriedLootTableId Lnet/minecraft/util/ResourceLocation; L0 L1 1
~+  MAXSTACK = 2
~+  MAXLOCALS = 1
*/
