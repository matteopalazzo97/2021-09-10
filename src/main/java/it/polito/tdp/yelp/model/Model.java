package it.polito.tdp.yelp.model;

import java.util.List;
import java.util.LinkedList;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	private YelpDao dao;
	private Graph<VerticiLatLng, DefaultWeightedEdge> grafo;
	
	public Model() {
		super();
		this.dao = new YelpDao();		
	}
	
	public List<String> getCity(){
		return this.dao.getCity();
	}
	
	public void creaGrafo(String city) {
		
		this.grafo = new SimpleWeightedGraph<VerticiLatLng, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, this.dao.getVertici(city));
		
		List<VerticiLatLng> archiamo = this.dao.getVerticiLatLng(city);
		
		for(int i = 0; i <= archiamo.size(); i++) {
			for(int j = i+1; j <= archiamo.size() -1; j++) {
				this.grafo.addEdge(archiamo.get(i), archiamo.get(j));
				Double dist = LatLngTool.distance(archiamo.get(i).getPos(), archiamo.get(j).getPos(), LengthUnit.KILOMETER);
				this.grafo.setEdgeWeight(archiamo.get(i), archiamo.get(j), dist);
			}
		}
		
	}

	public int getNumVertici() {
		return this.grafo.vertexSet().size();
	}

	public int getNumArchi() {
		return this.grafo.edgeSet().size();
	}

	public List<VerticiLatLng> getVerticiLatLng(String city) {
		return this.dao.getVerticiLatLng(city);
	}

	public LocaleDist distante(VerticiLatLng locale, String city) {
		
		LocaleDist dist = null;
		
		Double max = 0.0;
		
		List<VerticiLatLng> lista =  this.dao.getVerticiLatLng(city);
		
		for(VerticiLatLng v: lista) {
			if(!locale.equals(v)) {
				if(this.grafo.getEdgeWeight(this.grafo.getEdge(locale, v))  > max)
					max = this.grafo.getEdgeWeight(this.grafo.getEdge(locale, v));	
			}
		}
		System.out.println(max);
		
		for(VerticiLatLng v: lista) {
			if(!locale.equals(v)) {
				if(this.grafo.getEdgeWeight(this.grafo.getEdge(locale, v))  == max)
					dist = new LocaleDist(v, max);	
			}
		}
		
		return dist;
		
	}
	
}
