package net.xolt.freecam.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FreecamConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.EnumValue FLIGHT_MODE;
    public static final ForgeConfigSpec.EnumValue PERSPECTIVE;
    public static final ForgeConfigSpec.EnumValue INTERACTION_MODE;
    public static final ForgeConfigSpec.DoubleValue HORIZONTAL_SPEED;
    public static final ForgeConfigSpec.DoubleValue VERTICAL_SPEED;
    public static final ForgeConfigSpec.BooleanValue IGNORE_TRANSPARENT_COLLISION;
    public static final ForgeConfigSpec.BooleanValue IGNORE_OPENABLE_COLLISION;
    public static final ForgeConfigSpec.BooleanValue IGNORE_ALL_COLLISION;
    public static final ForgeConfigSpec.BooleanValue ALWAYS_CHECK_COLLISION;
    public static final ForgeConfigSpec.BooleanValue FREEZE_PLAYER;
    public static final ForgeConfigSpec.BooleanValue ALLOW_INTERACT;
    public static final ForgeConfigSpec.BooleanValue DISABLE_ON_DAMAGE;
    public static final ForgeConfigSpec.BooleanValue SHOW_PLAYER;
    public static final ForgeConfigSpec.BooleanValue SHOW_HAND;
    public static final ForgeConfigSpec.BooleanValue SHOW_SUBMERSION;
    public static final ForgeConfigSpec.BooleanValue NOTIFY_FREECAM;
    public static final ForgeConfigSpec.BooleanValue NOTIFY_TRIPOD;

    static {
        BUILDER.push("Freecam");

        FLIGHT_MODE = BUILDER.comment("The type of flight used by freecam.")
                .defineEnum("Flight Mode", FlightMode.DEFAULT);

        PERSPECTIVE = BUILDER.comment("The initial perspective of the camera.")
                .defineEnum("Initial Perspective", Perspective.INSIDE);

        INTERACTION_MODE = BUILDER.comment("The source of block/entity interactions.")
                .defineEnum("Interaction Mode", InteractionMode.CAMERA);

        HORIZONTAL_SPEED = BUILDER.comment("The horizontal speed of freecam.")
                .defineInRange("Horizontal Speed", 1.0, 0.0, 10.0);

        VERTICAL_SPEED = BUILDER.comment("The vertical speed of freecam.")
                .defineInRange("Vertical Speed", 1.0, 0.0, 10.0);

        IGNORE_TRANSPARENT_COLLISION = BUILDER.comment("You can travel through glass blocks in freecam.")
                .define("Ignore Transparent Blocks", true);

        IGNORE_OPENABLE_COLLISION = BUILDER.comment("You can travel through any door, trapdoor, or gate in freecam.")
                .define("Ignore Openable Blocks", true);

        IGNORE_ALL_COLLISION = BUILDER.comment("You can travel through any block in freecam.")
                .define("Ignore All Collision", true);

        ALWAYS_CHECK_COLLISION = BUILDER.comment("Whether 'Initial Perspective' should check for collision, even when using 'Ignore All Collision'.")
                .define("Always Check Initial Collision", false);

        DISABLE_ON_DAMAGE = BUILDER.comment("Disables freecam when damage is received.")
                .define("Disable on Damage", true);

        ALLOW_INTERACT = BUILDER.comment("Whether you can interact with blocks/entities in freecam.\nWARNING: Multiplayer usage not advised.")
                .define("Allow Interaction", false);

        FREEZE_PLAYER = BUILDER.comment("Prevents player movement while freecam is active.\nWARNING: Multiplayer usage not advised.")
                .define("Freeze Player", false);

        SHOW_PLAYER = BUILDER.comment("Shows your player in its original position.")
                .define("Show Player", true);

        SHOW_HAND = BUILDER.comment("Whether you can see your hand in freecam.")
                .define("Show Hand", false);

        SHOW_SUBMERSION = BUILDER.comment("Whether you see a fog overlay underwater, in lava, or powdered snow.")
                .define("Show Submersion Fog", false);

        NOTIFY_FREECAM = BUILDER.comment("Notifies you when entering/exiting freecam.")
                .define("Freecam Notifications", true);

        NOTIFY_TRIPOD = BUILDER.comment("Notifies you when entering/exiting tripod cameras.")
                .define("Tripod Notifications", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public enum FlightMode {
        CREATIVE("text.freecam.configScreen.option.flightMode.creative"),
        DEFAULT("text.freecam.configScreen.option.flightMode.default");

        private final String key;

        FlightMode(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public enum InteractionMode {
        CAMERA("text.freecam.configScreen.option.interactionMode.camera"),
        PLAYER("text.freecam.configScreen.option.interactionMode.player");

        private final String key;

        InteractionMode(String name) {
            this.key = name;
        }

        public String getKey() {
            return key;
        }
    }

    public enum Perspective {
        FIRST_PERSON("text.freecam.configScreen.option.perspective.firstPerson"),
        THIRD_PERSON("text.freecam.configScreen.option.perspective.thirdPerson"),
        THIRD_PERSON_MIRROR("text.freecam.configScreen.option.perspective.thirdPersonMirror"),
        INSIDE("text.freecam.configScreen.option.perspective.inside");

        private final String key;

        Perspective(String name) {
            this.key = name;
        }

        public String getKey() {
            return key;
        }
    }
}
