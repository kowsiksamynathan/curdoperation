import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.adventnet.persistence.*;
import com.adventnet.ds.query.*;
import com.adventnet.db.api.RelationalAPI;
import java.sql.*;
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
            SelectQuery sq = new SelectQueryImpl(Table.getTable("Employee"));
            sq.addSelectColumn(Column.getColumn(null,"*"));
            DataObject dObj = DataAccess.get(sq);
            String query = RelationalAPI.getInstance().getSelectSQL(sq);
            RelationalAPI api = RelationalAPI.getInstance();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            conn = api.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            PrintWriter t = response.getWriter();
            while(rs.next()) {
                t.println(rs.getString("EMP_NAME"));
            }
//            if(dObj != null) {
//                //Row r = dataObject.getRow("Employee.TABLE");
//                
//                PrintWriter t = response.getWriter();
//                t.println(rs);
//            }
//        Table table = new Table("Employee");
//        Row r = new Row ("Employee");
//        Integer sample = 1234567;
//        r.set("EMP_ID", sample);
//        
//        r.set("EMP_NAME", "yyy");
      
//        DataObject dataObject = new WritableDataObject();
//            dataObject.addRow(r);
//       try
//        {
//        dataObject.addRow(r);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//             PrintWriter o = response.getWriter();
//            o.println("inside row object");
//        }
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
