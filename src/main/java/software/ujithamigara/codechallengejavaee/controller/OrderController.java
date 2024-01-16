package software.ujithamigara.codechallengejavaee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ujithamigara.codechallengejavaee.DTO.CustomerDTO;
import software.ujithamigara.codechallengejavaee.DTO.OrderDTO;
import software.ujithamigara.codechallengejavaee.bo.BOFactory;
import software.ujithamigara.codechallengejavaee.bo.custom.OrderBO;

import java.io.IOException;
import java.util.logging.Level;

@WebServlet(name = "order", urlPatterns = "/order")
public class OrderController extends HttpServlet {
    OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        if (req.getContentType() == null ||
                !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                Jsonb jsonb = JsonbBuilder.create();
                var orderDTO = jsonb.fromJson(req.getReader(), OrderDTO.class);
                orderBO.saveOrder(orderDTO);
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        String orderId = req.getParameter("orderId");
        if (orderId == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else if (orderId.equals("all")) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new Hibernate6Module());
                String json = objectMapper.writeValueAsString(orderBO.getAllOrders());
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new Hibernate6Module());
                String json = objectMapper.writeValueAsString(orderBO.getOrder(orderId));
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        String id = req.getParameter("orderId");
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            Jsonb jsonb = JsonbBuilder.create();
            var OrderDTO = jsonb.fromJson(req.getReader(), OrderDTO.class);
            try {
                writer.println(orderBO.updateOrder(OrderDTO));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("orderId");
        var writer = resp.getWriter();
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                writer.println(orderBO.deleteOrder(id));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
