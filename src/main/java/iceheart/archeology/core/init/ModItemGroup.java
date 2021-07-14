package iceheart.archeology.core.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroup extends ItemGroup {

    private Supplier<ItemStack> displayStack;
    public static final ModItemGroup ARCHEOLOGY = new ModItemGroup("archeology",
            () -> new ItemStack(ItemInit.BRUSH.get()));

    public ModItemGroup(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }

    @Override
    public ItemStack createIcon() {return displayStack.get();}
}
