class ATM {

		public long curr[]= {0,0,0,0,0};
	    public ATM() {
	    	
	    }
	    
	    public void deposit(int[] banknotesCount) {
	        for(int i=0;i<5;i++) {
	        	this.curr[i]+=banknotesCount[i];
	        }
	    }
	    
	    public int[] withdraw(int amount) {
	        int temp[]=new int[5];
	        for(int i=4;i>=0;i--) {
	        	if(curr[i]==0) continue;
	        	if(i==4) {
	        		int div=amount/500;
	        		long sub=Math.min(curr[i],div);
	        		temp[i]+=sub;
	        		amount-=(sub*500);
	        		if(amount==0) break;
	        	}else if(i==3) {
	        		int div=amount/200;
	        		long sub=Math.min(this.curr[i],div);
	        		temp[i]+=sub;
	        		amount-=(sub*200);
	        		if(amount==0) break;
	        	}else if(i==2) {
	        		int div=amount/100;
	        		long sub=Math.min(this.curr[i],div);
	        		temp[i]+=sub;
	        		amount-=(sub*100);
	        		if(amount==0) break;
	        	}else if(i==1) {
	        		int div=amount/50;
	        		long sub=Math.min(this.curr[i],div);
	        		temp[i]+=sub;
	        		amount-=(sub*50);
	        		if(amount==0) break;
	        	}else if(i==0) {
	        		int div=amount/20;
	        		long sub=Math.min(this.curr[i],div);
	        		temp[i]+=sub;
	        		amount-=(sub*20);
	        		if(amount==0) break;
	        	}
	        }
	        
	        if(amount==0) {
	        	for(int i=0;i<5;i++) {
	        		this.curr[i]-=temp[i];
	        	}
	        	return temp;
	        }else{
	        	return new int[] {-1};
	        }
	    }
	}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */