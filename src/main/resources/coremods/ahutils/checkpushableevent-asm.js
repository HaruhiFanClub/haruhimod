// cSpell: disable
function initializeCoreMod() {
    ASMAPI = Java.type("net.minecraftforge.coremod.api.ASMAPI");

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
                instructions = methodNode.instructions;

                var toInject = new InsnList();
                var escape = new LabelNode();

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

                instructions.insert(instructions.getFirst(), toInject);

                return methodNode;
            },
        },
    };
}
