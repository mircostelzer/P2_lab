package data.blocks.interfaces;

public interface Block extends InventoryBlock{

    char display();

    boolean getFalls_with_gravity();

    boolean getFall_through();

    String display_in_inventory();

    boolean is_pickable();

    int hashCode();
}
