import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Spark.Car;
import Controller.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

@WebServlet(urlPatterns = {"/NatthasetA"})
public class NatthasetA extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Car car = (Car) session.getAttribute("car");

            boolean name = car == null;
{
                car = new Car();
                car.setName(request.getParameter("name"));
                car.setEmail(request.getParameter("email"));
                car.setCarType(request.getParameter("carType"));
                car.setCarColor(request.getParameter("carColor"));
                car.setPaymentType(request.getParameter("paymentType"));
                car.setCarPrice(request.getParameter("carPrice"));
                session.setAttribute("car", car);

                DBConnection dbConnection = new DBConnection();
                if (!dbConnection.insertNewCar(car)) {
                    System.out.println(">>>NatthasetA ERROR");
                }
                session.setAttribute("car", car);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/addNewCarSuccess.jsp");
                rd.forward(request, response);
                
            //} else {
                //out.println("<html><body><b>ข้อมูลเดิม:</b>" + car.getName() + ";"
                       // + car.getEmail() + ";"
                       // + car.getCarType() + ";"
                      //  + car.getCarColor() + ";"
                       // + (car.getPaymentType().equals("cash") ? "สด" : "ผ่อนชำระ") + ";"
                       // + car.getCarPrice()
                      //  + "<br/><br/><br/>");

                //out.println("<h1>แก้ไขข้อมูล</h1>");
                //out.println("<form action='NatthasetA' method='post'>");
                //out.println("ชื่อ: <input type='text' name='name' value='" + car.getName() + "'><br/>");
                //out.println("อีเมล: <input type='text' name='email' value='" + car.getEmail() + "'><br/>");
                //out.println("ประเภทรถ: <select name='carType'>");
                //out.println("<option value=\"Lambor\">Lambor</option>");
                //out.println("<option value=\"Benz\">Benz</option>");
                //out.println("<option value=\"Toyota\">Toyota</option>");  // Fixed missing < here
                //out.println("<option value=\"Yamaha\">Yamaha</option>");
                //out.println("<option value=\"BMW\">BMW</option></select><br/>");
                //out.println("สีรถ: <select name='carColor'>");
                //out.println("<option value=\"White\">White</option>");
                //out.println("<option value=\"Orange\">Orange</option>");
                //out.println("<option value=\"Gray\">Gray</option>");
                //out.println("<option value=\"Cream\">Cream</option>");
                //out.println("<option value=\"Black\">Black</option></select><br/>");
                //out.println("การเลือกซื้อ: ");
                //out.println("<input type='radio' name='paymentType' value='cash' " + (car.getPaymentType().equals("cash") ? "checked" : "") + "> สด ");
               // out.println("<input type='radio' name='paymentType' value='installment' " + (car.getPaymentType().equals("installment") ? "checked" : "") + "> ผ่อนชำระ <br/>");
               // out.println("ราคา: <input type='text' name='carPrice' value='" + car.getCarPrice() + "'><br/>");
                //out.println("<input type='submit' value='บันทึก'>");
                //out.println("</form>");
                //session.setAttribute("car", car);
            }

        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print("<html><body>");
                out.print("Error: " + e.getMessage());
                out.print("</body></html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for handling car reservations";
    }
}
