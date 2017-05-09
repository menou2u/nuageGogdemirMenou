package model.math;

import java.util.LinkedList;

public abstract class MathAlgo {

	
	
	//page 455
	public static Matrix list2Mat(LinkedList<Double> list, int nbCol){
		int size = list.size();
		if (nbCol<0)
		{
			System.out.println("Le nombre de colonnes dans doit être positif !");
			return null;
		}
		while (size - nbCol>nbCol)
		{
			size = size - nbCol;
		}
		int toAdd = nbCol-size;
		for (int i=0;i<toAdd;i++)
		{
			list.add(0.0);
		}
		size = list.size();
		int row = size/nbCol;
		if (row*nbCol<size)
		{
			row=row+1;
		}
		double[][] res = new double[row][nbCol];
		for (int i=0;i<size;i++)
		{
			System.out.println("i/nbCol : "+i/nbCol);
			res[i/nbCol][i%nbCol]=list.get(i).doubleValue();
		}
		
		return new Matrix(res);
	}
	
	//page 455
	public static LinkedList<Double> mat2List(Matrix A){
		LinkedList<Double> list = new LinkedList<Double>();
		double data[][] = A.getData();
		for (int i=0;i<data.length;i++)
		{
			for (int j=0;j<data[0].length;j++)
			{
				list.add((Double)data[i][j]);
			}
		}
		return list;
	}
	
	public static Matrix subMat(Matrix A, int debLigne, int debColonne, int finLigne, int finColonne){
    	int nbLignes = finLigne - debLigne + 1;
    	int nbColonnes = finColonne - debColonne + 1;
    	if (0 <= debLigne && debLigne <= nbLignes - 1
    		&& 0 <= debColonne && debColonne <= nbColonnes - 1
    		&& 0 <= finLigne && finLigne <= nbLignes - 1
    		&& 0 <= finColonne && finColonne <= nbColonnes - 1
    		&& debLigne < finLigne
    		&& debColonne < finColonne){
    		int compteurLignes = 0;
        	int compteurColonnes = 0;
        	double[][] subData = new double[nbLignes][nbColonnes];
        	for (int row = debLigne; row <= finLigne ; row++){
        		for (int col = debColonne; col <= finColonne ; col++){
            		subData[compteurLignes][compteurColonnes] = A.getData()[row][col];
            		System.out.println("j'ai mis "+A.getData()[row][col]+ " en coord ("+compteurLignes+","+compteurColonnes+")");

            		compteurColonnes++;
            		System.out.println("cc "+compteurColonnes);
            	}
        		compteurColonnes = 0;
        		compteurLignes++;
        		System.out.println("cl " +compteurLignes);
        	}
        	return new Matrix(subData);
    	}
    	else {
    		System.out.println("Error : illegal indexes arguments");
    		return null;
    	}
 
    }
	
	public static void main(String[] args) {
        double[][] d = { { 3, 4, 5 }, { 1, 2, 6 } };
        System.out.println("d: "+d);
        Matrix A = new Matrix(d);
        System.out.println("A: ");
        A.show();
        LinkedList<Double> list = mat2List(A);
        System.out.println("list: "+list);
        Matrix B = list2Mat(list,3);
        System.out.println("B: ");
        B.show();
        Matrix C = list2Mat(list,4);
        System.out.println("C: ");
        C.show();
	}
	
}
