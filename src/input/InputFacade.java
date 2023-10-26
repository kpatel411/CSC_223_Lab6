package input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import geometry_objects.points.Point;
import geometry_objects.points.PointDatabase;
import geometry_objects.Segment;
import input.builder.GeometryBuilder;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.segment.SegmentNode;
import input.parser.JSONParser;

public class InputFacade
{
	/**
	 * A utility method to acquire a figure from the given JSON file:
	 *     Constructs a parser
	 *     Acquries an input file string.
	 *     Parses the file.
     *
	 * @param filepath -- the path/name defining the input file
	 * @return a FigureNode object corresponding to the input file.
	 */
	public static FigureNode extractFigure(String filepath)
	{
//        // TODO
//		//so are we calling parser on a JSON object?
//		//call the file we want to read and then store the info into a JSON object?
//		JSONParser fileParser = new JSONParser(new GeometryBuilder());
//		//THIS IS WRONG...you need to find the file then read
//		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filepath); 
//		JSONParser parser = parser.parse(figureStr);
//		return toGeometryRepresentation(fileParser.);
		
		
		JSONParser parser = new JSONParser(new GeometryBuilder());

		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filepath);
		
		toGeometryRepresentation(parser.parse(figureStr));
				
		return parser.parse(figureStr);

	}
	
	/**
	 * 1) Convert the PointNode and SegmentNode objects to a Point and Segment objects 
	 *    (those classes have more meaningful, geometric functionality).
	 * 2) Return the points and segments as a pair.
     *
	 * @param fig -- a populated FigureNode object corresponding to a geometry figure
	 * @return a point database and a set of segments
	 */
	public static Map.Entry<PointDatabase, Set<Segment>> toGeometryRepresentation(FigureNode fig)
	{
		// TODO IS MAP SUPPOSE TO CONTAIN INTERABLE COMPOENETS OR DO WE JUST PASS VALUES
		PointDatabase pndb = fig.getPointsDatabase();//convert from pointNodeDB to pointdatabase
		SegmentDatabase sndb = fig.getSegments(); //get all segemnts w/ helper methods
		
		return new Map.Entry<PointDatabase, Set<Segment>>(pndb, sndb);
	
	}
	//use a convert method 

    //	
	// TODO: implement other support methods to facilitate the toGeometryRepresentation method
	// like WHAT???
}