package us.myles.ViaVersion.api.type;


import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import us.myles.ViaVersion.api.minecraft.*;
import us.myles.ViaVersion.api.minecraft.item.Item;
import us.myles.ViaVersion.api.type.types.*;
import us.myles.ViaVersion.api.type.types.minecraft.*;

import java.util.UUID;

public abstract class Type<T> implements ByteBufReader<T>, ByteBufWriter<T> {
    /* Defined Types */
    public static final Type<Byte> BYTE = new ByteType();
    /**
     * @deprecated unreasonable overhead, use BYTE_ARRAY_PRIMITIVE
     */
    @Deprecated
    public static final Type<Byte[]> BYTE_ARRAY = new ArrayType<>(Type.BYTE);
    public static final Type<byte[]> BYTE_ARRAY_PRIMITIVE = new ByteArrayType();

    public static final Type<byte[]> REMAINING_BYTES = new RemainingBytesType();

    public static final Type<Short> UNSIGNED_BYTE = new UnsignedByteType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Short[]> UNSIGNED_BYTE_ARRAY = new ArrayType<>(Type.UNSIGNED_BYTE);

    public static final Type<Boolean> BOOLEAN = new BooleanType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Boolean[]> BOOLEAN_ARRAY = new ArrayType<>(Type.BOOLEAN);
    /* Number Types */
    public static final Type<Integer> INT = new IntType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Integer[]> INT_ARRAY = new ArrayType<>(Type.INT);

    public static final Type<Double> DOUBLE = new DoubleType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Double[]> DOUBLE_ARRAY = new ArrayType<>(Type.DOUBLE);

    public static final Type<Long> LONG = new LongType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Long[]> LONG_ARRAY = new ArrayType<>(Type.LONG);

    public static final Type<Float> FLOAT = new FloatType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Float[]> FLOAT_ARRAY = new ArrayType<>(Type.FLOAT);

    public static final Type<Short> SHORT = new ShortType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Short[]> SHORT_ARRAY = new ArrayType<>(Type.SHORT);

    public static final Type<Integer> UNSIGNED_SHORT = new UnsignedShortType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Integer[]> UNSIGNED_SHORT_ARRAY = new ArrayType<>(Type.UNSIGNED_SHORT);
    /* Other Types */
    public static final Type<String> STRING = new StringType();
    public static final Type<String[]> STRING_ARRAY = new ArrayType<>(Type.STRING);

    public static final Type<UUID> UUID = new UUIDType();
    public static final Type<UUID> UUID_INT_ARRAY = new UUIDIntArrayType();
    public static final Type<UUID[]> UUID_ARRAY = new ArrayType<>(Type.UUID);
    /* Variable Types */
    public static final Type<Integer> VAR_INT = new VarIntType();
    /**
     * @deprecated unreasonable overhead, use VAR_INT_ARRAY_PRIMITIVE
     */
    @Deprecated
    public static final Type<Integer[]> VAR_INT_ARRAY = new ArrayType<>(Type.VAR_INT);
    public static final Type<int[]> VAR_INT_ARRAY_PRIMITIVE = new VarIntArrayType();
    public static final Type<Integer> OPTIONAL_VAR_INT = new OptionalVarIntType();
    public static final Type<Long> VAR_LONG = new VarLongType();
    /**
     * @deprecated unreasonable overhead
     */
    @Deprecated
    public static final Type<Long[]> VAR_LONG_ARRAY = new ArrayType<>(Type.VAR_LONG);
    /* Special Types */
    public static final Type<Void> NOTHING = new VoidType(); // This is purely used for remapping.
    /* MC Types */
    public static final Type<Position> POSITION = new PositionType();
    public static final Type<Position> POSITION1_14 = new Position1_14Type();
    public static final Type<EulerAngle> ROTATION = new EulerAngleType();
    public static final Type<Vector> VECTOR = new VectorType();
    public static final Type<CompoundTag> NBT = new NBTType();
    public static final Type<CompoundTag[]> NBT_ARRAY = new ArrayType<>(Type.NBT);

    public static final Type<UUID> OPTIONAL_UUID = new OptUUIDType();
    public static final Type<String> OPTIONAL_CHAT = new OptionalChatType();
    public static final Type<Position> OPTIONAL_POSITION = new OptPositionType();
    public static final Type<Position> OPTIONAL_POSITION_1_14 = new OptPosition1_14Type();

    public static final Type<Item> ITEM = new ItemType();
    public static final Type<Item[]> ITEM_ARRAY = new ItemArrayType();

    public static final Type<BlockChangeRecord> BLOCK_CHANGE_RECORD = new BlockChangeRecordType();
    public static final Type<BlockChangeRecord[]> BLOCK_CHANGE_RECORD_ARRAY = new ArrayType<>(Type.BLOCK_CHANGE_RECORD);

    public static final Type<VillagerData> VILLAGER_DATA = new VillagerDataType();

    public static final Type<Particle> PARTICLE_1_14 = new Particle1_14Type();

    /* 1.13 Flat Item (no data) */
    public static final Type<Item> FLAT_ITEM = new FlatItemType();
    public static final Type<Item> FLAT_VAR_INT_ITEM = new FlatVarIntItemType();
    public static final Type<Item[]> FLAT_ITEM_ARRAY = new FlatItemArrayType();
    public static final Type<Item[]> FLAT_VAR_INT_ITEM_ARRAY = new FlatVarIntItemArrayType();
    public static final Type<Item[]> FLAT_ITEM_ARRAY_VAR_INT = new ArrayType<>(FLAT_ITEM);
    public static final Type<Item[]> FLAT_VAR_INT_ITEM_ARRAY_VAR_INT = new ArrayType<>(FLAT_VAR_INT_ITEM);

    /* Actual Class */

    private final Class<? super T> outputClass;
    private final String typeName;

    public Type(Class<? super T> outputClass) {
        this(outputClass.getSimpleName(), outputClass);
    }

    public Type(String typeName, Class<? super T> outputClass) {
        this.outputClass = outputClass;
        this.typeName = typeName;
    }

    public Class<? super T> getOutputClass() {
        return outputClass;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<? extends Type> getBaseClass() {
        return this.getClass();
    }

    @Override
    public String toString() {
        return "Type|" + typeName;
    }
}
