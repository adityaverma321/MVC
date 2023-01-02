package mvc.bean;

public class Bean
{
    private String fname, lname;
    private int roll;

   public Bean()
   {
     
   }
   public Bean(int roll, String fname, String lname)
   {
         this.fname=fname;
         this.roll=roll;
         this.lname=lname;
   }

   public void setFname(String fname)
   {
     this.fname=fname;
   }
   public void setLname(String lname)
   {
     this.lname=lname;
   }
   public void setRoll(int roll)
   {
     this.roll=roll;
   
   }

   public String getFname()
  {
    return this.fname;
  }
  public String getLname()
  {
    return this.lname;
  }
  public int getRoll()
  {
    return this.roll;
  }
}