import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.adventnet.persistence.*;
import com.adventnet.ds.query.*;
import com.adventnet.db.api.RelationalAPI;
import java.sql.*;
import java.util.Iterator;
public class Hello extends HttpServlet {
    
    private String message;
    
    public void init() throws ServletException {
     
        message = "Hello World welcome to mickey";
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try
        {
            response.setContentType("text/html");
            
            PrintWriter out = response.getWriter();
            
            out.println("<h1>" + message + "</h1>");
    
            Criteria c = new Criteria(new Column("Employee", "EMP_ID"),"2", QueryConstants.EQUAL);
            DataObject d =DataAccess.get("Employee",c);
            Row r = d.getRow("Employee");
            
            
            // set the modified value in the row
            r.set("EMP_NAME","xxx");
            
            //update the modified row in DO
            d.updateRow(r);
            
            //Persists the changes done in the given dataObject into the database.
            DataAccess.update(d);

        }
        
        catch(Exception e)
        
        {
            
            e.printStackTrace();
            
            PrintWriter t = response.getWriter();
            
            t.println(e);
            
        }
        
    }
    
    public void destroy() {
        
    }
    
    }





































//with api retrive

//try
//{
//response.setContentType("text/html");
//PrintWriter out = response.getWriter();
//out.println("<h1>" + message + "</h1>");
//SelectQuery sq = new SelectQueryImpl(Table.getTable("Employee"));
//sq.addSelectColumn(Column.getColumn(null,"*"));
//DataObject dObj = DataAccess.get(sq);
//String query = RelationalAPI.getInstance().getSelectSQL(sq);
//RelationalAPI api = RelationalAPI.getInstance();
//Connection conn = null;
//Statement stmt = null;
//ResultSet rs = null;
//conn = api.getConnection();
//stmt = conn.createStatement();
//rs = stmt.executeQuery(query);
//PrintWriter t = response.getWriter();
//while(rs.next()) {
//t.println(rs.getString("EMP_NAME"));
//}
//
//}
//catch(Exception e)
//{
//e.printStackTrace();
//PrintWriter t = response.getWriter();
//t.println(e);
//
//}





//without api retrive data


//try
//{
//Criteria c = new Criteria(new Column("Employee", "EMP_ID"),"1", QueryConstants.EQUAL);
//
//DataObject d = DataAccess.get("Employee",c);
//
//Iterator it=d.getRows("Employee");
//
//while(it.hasNext())
//{
//// returns a row
//Row r=(Row)it.next();
//// to return each column value of the row
//
//out.println(r.get(1));
//
//out.println(r.get(2));
//}
//



//add data in the db


//try
//{
//response.setContentType("text/html");
//PrintWriter out = response.getWriter();
//out.println("<h1>" + message + "</h1>");
//
//long s=123467;
//
//// Creating new Row
//Row r = new Row ("Employee");
//
//r.set("EMP_ID",s);
//r.set("EMP_NAME", "yyyyyyy");
//
//
//// Creating (or) Fetching a DataObject
//
//DataObject dataObject = new WritableDataObject();
//// Adding Row to DataObject
//dataObject.addRow(r);
//DataAccess.update(dataObject);
//
//}





//
//
//deleteRows in db
//try
//{
//response.setContentType("text/html");
//
//PrintWriter out = response.getWriter();
//
//out.println("<h1>" + message + "</h1>");
//
//DataObject d =DataAccess.get("Employee",(Criteria)null);
//
//Criteria c = new Criteria(new Column("Employee", "EMP_ID"),new Integer(1), QueryConstants.EQUAL);
//
//d.deleteRows("Employee",c);
//
//DataAccess.update(d);
//
//}

