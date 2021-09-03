function initializeCoreMod() {
    // ASMAPI = Java.type("net.minecraftforge.coremod.api.ASMAPI");
    Opcodes = Java.type("org.objectweb.asm.Opcodes");

    InsnList = Java.type("org.objectweb.asm.tree.InsnList");
    InsnNode = Java.type("org.objectweb.asm.tree.InsnNode");
    VarInsnNode = Java.type("org.objectweb.asm.tree.VarInsnNode");
    MethodInsnNode = Java.type("org.objectweb.asm.tree.MethodInsnNode");
    JumpInsnNode = Java.type("org.objectweb.asm.tree.JumpInsnNode");
    LabelNode = Java.type("org.objectweb.asm.tree.LabelNode");

    return {
        "PistonBlock#isPushable": {
            target: {
                type: "METHOD",
                class: "net.minecraft.block.PistonBlock",
                methodName: "isPushable",
                methodDesc:
                    "(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Direction;ZLnet/minecraft/util/Direction;)Z",
            },
            transformer: function (methodNode) {
                // print(ASMAPI.methodNodeToString(methodNode));
                instructions = methodNode.instructions;

                var toInject = new InsnList();
                var escape = new LabelNode();

                {
                    /* LocalVariableTable
                        Slot  Name          Signature
                        0     p_185646_0_   Lnet/minecraft/block/BlockState;
                        1     p_185646_1_   Lnet/minecraft/world/World;
                        2     p_185646_2_   Lnet/minecraft/util/math/BlockPos;
                        3     p_185646_3_   Lnet/minecraft/util/Direction;
                        4     p_185646_4_   Z
                        5     p_185646_5_   Lnet/minecraft/util/Direction; 
                    */
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 0));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 1));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 2));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 3));
                    toInject.add(new VarInsnNode(Opcodes.ILOAD, 4));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 5));

                    toInject.add(
                        new MethodInsnNode(
                            Opcodes.INVOKESTATIC,
                            "org/auioc/mods/ahutils/common/event/CommonEventRegistry",
                            "postPistonCheckPushableEvent",
                            "(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Direction;ZLnet/minecraft/util/Direction;)Z",
                            false
                        )
                    );

                    toInject.add(new JumpInsnNode(Opcodes.IFEQ, escape));
                    toInject.add(new InsnNode(Opcodes.ICONST_0));
                    toInject.add(new InsnNode(Opcodes.IRETURN));
                    toInject.add(escape);
                }

                instructions.insert(instructions.getFirst(), toInject);

                // print(ASMAPI.methodNodeToString(methodNode));
                return methodNode;
            },
        },
    };
}

//! Original method
/* 
public static boolean isPushable(BlockState p_185646_0_, World p_185646_1_, BlockPos p_185646_2_, Direction p_185646_3_, boolean p_185646_4_, Direction p_185646_5_) {
    if (p_185646_2_.getY() >= 0 && p_185646_2_.getY() <= p_185646_1_.getMaxBuildHeight() - 1 && p_185646_1_.getWorldBorder().isWithinBounds(p_185646_2_)) {
        // ......
    }
    // ......

*   ========== ByteCode ==========   *

    L0
        LINENUMBER 214 L0
        ALOAD 2
        INVOKEVIRTUAL net/minecraft/util/math/BlockPos.getY ()I
        IFLT L1
        ALOAD 2
        INVOKEVIRTUAL net/minecraft/util/math/BlockPos.getY ()I
        ALOAD 1
        INVOKEVIRTUAL net/minecraft/world/World.getMaxBuildHeight ()I
        ICONST_1
        ISUB
        IF_ICMPGT L1
        ALOAD 1
        INVOKEVIRTUAL net/minecraft/world/World.getWorldBorder ()Lnet/minecraft/world/border/WorldBorder;
        ALOAD 2
        INVOKEVIRTUAL net/minecraft/world/border/WorldBorder.isWithinBounds (Lnet/minecraft/util/math/BlockPos;)Z
        IFEQ L1
*/

//! Transformed method
/* 
public static boolean isPushable(BlockState p_185646_0_, World p_185646_1_, BlockPos p_185646_2_, Direction p_185646_3_, boolean p_185646_4_, Direction p_185646_5_) {
~+  if (org.auioc.mods.ahutils.common.event.CommonEventRegistry.postPistonAddBlockLineEvent(p_185646_0_, p_185646_1_, p_185646_2_, p_185646_3_, p_185646_4_, p_185646_5_)) {
~+      return false;
~+  }

    if (p_185646_2_.getY() >= 0 && p_185646_2_.getY() <= p_185646_1_.getMaxBuildHeight() - 1 && p_185646_1_.getWorldBorder().isWithinBounds(p_185646_2_)) {
        // ......
    }
    // ......

*   ========== ByteCode ==========   *

~+  L0
~+      ALOAD 0
~+      ALOAD 1
~+      ALOAD 2
~+      ALOAD 3
~+      ILOAD 4
~+      ALOAD 5
~+      INVOKESTATIC org/auioc/mods/ahutils/common/event/CommonEventRegistry.postPistonCheckPushableEvent (Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Direction;ZLnet/minecraft/util/Direction;)Z
~+      IFEQ L1
~+      ICONST_0
~+      IRETURN
    L1
        LINENUMBER 214 L0
        ALOAD 2
        INVOKEVIRTUAL net/minecraft/util/math/BlockPos.getY ()I
        IFLT L2
        ALOAD 2
        INVOKEVIRTUAL net/minecraft/util/math/BlockPos.getY ()I
        ALOAD 1
        INVOKEVIRTUAL net/minecraft/world/World.getMaxBuildHeight ()I
        ICONST_1
        ISUB
        IF_ICMPGT L2
        ALOAD 1
        INVOKEVIRTUAL net/minecraft/world/World.getWorldBorder ()Lnet/minecraft/world/border/WorldBorder;
        ALOAD 2
        INVOKEVIRTUAL net/minecraft/world/border/WorldBorder.isWithinBounds (Lnet/minecraft/util/math/BlockPos;)Z
        IFEQ L2
*/
