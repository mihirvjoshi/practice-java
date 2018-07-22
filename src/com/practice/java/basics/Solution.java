package com.practice.java.basics;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public enum EXPRESSIONS {         
        ADD(0), SUBTRACT(1), MULTIPLY(2), DIVIDE(3), MIN(4), MAX(5);
        private int value;
        private EXPRESSIONS(int value){
            this.value=value;
        }
        
        public int evaluate(EXPRESSIONS exp, int[] values){
        	int total=0; 
        	if(exp.value==0){
            	for (int j = 0; j < values.length; j++) {
            		total=total+values[j];
    			}
        	}else if(exp.value==1){
        		total=values[0];
            	for (int j = 1; j < values.length; j++) {
            		total=total - values[j];
    			}
        	}else if(exp.value==2){
        		total=1;
            	for (int j = 0; j < values.length; j++) {
            		total=total*values[j];
    			}
        	}else if(exp.value==3){
        		total=values[0];
            	for (int j = 1; j < values.length; j++) {
            		total=total/values[j];
    			}
        	}else if(exp.value==4){
        		total=Integer.MAX_VALUE;
            	for (int j = 0; j < values.length; j++) {
            		total=Math.min(total, values[j]);
    			}
        	}else if(exp.value==5){
        		total=Integer.MIN_VALUE;
            	for (int j = 0; j < values.length; j++) {
            		total=Math.max(total, values[j]);
    			}
        	}        	
			return total;        		
        }
}

   public class ExpressionEvaluator implements Comparable<ExpressionEvaluator>{
	  private String originalExpression;
      private EXPRESSIONS expression;
      private int[] values;
      int total;
       
      ExpressionEvaluator(String exps) {
    	  this.originalExpression=exps;
          init(exps);
      }
       
      ExpressionEvaluator() {
      }

      private void init(String exps) {
          if(exps!=null){
              String[] params = exps.split(",");
              values=new int[params.length-1];
              this.expression=EXPRESSIONS.valueOf(params[0]);
              int i=1;
              while(params!=null && params.length>1 && i<params.length){
                  this.values[i-1]=Integer.parseInt(params[i]);
                  i++;
              }
             this.total=this.expression.evaluate(this.expression, this.values);
          }          
      }
       
       public boolean equals(Object o) {
           if (!(o instanceof ExpressionEvaluator))
               return false;
           ExpressionEvaluator n = (ExpressionEvaluator) o;
           return n.originalExpression.equals(this.originalExpression)&&n.expression.value==this.expression.value && n.total==(this.total);
       }

		public int hashCode(){
			return this.originalExpression.hashCode()+this.expression.value + this.total + 31;			
		}

		@Override
		public int compareTo(ExpressionEvaluator o) {
			if(this.total>o.total) return 1;
			else if(this.total<o.total) return -1;
			else if(this.total==o.total) return 0;
			return 0;
		}

  }

    /*
     * Complete the function below.
     */
    static void fancySort(String[] exps) {
    	Set<ExpressionEvaluator> expressionSet = new TreeSet<ExpressionEvaluator>();
    	if(exps!=null){
    		for (int i = 0; i < exps.length; i++) {
    			expressionSet.add(new Solution().new ExpressionEvaluator(exps[i]));
			}
    		for (Iterator iterator = expressionSet.iterator(); iterator
					.hasNext();) {
				ExpressionEvaluator expressionEvaluator = (ExpressionEvaluator) iterator
						.next();
				System.out.println(expressionEvaluator.originalExpression+"=>"+expressionEvaluator.total);
			}
    	}    	
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _exps_size = 0;
        _exps_size = Integer.parseInt(in.nextLine().trim());
        String[] _exps = new String[_exps_size];
        String _exps_item;
        for(int _exps_i = 0; _exps_i < _exps_size; _exps_i++) {
            try {
                _exps_item = in.nextLine();
            } catch (Exception e) {
                _exps_item = null;
            }
            _exps[_exps_i] = _exps_item;
        }
        
        fancySort(_exps);
        
    }
	
}
    
	
