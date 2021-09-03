function initializeCoreMod() {
    // ASMAPI = Java.type("net.minecraftforge.coremod.api.ASMAPI");
    Opcodes = Java.type("org.objectweb.asm.Opcodes");

    InsnList = Java.type("org.objectweb.asm.tree.InsnList");

    AbstractInsnNode = Java.type("org.objectweb.asm.tree.AbstractInsnNode");
    VarInsnNode = Java.type("org.objectweb.asm.tree.VarInsnNode");
    MethodInsnNode = Java.type("org.objectweb.asm.tree.MethodInsnNode");

    return {
        "ServerLifecycleHooks#handleServerLogin": {
            target: {
                type: "METHOD",
                class: "net.minecraftforge.fml.server.ServerLifecycleHooks",
                methodName: "handleServerLogin",
                methodDesc:
                    "(Lnet/minecraft/network/handshake/client/CHandshakePacket;Lnet/minecraft/network/NetworkManager;)Z",
            },
            transformer: function (methodNode) {
                // print(ASMAPI.methodNodeToString(methodNode));
                instructions = methodNode.instructions;

                var arrayLength = instructions.size();
                var firstLabel;

                for (var i = 0; i < arrayLength; ++i) {
                    var instruction = instructions.get(i);
                    if (instruction.getType() == AbstractInsnNode.LABEL) {
                        firstLabel = instruction;
                        // print("Found injection point at label: " + instruction);
                        break;
                    }
                }

                if (!firstLabel) {
                    throw (
                        "Error: Couldn't find injection point! " + instructions
                    );
                }

                var toInject = new InsnList();

                {
                    /* LocalVariableTable
                        Slot  Name            Signature
                        0     packet          Lnet/minecraft/network/handshake/client/CHandshakePacket;
                        1     manager         Lnet/minecraft/network/NetworkManager;
                    */
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 0));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 1));
                    toInject.add(
                        new MethodInsnNode(
                            Opcodes.INVOKESTATIC,
                            "org/auioc/mods/ahutils/server/event/ServerEventRegistry",
                            "postServerLoginEvent",
                            "(Lnet/minecraft/network/handshake/client/CHandshakePacket;Lnet/minecraft/network/NetworkManager;)V",
                            false
                        )
                    );
                }

                instructions.insert(firstLabel, toInject);

                // print(ASMAPI.methodNodeToString(methodNode));
                return methodNode;
            },
        },
    };
}

//! Original method
/*
public static boolean handleServerLogin(final CHandshakePacket packet, final NetworkManager manager) {
    if (!allowLogins.get()) {
        // ......
    }
    // ......
}

*   ========== ByteCode ==========   *

    L0
        LINENUMBER 144 L0
        GETSTATIC net/minecraftforge/fml/server/ServerLifecycleHooks.allowLogins : Ljava/util/concurrent/atomic/AtomicBoolean;
        INVOKEVIRTUAL java/util/concurrent/atomic/AtomicBoolean.get ()Z
        IFNE L1
*/

//! Transformed method
/*
public static boolean handleServerLogin(final CHandshakePacket packet, final NetworkManager manager) {
~+  org.auioc.mods.ahutils.server.event.ServerEventRegistry.registerServerLoginEvent(packet, manager);

    if (!allowLogins.get()) {
        // ......
    }
    // ......
}

*   ========== ByteCode ==========   *

    L0
~+      ALOAD 0
~+      ALOAD 1
~+      INVOKESTATIC org/auioc/mods/ahutils/server/event/ServerEventRegistry.postServerLoginEvent (Lnet/minecraft/network/handshake/client/CHandshakePacket;Lnet/minecraft/network/NetworkManager;)V
        LINENUMBER 144 L0
        GETSTATIC net/minecraftforge/fml/server/ServerLifecycleHooks.allowLogins : Ljava/util/concurrent/atomic/AtomicBoolean;
        INVOKEVIRTUAL java/util/concurrent/atomic/AtomicBoolean.get ()Z
        IFNE L1
*/
