package BioJava.BioJava;

import java.io.IOException;

import org.biojava.nbio.structure.Atom;
import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureTools;
import org.biojava.nbio.structure.asa.AsaCalculator;
import org.biojava.nbio.structure.asa.GroupAsa;
import org.biojava.nbio.structure.io.PDBFileReader;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Structure loadStructure(String pathToPDBFile){
        PDBFileReader pdbreader = new PDBFileReader();

        Structure structure = null;
        try{
                structure = pdbreader.getStructure(pathToPDBFile);
                //System.out.println(structure);
        } catch (IOException e) {
                e.printStackTrace();
        }
        return structure;
}
	public static void main( String[] args )
	{
		String filename =  "E://BiggestProjectsof4thyear//BioJava//5b0u.pdb" ;
		Structure s=loadStructure(filename);
		Atom[] caAtoms = StructureTools.getAtomCAArray(s);
		AsaCalculator asa=new AsaCalculator(caAtoms,AsaCalculator.DEFAULT_PROBE_SIZE,AsaCalculator.DEFAULT_N_SPHERE_POINTS , AsaCalculator.DEFAULT_NTHREADS);
	    /*GroupAsa[] gsa=asa.getGroupAsas();
	    double totalsa=0.0;
	    for(GroupAsa g:gsa)
	    {
	    	totalsa+=g.getAsaC();
	    	double gs=g.getAsaC();
	    	System.out.println("groupname:"+g.TOTALASA="+gs);
	    }
	    System.out.println("TOTALASA="+totalsa);
	    */
		double[] surfacearea=asa.calculateAsas();
	    double totalsa=0.0;
	    for(double sasa:surfacearea)
	    	totalsa=totalsa+sasa;
	    System.out.println(totalsa);
	}
}
