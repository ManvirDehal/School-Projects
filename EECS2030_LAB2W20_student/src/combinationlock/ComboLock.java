package combinationlock;


	/**
	   A class to simulate a combination lock.
	*/
	public class ComboLock
	{
	   private int secret1;
	   private int secret2;
	   private int secret3;

	   // 0: nothing entered, 1: secret1 done, 2: secret2 done, 
	   // 3: secret3 done and unlocked
	   private int lockState;

	   private int currentNumber;
	   private boolean validSoFar;

	   /**
	      Initializes the combination of the lock.
	      @param secret1 first number to turn right to
	      @param secret2 second number to turn left to
	      @param secret3 third number to turn right to
	   */
	   public ComboLock(int secret1, int secret2, int secret3)
	   {
		  lockState = 0;
		  currentNumber = 0;
	      this.secret1 = secret1;
	      this.secret2 = secret2;
	      this.secret3 = secret3;
	   }

	   /**
	      Resets the state of the lock so that it can be opened again.
	   */
	   public void reset()
	   {
		   lockState = 0;
		   currentNumber = 0;
	   }

	   /**
	      Turns lock left given number of ticks.
	      @param ticks number of ticks to turn left
	   */
	   public void turnLeft(int ticks)
	   {
	      for(int x = 0; x < ticks; x++)
	      {
	    	  if(currentNumber > 0)
	    	  {
	    		  currentNumber--;
	    	  }
	    	  else
	    	  {
	    		  currentNumber = 39;
	    		  currentNumber--;
	    	  }
	      }
	      if(currentNumber == secret2 && lockState == 1)
	      {
	    	  lockState++;
	      }
	   }

	   /**
	      Turns lock right given number of ticks
	      @param ticks number of ticks to turn right
	   */
	   public void turnRight(int ticks)
	   {
		  if(lockState == 0)
		  {
			  currentNumber = ticks;
			  if(currentNumber == secret1)
			  {
				  lockState++;
			  }
		  }
	      if(lockState == 2)
	      {
	    	  for(int x = 0; x < ticks; x++) //24
		      {
		    	  if(currentNumber < 39)
		    	  {
		    		  currentNumber++;
		    	  }
		    	  else
		    	  {
		    		  currentNumber = 0;
		    		  currentNumber++;
		    	  }
		      }
	    	  if(currentNumber == secret3)
	    	  {
	    		  lockState++;
	    	  }
	    	  if(lockState == 3)
	    	  {
	    		  validSoFar = true;
	    	  }
	    	  else {
	    		  validSoFar = false;
	    		  reset();
	    	  }
	      }
	   }

	   /**
	      Returns true if the lock can be opened now
	      @return true if lock is in open state
	   */
	   public boolean open()
	   {
	      return validSoFar;
	   }
	}



