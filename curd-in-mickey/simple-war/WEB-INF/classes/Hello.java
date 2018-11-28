import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.Object;
import com.adventnet.persistence.*;
import com.adventnet.ds.query.*;
import com.adventnet.ds.notification.*;
import com.adventnet.db.api.RelationalAPI;
import com.adventnet.persistence.PersistenceBean;
import com.adventnet.mfw.bean.*;
import com.adventnet.persistence.PersistenceUtil;
import com.adventnet.persistence.Row;
import com.adventnet.persistence.*;
import com.adventnet.persistence.DataObject;
import com.adventnet.mfw.message.*;
import java.sql.*;
import java.util.Iterator;
import javax.transaction.*;
import java.util.*;

















public class Hello extends HttpServlet {
    
    private String message;
    
    public void init() throws ServletException {
        message = "Hello World welcome to mickey";
    }
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try
        {
            
            PrintWriter t = response.getWriter();
            t.println(message);
          
            
            
            Table table1 = new Table("Employee");
            SelectQuery sq = new SelectQueryImpl(table1);
            Column col1 = new Column("Employee","EMP_ID");
            Column col2 = new Column("Employee","EMP_NAME");
            Column col3 = new Column("Team","EMP_ID");
            Column col4 = new Column("Team","EMP_PLACE");
     
            ArrayList colList = new ArrayList();

            colList.add(col1);
            colList.add(col2);
            colList.add(col3);
            colList.add(col4);
            
            sq.addSelectColumns(colList);
        
            Join join = new Join("Employee", "Team", new String[]{"EMP_ID"}, new String[]{"EMP_ID"}, Join.INNER_JOIN);
          
            sq.addJoin(join);
            
            
            Persistence per= (Persistence)BeanUtil.lookup("Persistence");
            DataObject d =per.get(sq);
           
             t.println(d);
            
            
            
            
            
            
            Iterator i=d.getRows("Employee");
            
            while(i.hasNext())
            {
                
                Row r=(Row)i.next();
                
                
                t.println(r.get(1));
                
                t.println(r.get(2));
                
            }
            
            
            

            
            
            
            Iterator it=d.getRows("Team");
            
            while(it.hasNext())
            {
                
            Row r=(Row)it.next();
            
                
            t.println(r.get(1));
            
            t.println(r.get(2));
             
            }

            
           
     

            
            
            
            
            
            
            
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            PrintWriter t = response.getWriter();
            t.println(e);
        }
    }
    
    public void destroy() {                 }
    
    
    
    }





//performing join and retrive getting specific column values


//
//
//
//try
//{
//
//PrintWriter t = response.getWriter();
//t.println(message);
//
//
//
//Table table1 = new Table("Employee");
//SelectQuery sq = new SelectQueryImpl(table1);
//Column col1 = new Column("Employee","EMP_ID");
//Column col2 = new Column("Employee","EMP_NAME");
//Column col3 = new Column("Team","EMP_ID");
//Column col4 = new Column("Team","EMP_PLACE");
//
//ArrayList colList = new ArrayList();
//
//colList.add(col1);
//colList.add(col2);
//colList.add(col3);
//colList.add(col4);
//
//sq.addSelectColumns(colList);
//
//Join join = new Join("Employee", "Team", new String[]{"EMP_ID"}, new String[]{"EMP_ID"}, Join.INNER_JOIN);
//
//sq.addJoin(join);
//
//
//Persistence per= (Persistence)BeanUtil.lookup("Persistence");
//DataObject d =per.get(sq);
//
//t.println(d);
//
//
//Iterator it=d.getRows("Team");
//
//while(it.hasNext())
//{
//
//Row r=(Row)it.next();
//
//
//t.println(r.get(1));
//
//t.println(r.get(2));
//
//}
//
//















//performing joins


//
//try
//{
//
//PrintWriter t = response.getWriter();
//t.println(message);
//
//
//
//Table table1 = new Table("Employee");
//SelectQuery sq = new SelectQueryImpl(table1);
//sq.addSelectColumn(Column.getColumn(null,"*"));
//
//// Join
//Join join = new Join("Employee", "Team", new String[]{"EMP_ID"}, new String[]{"EMP_ID"}, Join.INNER_JOIN);
//
//sq.addJoin(join);
//
//
//
////  selectQuery.addJoin(join);
//
//Persistence per= (Persistence)BeanUtil.lookup("Persistence");
//DataObject d =per.get(sq);
//
//t.println("answer is :"+d);
//
//}
//















//update without api


//
//try
//{
//PrintWriter t = response.getWriter();
//t.println(message);
//
//Persistence per= (Persistence)BeanUtil.lookup("Persistence");
//
//UpdateQuery s = new UpdateQueryImpl("Employee");
//
//Criteria c = new Criteria(new Column("Employee", "EMP_NAME"),"kowsikkowsik", QueryConstants.EQUAL);
//
//s.setCriteria(c);
//
//s.setUpdateColumn("EMP_NAME","updated");
//
//per.update(s);
//
//
//}











// update with api


//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        RelationalAPI relapi = RelationalAPI.getInstance();
//        Connection conn = null;
//        Statement stmt = null;
//        DataSet ds = null;
//        try
//        {
//            conn = relapi.getConnection();
//            String query = "UPDATE Employee SET EMP_NAME=? WHERE EMP_ID=?";
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString(1, "kowsikkowsik");
//            preparedStmt.setInt   (2, 2);
//            preparedStmt.executeUpdate();
//            conn.close();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//            PrintWriter t = response.getWriter();
//            t.println(e);
//        }
//    }
//    
//    public void destroy() {                 }
//}














//with api retrive

    
//try
//{
//response.setContentType("text/html");
//PrintWriter out = response.getWriter();
//out.println("<h1>" + message + "</h1>");
//
//SelectQuery sq = new SelectQueryImpl(Table.getTable("Employee"));
//
//sq.addSelectColumn(Column.getColumn(null,"*"));
//
//DataObject dObj = DataAccess.get(sq);
//
//String query = RelationalAPI.getInstance().getSelectSQL(sq);
//
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

//
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






//deleteRows in db

//
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







//persistence add data in db


//try
//{
//response.setContentType("text/html");
//
//PrintWriter out = response.getWriter();
//
//out.println("<h1>" + message + "</h1>");
//
//long s=978733;
//
//Row r = new Row ("Employee");
//r.set("EMP_ID",s);
//r.set("EMP_NAME", "wwwwwww");
//
//
////to add the new row in the DataObject
//
//DataObject d=new WritableDataObject();
//d.addRow(r);
//
////Persists the changes done in the given dataObject into the database.
//
//Persistence per= (Persistence)BeanUtil.lookup("Persistence");
//per.add(d);
//
//}








//adding transaction manager



//TransactionManager txMgr = DataAccess.getTransactionManager();

//try
//{
//txMgr.begin();
//{
//PrintWriter t = response.getWriter();
//
//t.println("beginner");
//
//}
//}
//catch (Exception e)
//{
//PrintWriter t = response.getWriter();
//
//t.println("manager exception");
//
//}


//MessageListener listener = new SampleListener();
//Messenger.subscribe("DataModelTopic", listener, true, null);
//Persistence pers = (Persistence)BeanUtil.lookup("Persistence");
//DataObject dob = DataAccess.constructDataObject();
//Row row = new Row("Employee");
//row.set("EMP_ID",6);
//row.set("EMP_NAME","karthik");
//dob.addRow(row);
//pers.add(dob);
//Messenger.unsubscribe("DataModelTopic", listener);
//
//
















//destroy table



//        DataAccess.dropTable("Employee");
//

