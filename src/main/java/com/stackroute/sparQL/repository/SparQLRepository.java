package com.stackroute.sparQL.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

@Repository
public class SparQLRepository {

	public void dummyMethod() {

		List<RDFNode> node = new ArrayList<RDFNode>();
		
		String sparqlQuery = "PREFIX dbo: <http://dbpedia.org/ontology/>\n" + 
				"PREFIX dbr: <http://dbpedia.org/resource/>\n" + 
				"\n" + 
				"SELECT DISTINCT ?country ?capital\n" + 
				"WHERE {\n" + 
				" ?country a dbo:Country.\n" + 
				" ?country dbo:capital ?capital.\n" + 
				"} \n " +
				"LIMIT 50";
 
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		ResultSet result = queryExecution.execSelect();
		for(; result.hasNext() ; ) {
			System.out.println("working");
//			QuerySolution soln = result.nextSolution();
//			RDFNode a = soln.get("x") ;
//			node.add(a);
//			//System.out.println(soln);
		}
		ResultSetFormatter.out(System.out, result, query.getPrefixMapping());
		queryExecution.close();

	}
}

/*
 * String queryString = "SELECT DISTINCT ?s WHERE " + "{" +
 * "  ?s <http://www.w3.org/2000/01/rdf-schema#subClassOf> <http://www.w3.org/2002/07/owl#Thing> . "
 * +
 * "  FILTER ( ?s != <http://www.w3.org/2002/07/owl#Thing> && ?s != <http://www.w3.org/2002/07/owl#Nothing> ) . "
 * +
 * "  OPTIONAL { ?s <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?super . "
 * +
 * "  FILTER ( ?super != <http://www.w3.org/2002/07/owl#Thing> && ?super != ?s ) } . "
 * + "}";
 * QueryExecution qe = QueryExecutionFactory.create(query, model);
 */
// "PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
// "PREFIX yago: <http://dbpedia.org/class/yago/>\n" +
// "PREFIX dbp: <http://dbpedia.org/property/>\n" +
// "PREFIX dct: <http://purl.org/dc/terms/>\n" +
// "\n" +
// "SELECT DISTINCT *\n" +
// "WHERE\n" +
// " { ?country dct:subject \n"+
// " <http://dbpedia.org/resource/Category:Countries_in_Europe> ;\n" +
// " dbo:capital ?capital\n" +
// " }";
// String queryString = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" + "SELECT
// ?name\n" + "WHERE {\n"
// + " ?person foaf:name ?name .\n" + "}";

// SPARQLRepository repo = new SPARQLRepository(endPoints);
//
// repo.getDataDir();
//
//
// RepositoryConnection connection = repo.getConnection();
// create OntModel
/*
 * OntModel model = ModelFactory.createOntologyModel(); // read camera ontology
 * List<String> roots = new ArrayList<String>(); SailRepository rep = new
 * SailRepository(new MemoryStore()); rep.initialize(); String namespace =
 * "http://example.org/"; ValueFactory f = rep.getValueFactory(); IRI john =
 * f.createIRI(namespace, "john");
 * 
 * try {
 * 
 * RepositoryConnection conn = rep.getConnection(); // conn.add(john, RDF.TYPE,
 * f.createLiteral("Hi")); // // conn.add(john,
 * RDFS.label,f.createLiteral("John")); // conn.add(john, RDF.TYPE,FOAF.PERSON);
 * // RepositoryResult<Statement> statements = conn.getStatements(null, null, //
 * null); // org.eclipse.rdf4j.model.Model model =
 * QueryResults.asModel(statements); // model.setNamespace("rdf",
 * RDF.NAMESPACE); // // model.setNamespace("foaf", FOAF.NAMESPACE); // //
 * model.setNamespace("ex", namespace); // // Rio.write(model, System.out,
 * RDFFormat.TURTLE);
 * 
 * com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString);
 * QueryExecution qexec = QueryExecutionFactory.create(query, model);
 * 
 * ResultSet results = qexec.execSelect(); // TupleQuery tq =
 * rep.getConnection().prepareTupleQuery(QueryLanguage.SPARQL, // queryString);
 * // TupleQueryResult result = tq.evaluate(); // ResultSet result;
 * 
 * System.out.println("This is resulnumber of results" +
 * results.getRowNumber());
 * 
 * qexec.close();
 * 
 * } finally {
 * 
 * }
 */