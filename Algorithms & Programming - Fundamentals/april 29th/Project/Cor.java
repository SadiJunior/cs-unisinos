public class Cor
{
    // RGB Representation
    private int r;
    private int g;
    private int b;

    public Cor()
    {
    }
    
    public Cor(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public int getRed()
    {
        return this.r;
    }
       
    public void setRed(int r)
    {
        this.r = r;
    }
     
    public int getGreen()
    {
        return this.g;
    }
 
    public void setGreen(int g)
    {
        this.g = g;
    }
       
    public int getBlue()
    {
        return this.g;
    }

    public void setBlue(int b)
    {
        this.b = b;
    }
        
    @Override
    public String toString()
    {
        String classString = String.format(
            "Cores:\nRed: %d\nGreen: %d\nBlue: %d\n",
            this.r,
            this.g,
            this.b);
        
        return classString;
    }
}
