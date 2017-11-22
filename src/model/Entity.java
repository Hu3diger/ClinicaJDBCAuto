package model;

/**
 *
 * @author Martin_Ruediger
 */
public abstract class Entity implements IEntity{
    
    protected int id;

    public Entity(int id) {
        this.id = id;
    }

    public Entity() {
    }
        
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
}
