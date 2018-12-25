import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {

	static String output="";
	static String bbridgr="";
	static String bbridgr2="";
	static String bbridgr3="";
	static String bbridgr4="";
	static String bbridgr5="";
	static String bbridgr6="";
	static String bbridgr7="";
	static String bbridgr8="";
	
	static int[][]  a=new int[81][2];
	static int      kernel=0;
	static int      flagall=0;
	static int       flagh=0;
	static int number;
	static int count;
	private static int[][] sudu= new int[9][9];
		
   public static void main(String[] args) {
	   
	   String load="";
	   Input input = new Input(args);
	   //ִ��������������
	   if (args[0].equals("-c"))
		 {
		   count=input.getnum();
		   for(number=0;number<count/9;number++) {
			   flagall=0;
			   bbridgr="";
			   bbridgr2="";
			   bbridgr3="";
			   bbridgr4="";
			   bbridgr5="";
			   bbridgr6="";
			   bbridgr7="";
			   bbridgr8="";
	    		for(int n=0;n<9;n++)
	    			for(int m=0;m<9;m++)
	    			     sudu[n][m]=0;
	    		 createPer(sudu);	    		 	 
	    		 create(sudu,1,0);   		 
	    		 //System.out.println(number);
		   }
		   for(number=0;number<count%9;number++) {
			   flagall=0;
			   flagh=1;
			   for(int n=0;n<9;n++)
	    			for(int m=0;m<9;m++)
	    			     sudu[n][m]=0;
	    		 createPer(sudu);	    		 	 
	    		 create(sudu,1,0);   		 
	    		 //System.out.println(number);
		   }
		   new Output().createFile(output);
		 }
		 //ִ�н�������ĳ���
	   else	
		  {
		   String problem="";
		   String s=null;
		   load=input.getload();
		   File file =new File(load);
		   BufferedReader bReader;
		   try {
	    		bReader = new BufferedReader(new FileReader(file));
				while ( (s=bReader.readLine())!=null ) {
					 problem=problem+System.lineSeparator()+s;				
				}
				bReader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    int kk=0;
			int jj=0;
			    count=0;
			while(count<problem.length()) {
				flagall=0;
				kernel=0;
				for(;count<problem.length();count++) {
					if (Character.isDigit(problem.charAt(count))) {
						sudu[kk][jj]=Integer.parseInt(problem.substring(count,count+1));
					jj++;
					if (jj==9) {
						kk++;
						jj=0;
					}
					if (kk==9) {
						kk=0;
						jj=0;
						count++;
						break;
					}
					}			
				}
				for(int i=0;i<9;i++)
				for(int j=0;j<9;j++) {
					if(sudu[i][j]==0) {
						a[kernel][0]=i;
						a[kernel][1]=j;
						kernel++;
					}
				}
			 solve(sudu, 0);		 	 
			 output=output+"\r"+"\n";
			}			
			
			new Output().createFile(output);				
		}		    		  	      	   
   }
   
//����һ��������Ŀ�ĺ���
   public static void create(int[][] sudu,int i, int j) {
   	    int flag=0;	   	    
		if (i==9 && j==0) {
			for(int ii=0;ii<9;ii++)
	        	   for(int j1=0;j1<9;j1++) {
	        		   output=output+sudu[ii][j1]+" ";
	        		   
	        		   //��Խ���ǰ���еĵڶ�����
	        		   if (ii==1&&flagh==0) {
						 bbridgr2=bbridgr2+sudu[ii+1][j1]+" ";
					    }
	        		   else if (ii==2&&flagh==0) {
	        			   bbridgr2=bbridgr2+sudu[ii-1][j1]+" ";
					    }
	        		   else if(flagh==0){
	        			   bbridgr2=bbridgr2+sudu[ii][j1]+" ";
					   }
	        		   
	        		 //��Խ����м����е�ǰ����
	        		   if (ii==3&&flagh==0) {
							 bbridgr3=bbridgr3+sudu[ii+1][j1]+" ";
						    }
		        		   else if (ii==4&&flagh==0) {
		        			   bbridgr3=bbridgr3+sudu[ii-1][j1]+" ";
						    }
		        		   else if(flagh==0){
		        			   bbridgr3=bbridgr3+sudu[ii][j1]+" ";
						   }
	        		   
	        		 //��Խ����м����еĺ�����
	        		   if (ii==4&&flagh==0) {
							 bbridgr4=bbridgr4+sudu[ii+1][j1]+" ";
						    }
		        		   else if (ii==5&&flagh==0) {
		        			   bbridgr4=bbridgr4+sudu[ii-1][j1]+" ";
						    }
		        		   else if(flagh==0){
		        			   bbridgr4=bbridgr4+sudu[ii][j1]+" ";
						   }
	        		   
	        		 //��Խ����м����е�  ��һ�͵�����
	        		   if (ii==3&&flagh==0) {
							 bbridgr5=bbridgr5+sudu[ii+2][j1]+" ";
						    }
		        		   else if (ii==5&&flagh==0) {
		        			   bbridgr5=bbridgr5+sudu[ii-2][j1]+" ";
						    }
		        		   else if(flagh==0&&flagh==0){
		        			   bbridgr5=bbridgr5+sudu[ii][j1]+" ";
						   }
	        		   
	        		 //��Խ���������е�  ��һ�͵ڶ���
	        		   if (ii==6&&flagh==0) {
							 bbridgr6=bbridgr6+sudu[ii+1][j1]+" ";
						    }
		        		   else if (ii==7&&flagh==0) {
		        			   bbridgr6=bbridgr6+sudu[ii-1][j1]+" ";
						    }
		        		   else if(flagh==0&&flagh==0){
		        			   bbridgr6=bbridgr6+sudu[ii][j1]+" ";
						   }
	        		   
	        		 //��Խ���������е�  �ڶ��͵�����
	        		   if (ii==7&&flagh==0) {
							 bbridgr7=bbridgr7+sudu[ii+1][j1]+" ";
						    }
		        		   else if (ii==8&&flagh==0) {
		        			   bbridgr7=bbridgr7+sudu[ii-1][j1]+" ";
						    }
		        		   else if(flagh==0&&flagh==0){
		        			   bbridgr7=bbridgr7+sudu[ii][j1]+" ";
						   }
	        		   
	        		 //��Խ���������е�  ��һ�͵�����
	        		   if (ii==6&&flagh==0) {
							 bbridgr8=bbridgr8+sudu[ii+2][j1]+" ";
						    }
		        		   else if (ii==8&&flagh==0) {
		        			   bbridgr8=bbridgr8+sudu[ii-2][j1]+" ";
						    }
		        		   else if(flagh==0){
		        			   bbridgr8=bbridgr8+sudu[ii][j1]+" ";
						   }
	        		   
	        		   if (ii>=0 && ii<=2&&flagh==0) {
						   bbridgr=bbridgr+sudu[ii][j1]+" ";
					   }
	        		   else if (ii>=3 && ii<6&&flagh==0) {
	        			   bbridgr=bbridgr+sudu[ii+3][j1]+" ";
					    }
	        		   else if (ii>=6 && ii<9&&flagh==0) {
	        			   bbridgr=bbridgr+sudu[ii-3][j1]+" ";
					    }					   	        		   	        		   
	        		   if (j1==8) {
						output=output+"\r"+"\n";
						if (flagh==0) {
						bbridgr=bbridgr+"\r"+"\n";
						bbridgr2=bbridgr2+"\r"+"\n";
						bbridgr3=bbridgr3+"\r"+"\n";
						bbridgr4=bbridgr4+"\r"+"\n";
						bbridgr5=bbridgr5+"\r"+"\n";
						bbridgr6=bbridgr6+"\r"+"\n";
						bbridgr7=bbridgr7+"\r"+"\n";
						bbridgr8=bbridgr8+"\r"+"\n";
						}						
	        	        }	        		   
	        	     }
	        	  //�������ִ��������������Ŀʱ��һ������һ�����ɣ�����Ҫִ������Ĵ���
			if (flagh==0) {
		 output=output+"\r"+"\n";
		 output=output+bbridgr;
 		 output=output+"\r"+"\n";
 		 output=output+bbridgr2;
		 output=output+"\r"+"\n";
		 output=output+bbridgr3;
 		 output=output+"\r"+"\n";
 		 output=output+bbridgr4;
		 output=output+"\r"+"\n";
		 output=output+bbridgr5;
 		 output=output+"\r"+"\n";
 		 output=output+bbridgr6;
		 output=output+"\r"+"\n";
		 output=output+bbridgr7;
 		 output=output+"\r"+"\n";
 		output=output+bbridgr8;
		 //output=output+"\r"+"\n";
			}
		output=output+"\r"+"\n";
 		 flagall=1;
			return ;
		}
		
		for(int n=1; n<=9 ; n++) {
			flag=0;
			for(int ii=0; ii<i; ii++)//�м��
			     if(sudu[ii][j]==n && ii!=i)			        
			    	 {
			    	  flag=1;
			    	  break;		         			        
			    	 }
			if (flag==1) {
				continue;
			}
		   for(int ii=0; ii<j; ii++)//�м��
			     if(sudu[i][ii]==n && ii!=j)
			        {
			    	  flag=1;
			    	  break;		         			        
			    	 }
			if (flag==1) {
				continue;
			}
			        
		   for(int ii=i/3*3; ii<=i/3*3+2; ii++)
			   for(int jj=j/3*3; jj<=j/3*3+2; jj++)//���ڿ��ڼ��
				   if(sudu[ii][jj]==n && !(ii==i&&jj==j) )
				     {
				       flag=1;
				       break;		         			        
				     }
				if (flag==1) {
					continue;
				}
				sudu[i][j]=n;														
				  if (j==8) create(sudu,i+1, 0);					  
				     else 	create(sudu,i,j+1);	
				  sudu[i][j]=0;
				  if (flagall==1) {
					return ;
				}
		   }		        	
		return ;
	}

//����һ��ȫ���У���Ϊ�����ĵ�һ��  
   public static void createPer(int[][] sudu) {
	   sudu[0][0]=3;
	   int flag=0;
	   int flag2=0;
	   for (int i = 1; i < 9; i++) {
		     flag2=0;
	         flag=0;
           int  bridge;
           while (flag==0) {
          	flag2=0;
          	bridge = (int)(Math.random()*10);				
				for(int ii=0; ii<i; ii++)//�м��
		  		     if( (sudu[0][ii]==bridge && ii!=i) || bridge==0)
		  		       {
	      		    	 flag=0;
	      		    	 flag2=1;
	      		    	 break;
	      		       }
					if (flag2==1) {
						continue;
					}				
				flag=1;
	    	    sudu[0][i]=bridge;
			   }          
	     }
	   return ;
   }
//����������   
   public  static void solve(int[][] sudu, int i) {
   	if (i==kernel) {
   	 for(int ii=0;ii<9;ii++)
		     for(int j=0;j<9;j++)
		     {
		    	 output=output+sudu[ii][j]+" ";
		    	 if (j==8) {
					output=output+"\r"+"\n";
				}
		     }
   	        flagall=1;
			return ;
		}
   	int flag=0;
   	for(int n=1; n<=9 ; n++) {
			flag=0;
			for(int ii=0; ii<9; ii++)//�м��
			     if(sudu[ii][a[i][1]]==n && ii!=a[i][0])			        
			    	 {
			    	  flag=1;
			    	  break;		         			        
			    	 }
			if (flag==1) {
				continue;
			}
		   for(int ii=0; ii<9; ii++)//�м��
			     if(sudu[a[i][0]][ii]==n && ii!=a[i][1])
			        {
			    	  flag=1;
			    	  break;		         			        
			    	 }
			if (flag==1) {
				continue;
			}
			        
		   for(int ii=a[i][0]/3*3; ii<=a[i][0]/3*3+2; ii++)
			   for(int jj=a[i][1]/3*3; jj<=a[i][1]/3*3+2; jj++)//���ڿ��ڼ��
				   if(sudu[ii][jj]==n && !(ii==a[i][0]&&jj==a[i][1]) )
				     {
				       flag=1;
				       break;		         			        
				     }
				if (flag==1) {
					continue;
				}
				sudu[a[i][0]][a[i][1]]=n;				
				solve(sudu, i+1);
				sudu[a[i][0]][a[i][1]]=0;
				if (flagall==1) {
					return ;
				}
		   }
   	return ;
	}
}

//���뺯��
 class Input {
	 private static int num;
	 private static String load;
	 public Input(String[] args) {
		// TODO Auto-generated constructor stub
	        	if(args[0].equals("-c")) {
	        		for (int j = args[1].length()-1; j >=0; j--) {
						if (!Character.isDigit(args[1].charAt(j))) {
							System.out.println("�����ʽӦ��Ϊ -c + ����");
							System.exit(0);
						}						
					}
	        		num=Integer.parseInt(args[1]);
	        	}
	        	else if (args[0].equals("-s")) {
					    load=args[1];
				} else {
					System.out.println("��������ȷ��ָ��  ��-c+���֡� ��-s+����·����");
				}
	 }
	
	public int getnum() {
		return num;
	}
	
	public String getload() {
		return load;
	}

}

//�������
 class Output{
	public boolean createFile(String ouput) {
		boolean flag=false;
		File file = new File("sudoku.txt");
		if(file.exists()) {
		   file.delete();		   
	    }
		try {
			boolean b=file.createNewFile();
			if (b) {
				System.out.println("win");
			}
			else {
				System.out.println("false");
			}
			flag=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}
		FileOutputStream fileOutputStream=null;
		try {
			fileOutputStream=new FileOutputStream(file);
			fileOutputStream.write(ouput.toString().getBytes("GBK"));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("д��ʧ��!");
		}
		try {
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
 }
 

  




