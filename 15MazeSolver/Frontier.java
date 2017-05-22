public interface Frontier{
    public void add(Location l);

    public Location next();

    public boolean hasNext();
}
