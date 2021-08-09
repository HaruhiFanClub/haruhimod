// cSpell: disable
function initializeCoreMod() {
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
                instructions = methodNode.instructions;

                var arrayLength = instructions.size();
                var firstLabel;

                for (var i = 0; i < arrayLength; ++i) {
                    var instruction = instructions.get(i);
                    if (instruction.getType() == AbstractInsnNode.LABEL) {
                        firstLabel = instruction;
                        print("Found injection point at label: " + instruction);
                        break;
                    }
                }

                if (!firstLabel) {
                    throw (
                        "Error: Couldn't find injection point! " + instructions
                    );
                }

                var toInject = new InsnList();

                toInject.add(new VarInsnNode(Opcodes.ALOAD, 0)); // CHandshakePacket packet
                toInject.add(new VarInsnNode(Opcodes.ALOAD, 1)); // NetworkManager manager
                toInject.add(
                    new MethodInsnNode(
                        Opcodes.INVOKESTATIC,
                        "org/auioc/mods/ahutils/server/event/ServerEventRegister",
                        "registerServerLoginEvent",
                        "(Lnet/minecraft/network/handshake/client/CHandshakePacket;Lnet/minecraft/network/NetworkManager;)V",
                        //boolean isInterface
                        false
                    )
                );

                instructions.insert(firstLabel, toInject);

                return methodNode;
            },
        },
    };
}

/* net.minecraftforge.fml.server.ServerLifecycleHooks.handleServerLogin
public static boolean handleServerLogin(final CHandshakePacket packet, final NetworkManager manager) {
    if (!allowLogins.get())
    {
        // ......
    }

    // ......
}
*/

/* net.minecraftforge.fml.server.ServerLifecycleHooks.handleServerLogin
public static boolean handleServerLogin(final CHandshakePacket packet, final NetworkManager manager) {
    // ~ INSERT BEGIN ~ //
    org.auioc.mods.ahutils.server.event.ServerEventRegister.registerServerLoginEvent(packet, manager);
    // ~ INSERT END ~ //

    if (!allowLogins.get())
    {
        // ......
    }

    // ......
}
*/
