package software.ujithamigara.codechallengejavaee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ujithamigara.codechallengejavaee.DTO.CustomerDTO;
import software.ujithamigara.codechallengejavaee.bo.BOFactory;
import software.ujithamigara.codechallengejavaee.bo.custom.CustomerBO;

import java.io.IOException;

@WebServlet(name = "customer", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        if (req.getContentType() == null ||
                !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            Jsonb jsonb = JsonbBuilder.create();
            var customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);
            try {
                writer.println(customerBO.saveCustomer(customerDTO));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        String id = req.getParameter("customerId");
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            Jsonb jsonb = JsonbBuilder.create();
            var customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);
            try {
                writer.println(customerBO.updateCustomer(customerDTO));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("customerId");
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else if (id.equals("all")) {
            try {
                var allCustomerData = customerBO.getAllCustomers();
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(allCustomerData);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                var customerDTO = customerBO.getCustomer(id);
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(customerDTO);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("customerId");
        var writer = resp.getWriter();
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                writer.println(customerBO.deleteCustomer(id));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
